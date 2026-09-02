/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fianl.project.hospital;

/**
 *
 * @author FOR LAPTOP
 */
import java.util.*;
import java.io.*;

public class FinalProjectHospital {

  
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

 
    private static final String PATIENTS_FILE = "data/patients.txt";
    private static final String DOCTORS_FILE = "data/doctors.txt";
    private static final String APPOINTMENTS_FILE = "data/appointments.txt";

    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("============================================");
        System.out.println("  WELCOME TO HOSPITAL MANAGEMENT SYSTEM  ");
        System.out.println("============================================");

        loadData();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getValidIntInput("Enter your choice: ", 1, 11);

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    displayAllPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    removePatient();
                    break;
                case 5:
                    addDoctor();
                    break;
                case 6:
                    displayAllDoctors();
                    break;
                case 7:
                    createAppointment();
                    break;
                case 8:
                    displayAllAppointments();
                    break;
                case 9:
                    saveData();
                    break;
                case 10:
                    saveData();
                    System.out.println("Thank you for using the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n============================================");
        System.out.println("         HOSPITAL MANAGEMENT SYSTEM        ");
        System.out.println("============================================");
        System.out.println("1. Add Patient");
        System.out.println("2. Display All Patients");
        System.out.println("3. Search Patient by ID");
        System.out.println("4. Remove Patient");
        System.out.println("5. Add Doctor");
        System.out.println("6. Display All Doctors");
        System.out.println("7. Create Appointment");
        System.out.println("8. Display All Appointments");
        System.out.println("9. Save Data");
        System.out.println("10. Exit");
        System.out.println("============================================");
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static String getValidStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

    private static int getValidPositiveInt(String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double getValidDouble(String prompt) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Please enter a valid amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void addPatient() {
        System.out.println("\n--- Add New Patient ---");

        String id = getValidStringInput("Enter Patient ID: ");

        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                System.out.println("Error: Patient ID already exists!");
                return;
            }
        }

        String name = getValidStringInput("Enter Patient Name: ");
        int age = getValidPositiveInt("Enter Age: ");
        String gender = getValidStringInput("Enter Gender (M/F): ");
        String disease = getValidStringInput("Enter Disease: ");
        int roomNumber = getValidPositiveInt("Enter Room Number: ");

        Patient patient = new Patient(id, name, age, gender, disease, roomNumber);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void displayAllPatients() {
        System.out.println("\n All Patients ");
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("|  ID   |    Name    | Age | Gender | Disease       | Room Number |");

        for (Patient p : patients) {
            System.out.println(p.getId() + "|" + p.getName() + "|" + p.getAge() + "|" + p.getGender() + "|" + p.getDisease() + "|" + p.getRoomNumber());

        }

        System.out.println("Total Patients: " + patients.size());
    }

    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        String id = getValidStringInput("Enter Patient ID: ");

        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                p.displayInfo();
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    private static void removePatient() {
        System.out.println("\n Remove Patient ");
        String id = getValidStringInput("Enter Patient ID: ");

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                System.out.println("Patient found: " + patients.get(i).getName());
                System.out.print("Are you sure you want to remove this patient? (y/n): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (confirm.equals("y") || confirm.equals("yes")) {
                    patients.remove(i);
                    System.out.println("Patient removed successfully!");
                } else {
                    System.out.println("Removal cancelled.");
                }
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    private static void addDoctor() {
        System.out.println("\n--- Add New Doctor ---");

        String id = getValidStringInput("Enter Doctor ID: ");

        for (Doctor d : doctors) {
            if (d.getId().equals(id)) {
                System.out.println("Error: Doctor ID already exists!");
                return;
            }
        }

        String name = getValidStringInput("Enter Doctor Name: ");
        int age = getValidPositiveInt("Enter Age: ");
        String gender = getValidStringInput("Enter Gender (M/F): ");
        String specialization = getValidStringInput("Enter Specialization: ");
        double salary = getValidDouble("Enter Salary: ");

        Doctor doctor = new Doctor(id, name, age, gender, specialization, salary);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void displayAllDoctors() {
        System.out.println("\n All Doctors ");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("|    ID    |     Name     |     Age    |    Gender   |    Specialization   |   Salary  |");

        for (Doctor d : doctors) {

            System.out.println(d.getId() + "|" + d.getName() + "|" + d.getAge() + "|" + d.getGender() + "|" + d.getSpecialization() + "|" + d.getSalary());

        }

        System.out.println("Total Doctors: " + doctors.size());
    }

    private static void createAppointment() {
        System.out.println("\n--- Create Appointment ---");

        if (patients.isEmpty()) {
            System.out.println("No patients available. Please add a patient first.");
            return;
        }
        if (doctors.isEmpty()) {
            System.out.println("No doctors available. Please add a doctor first.");
            return;
        }

        String appointmentID = getValidStringInput("Enter Appointment ID: ");

        for (Appointment a : appointments) {
            if (a.getAppointmentID().equals(appointmentID)) {
                System.out.println("Error: Appointment ID already exists!");
                return;
            }
        }

        System.out.println("Available Patients:");
        for (Patient p : patients) {
            System.out.println(p.getId() + " - " + p.getName());
        }
        String patientId = getValidStringInput("Enter Patient ID: ");
        Patient selectedPatient = null;
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                selectedPatient = p;
                break;
            }
        }
        if (selectedPatient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Available Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  " + d.getId() + " - " + d.getName() + " (" + d.getSpecialization() + ")");
        }
        String doctorId = getValidStringInput("Enter Doctor ID: ");
        Doctor selectedDoctor = null;
        for (Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                selectedDoctor = d;
                break;
            }
        }
        if (selectedDoctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        String date = getValidStringInput("Enter Date (DD/MM/YYYY): ");
        String time = getValidStringInput("Enter Time (HH:MM AM/PM): ");

        for (Appointment a : appointments) {
            if (a.getDoctor().getId().equals(doctorId)
                    && a.getDate().equals(date)
                    && a.getTime().equals(time)) {
                System.out.println("Warning: This doctor already has an appointment at this time!");
                System.out.print("Do you want to continue anyway? (y/n): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (!confirm.equals("y") && !confirm.equals("yes")) {
                    System.out.println("Appointment creation cancelled.");
                    return;
                }
            }
        }

        Appointment appointment = new Appointment(appointmentID, selectedPatient, selectedDoctor, date, time);
        appointments.add(appointment);
        System.out.println("Appointment created successfully!");
    }

