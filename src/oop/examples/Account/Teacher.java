package oop.examples.Account;

import oop.examples.Database.Database;
import oop.examples.Enums.Seniority;
import oop.examples.System.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Teacher extends Employee{
    private Seniority seniority;
    private ArrayList<Lesson> lessons;
    private Schedule schedule;

    public Teacher(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, Seniority seniority, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents, roomNumber, salary);
        this.seniority = seniority;
    }

    public Teacher(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, Seniority seniority, ArrayList<Lesson> lessons, Schedule schedule, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents,roomNumber, salary);
        this.seniority = seniority;
        this.lessons = lessons;
        this.schedule = schedule;
    }

    public void addMark(String studentId, int mark, Lesson lesson){
        ArrayList<Student> students = Database.getAllStudents();
        for (Student student:students){
            if (student.getId().equals(studentId)){
                HashMap<Lesson, Integer> lessonsWithMarks = student.getLessonsWithMarks();
                lessonsWithMarks.put(lesson, mark);
            }
        }
    }

    public void manageCourse(Course course){

    }
    public void sendOrder(Order order){

    }
    public void sendMail(Mail mail, String parentId){

    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "seniority=" + seniority +
                ", lessons=" + lessons +
                ", schedule=" + schedule +
                '}';
    }
}