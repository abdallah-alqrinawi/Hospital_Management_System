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
public class Patient extends Person {

    private String disease;
    private int roomNumber;

    
    public Patient() {
    }

    
    public Patient(String id, String name, int age, String gender, String disease, int roomNumber) {
        super(id, name, age, gender);
        this.disease = disease;
        this.roomNumber = roomNumber;
    }

    
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    
    @Override
    public void displayInfo() {
        System.out.println(" Patient Information ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Disease: " + disease);
        System.out.println("Room Number: " + roomNumber);
    }

    @Override
    public String toString() {
        return super.toString() + "," + disease + "," + roomNumber;
    }

}
