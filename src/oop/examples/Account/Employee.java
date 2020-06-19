package oop.examples.Account;

import oop.examples.System.MyDocuments;

import java.util.Date;

public abstract class Employee extends User {

    private int roomNumber;
    private int salary;

    public Employee(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents);
        this.roomNumber = roomNumber;
        this.salary = salary;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(int roomNumber, int salary) {
        return super.toString() + roomNumber + " " + salary;
    }
}
