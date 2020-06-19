package oop.examples.Account;

import oop.examples.System.MyDocuments;

import java.util.Date;

public abstract class User {
    private static int idCnt;
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;
    private String username;
    private String password;
    private boolean gender;
    private String email;
    private MyDocuments documents;

    static {
        idCnt = 0;
    }

    {
        id = idCnt++ + "";
    }

    public User(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.documents = documents;
    }

    public void changePassword(String newPassword) {
        this.setPassword(newPassword);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(MyDocuments documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", documents=" + documents +
                '}';
    }
}
