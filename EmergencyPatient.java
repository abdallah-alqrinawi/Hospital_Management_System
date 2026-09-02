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
public class EmergencyPatient extends Patient {

    private int priorityLevel; 

    public EmergencyPatient() {
    }

    public EmergencyPatient(String id, String name, int age, String gender,
            String disease, int roomNumber, int priorityLevel) {
        super(id, name, age, gender, disease, roomNumber);
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Priority Level: " + priorityLevel + " (1=High , 3=Low)");
        System.out.println(" EMERGENCY PATIENT ");
    }

    @Override
    public String toString() {
        return super.toString() + "," + priorityLevel;
    }

}
