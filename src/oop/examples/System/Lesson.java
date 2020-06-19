package oop.examples.System;

import oop.examples.Account.Student;
import oop.examples.Account.Teacher;

import java.util.ArrayList;
import java.util.Date;

public class Lesson {
    private String courseName;
    private Date date;
    private int roomNumber;
    private int duration;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Lesson(Date date, int roomNumber, int duration, Teacher teacher, ArrayList<Student> students) {
        this.date = date;
        this.roomNumber = roomNumber;
        this.duration = duration;
        this.teacher = teacher;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String toString() {
        return courseName + " --- " + teacher;
    }

    public String getFullInfo() {
        return courseName + " " + date + " " + roomNumber + " " + duration + " " + teacher + "{" + students + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (!(obj instanceof Lesson))
            return false;
        Lesson les = (Lesson) obj;
        return this.duration == les.duration;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode() + roomNumber * roomNumber + duration * duration);
        return result;
    }

}
