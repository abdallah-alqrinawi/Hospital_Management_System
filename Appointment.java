/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fianl.project.hospital;

import java.io.Serializable;

/**
 *
 * @author FOR LAPTOP
 */
public class Appointment implements Serializable {

    private String appointmentID;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    
    public Appointment() {
    }

    
    public Appointment(String appointmentID, Patient patient, Doctor doctor, String date, String time) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    
    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void displayAppointment() {
        System.out.println("All Appointment Information ");
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
   
    }

    @Override
    public String toString() {
        return appointmentID + "," + patient.getId() + "," + doctor.getId() + "," + date + "," + time;
    }

}
