package oop.examples.Account;

import oop.examples.Database.Database;
import oop.examples.System.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Student extends User{
    private int yearOfStudy;
    private Faculty faculty;
    private Schedule lessonSchedule;
    private Schedule examSchedule;
    private ArrayList<String> courses;
    private String parentId;
    private boolean blocked;
    private HashMap<Lesson, Integer> lessonsWithMarks;

    {
        blocked = false;
    }

    public Student(String name,
                   String surname,
                   String patronymic,
                   Date birthday,
                   String username,
                   String password,
                   boolean gender,
                   String email,
                   MyDocuments documents,
                   int yearOfStudy,
                   Faculty faculty) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents);
        this.yearOfStudy = yearOfStudy;
        this.faculty = faculty;
    }

    public Student(String name,
                   String surname,
                   String patronymic,
                   Date birthday,
                   String username,
                   String password,
                   boolean gender,
                   String email,
                   MyDocuments documents,
                   int yearOfStudy,
                   Faculty faculty,
                   Schedule lessonSchedule,
                   ArrayList<String> courses,
                   String parentId) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents);
        this.yearOfStudy = yearOfStudy;
        this.faculty = faculty;
        this.lessonSchedule = lessonSchedule;
        this.courses = courses;
        this.parentId = parentId;
    }

    public HashMap<Lesson, Integer> getLessonsWithMarks() {
        return lessonsWithMarks;
    }

    public void setLessonsWithMarks(HashMap<Lesson, Integer> lessonsWithMarks) {
        this.lessonsWithMarks = lessonsWithMarks;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean registerToCourse(String courseName) {
        ArrayList<Course> allCourses = Database.getAllCourses();
        for (Course course : allCourses) {
            if (course.getName().equals(courseName)) {
                courses.add(courseName);
                return true;
            }
        }
        return false;
    }

    public boolean dropCourse(String courseName) {
        for (String name : courses) {
            if (name.equals(courseName)) {
                courses.remove(name);
                return true;
            }
        }
        return false;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getTranscript() {
        return lessonsWithMarks.toString();
    }


    public Schedule getLessonSchedule() {
        return lessonSchedule;
    }

    public void setLessonSchedule(Schedule lessonSchedule) {
        this.lessonSchedule = lessonSchedule;
    }

    public Schedule getExamSchedule() {
        return examSchedule;
    }

    public void setExamSchedule(Schedule examSchedule) {
        this.examSchedule = examSchedule;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "yearOfStudy=" + yearOfStudy +
                ", faculty=" + faculty +
                ", courses=" + courses +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    public boolean addCourse(Course course) {
        courses.add(course.getName());
        return false;
    }

    public boolean dropCoures(String courseName) {
        courses.remove(courseName);
        return false;
    }
}
