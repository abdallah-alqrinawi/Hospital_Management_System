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
public class Doctor extends Person {

    private String specialization;
    private double salary;

    
    public Doctor() {
    }

   
    public Doctor(String id, String name, int age, String gender, String specialization, double salary) {
        super(id, name, age, gender);
        this.specialization = specialization;
        this.salary = salary;
    }

    
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   
    @Override
    public void displayInfo() {
        System.out.println("All Doctor Information ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: $" + salary);
    }

    @Override
    public String toString() {
        return super.toString() + "," + specialization + "," + salary;
    }

}