    private static void displayAllAppointments() {
        System.out.println("\n All Appointments ");
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println("|  Appointment ID  |  Patient Name    |  Doctor Name    |    Date         |     Time        |");

        for (Appointment a : appointments) {
            System.out.println(a.getAppointmentID() + "|" + a.getPatient().getName() + "|" + a.getDoctor().getName() + "|" + a.getDate() + "|" + a.getTime());

        }

        System.out.println("Total Appointments: " + appointments.size());
    }

    private static void saveData() {
        System.out.println("\n Saving Data ");

        try {

            saveToFile(PATIENTS_FILE, patients);

            saveToFile(DOCTORS_FILE, doctors);

            saveAppointmentsToFile(APPOINTMENTS_FILE, appointments);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void saveToFile(String filename, ArrayList<?> list) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Object obj : list) {
                writer.println(obj.toString());
            }
        }
    }

    private static void saveAppointmentsToFile(String filename, ArrayList<Appointment> list) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Appointment a : list) {
                writer.println(a.toString());
            }
        }
    }

    private static void loadData() {
        System.out.println("Loading data from files...");

        try {

            loadPatientsFromFile(PATIENTS_FILE);

            loadDoctorsFromFile(DOCTORS_FILE);

            loadAppointmentsFromFile(APPOINTMENTS_FILE);
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No existing data files found. Starting with empty system.");
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private static void loadPatientsFromFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    Patient patient = new Patient(parts[0], parts[1], Integer.parseInt(parts[2]),
                            parts[3], parts[4], Integer.parseInt(parts[5]));
                    patients.add(patient);
                }
            }
        }
    }

    private static void loadDoctorsFromFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    Doctor doctor = new Doctor(parts[0], parts[1], Integer.parseInt(parts[2]),
                            parts[3], parts[4], Double.parseDouble(parts[5]));
                    doctors.add(doctor);
                }
            }
        }
    }

    private static void loadAppointmentsFromFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String appId = parts[0];
                    String patientId = parts[1];
                    String doctorId = parts[2];
                    String date = parts[3];
                    String time = parts[4];

                    Patient patient = null;
                    Doctor doctor = null;

                    for (Patient p : patients) {
                        if (p.getId().equals(patientId)) {
                            patient = p;
                            break;
                        }
                    }

                    for (Doctor d : doctors) {
                        if (d.getId().equals(doctorId)) {
                            doctor = d;
                            break;
                        }
                    }

                    if (patient != null && doctor != null) {
                        Appointment appointment = new Appointment(appId, patient, doctor, date, time);
                        appointments.add(appointment);
                    }
                }
            }
        }

    }

}
