package oop.examples.Account;

import oop.examples.System.MyDocuments;

import java.util.Date;

public class Dean extends Employee {
    public Dean(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents, roomNumber, salary);
    }
}
