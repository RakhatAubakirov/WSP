package oop.examples.Account;

import oop.examples.Database.Database;
import oop.examples.System.MyDocuments;

import java.util.*;

public class Buh extends Employee {

    public Buh(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents, roomNumber, salary);
    }

    public void blockAccount(String accountId) {
        ArrayList<Student> students = Database.getAllStudents();
        for (Student student : students) {
            student.setBlocked(true);
        }
    }

    public void unblock(String accountId) {
        ArrayList<Student> students = Database.getAllStudents();
        for (Student student : students) {
            student.setBlocked(false);
        }
    }
}
