package oop.examples.Account;

import oop.examples.Database.Database;
import oop.examples.System.Course;
import oop.examples.System.Lesson;
import oop.examples.System.MyDocuments;

import java.util.ArrayList;
import java.util.Date;

public class ORManager extends Employee {
    public ORManager(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, int roomNumber, int salary) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents, roomNumber, salary);
    }

    public void registerToCourse(Student student, String courseName) {
        for (Student student1 : Database.getAllStudents()) {
            if (student.getId().equals(student1.getId())) {
                student1.getCourses().add(courseName);
            }
        }
    }

    public boolean createCourse(Course course) {
        ArrayList<Course> courses = Database.getAllCourses();
        for (Course course1 : courses) {
            if (course.getName().equals(course1.getName())) {
                return false;
            }
        }
        Database.getAllCourses().add(course);
        return true;
    }

    public boolean deleteCourse(Course course) {
        return Database.deleteCourse(course);
    }

    public void addLessons(Lesson lesson, Teacher teacher, ArrayList<Student> students){
        teacher.getSchedule().getLessons().add(lesson);
        for (int i=0;i<10;i++){
            teacher.getLessons().add(lesson);
        }

        for (Student student:students){
            for (int i=0;i<10;i++){
                student.getLessonsWithMarks().put(lesson,0);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "ORManager";
    }
}
