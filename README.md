# Hospital Management System

## About the Project
A hospital management system developed in Java to manage patients, doctors, and appointments efficiently. 
This project demonstrates Object-Oriented Programming (OOP) concepts including inheritance, polymorphism, encapsulation, and file handling.

## Features
- Add, display, search, and remove patients
- Add and display doctors
- Create and display appointments
- Save data to text files
- Load data from text files on startup
- Input validation and exception handling
- Emergency patient support with priority levels
- Appointment conflict detection

## Technologies Used
- Java
- ArrayList
- File I/O (Text Files)
- OOP Principles

## How to Run
1. Make sure JDK is installed on your system
2. Open terminal in the project folder
3. Compile the files:
   javac fianl/project/hospital/*.java
4. Run the program:
   java fianl.project.hospital.FianlProjectHospital

## Main Menu
1. Add Patient
2. Display All Patients
3. Search Patient by ID
4. Remove Patient
5. Add Doctor
6. Display All Doctors
7. Create Appointment
8. Display All Appointments
9. Save Data
10. Exit

## Project Structure
- Person.java - Base class
- Patient.java - Patient class (inherits Person)
- Doctor.java - Doctor class (inherits Person)
- EmergencyPatient.java - Emergency patient (inherits Patient)
- Appointment.java - Appointment class
- FianlProjectHospital.java - Main class with menu and logic

## Developer
- Name: [Abdallah Alqrinawi]
- Course: Java - Final Project
