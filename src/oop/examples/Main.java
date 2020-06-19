package oop.examples;

import oop.examples.Account.*;
import oop.examples.Database.Database;
import oop.examples.Enums.Seniority;
import oop.examples.System.Course;
import oop.examples.System.Faculty;
import oop.examples.System.Lesson;
import oop.examples.System.Speciality;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin("Admin", "Admin", "Admin", null, "admin", "admin", true, null, null);
        Database.addUser(admin);
        ArrayList<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality());
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Pakito", "Shamoi", "Pakizar", null, "pakito", "pakito", true, "null", null, Seniority.Bachelor, 10, 10));
        Faculty faculty = new Faculty("FIT", specialities, null, teachers);
        Student student = new Student("Askar", "Datkambek", "Ablayuly", new Date(125125125), "askar", "askar", true, "askar", null, 3, faculty);
        Database.addUser(student);

        while (true) {
            System.out.println("Press [0] to exit");
            System.out.println("Press [1] to log in");
            if (in.nextInt() == 0) break;
            System.out.println("Enter username");
            String username = in.next();
            System.out.println("Enter password");
            String password = in.next();

            for (User u : Database.getAllUsers()) {
                if (u.getUsername().equals(username)) {
                    if (u.getPassword().equals(password)) {
                        while (true) {
                            if (u instanceof Admin) {
                                System.out.println("Press [1] to add some user");
                                System.out.println("Press [2] to get all users");
                                System.out.println("Press [3] to get all students");
                                System.out.println("Press [4] to get all teachers");
                                System.out.println("Press [5] to remove some user");
                                System.out.println("Press [6] to find some user");
                                System.out.println("Press [0] to exit");
                                int first = in.nextInt();
                                if (first == 0) break;
                                else if (first == 1) {
                                    System.out.println("Which user do you want to add?");
                                    System.out.println("[1] Student");
                                    System.out.println("[2] Teacher");
                                    System.out.println("[3] ORManager");
                                    System.out.println("[4] Parent");
                                    System.out.println("[5] TechSupportGuy");
                                    int second = in.nextInt();
                                    User user = addUser(in, second);
                                    if (user == null) System.out.println("User is not added");
                                    else {
                                        Database.addUser(user);
                                        System.out.println("User is created successfully");
                                    }
                                } else if (first == 2) {
                                    System.out.println(Database.getAllUsers());
                                } else if (first == 3) {
                                    System.out.println(Database.getAllStudents());
                                } else if (first == 4) {
                                    System.out.println(Database.getAllTeachers());
                                } else if (first == 6) {
                                    System.out.println("Find by:");
                                    System.out.println("[1] username");
                                    System.out.println("[2] user ID");
                                    System.out.println("[3] name");
                                    int second = in.nextInt();
                                    ArrayList<User> resUsers = findUserBy(in, second);
                                    System.out.println(resUsers);
                                } else break;
                            } else if (u instanceof Teacher) {
                                Teacher teacher = (Teacher) u;
                                System.out.println("Press [1] to see your schedule");
                                System.out.println("Press [2] to see lessons");
                                System.out.println("Press [3] to add marks for student");
                                System.out.println("Press [0] to exit");
                                int first = in.nextInt();
                                if (first == 1) {
                                    System.out.println(teacher.getSchedule());
                                } else if (first == 2) {
                                    System.out.println(teacher.getLessons());
                                } else if (first == 3) {
                                    System.out.println("Choose lesson index and student id:");
                                    for (Lesson lesson : teacher.getLessons()) {
                                        System.out.println(lesson.getFullInfo());
                                    }
                                    int index = in.nextInt();
                                    String studentID = in.next();
                                    System.out.println("Put mark");
                                    int mark = in.nextInt();
                                    ((Teacher) u).addMark(studentID, mark, teacher.getLessons().get(index));
                                    System.out.println("Mark was added successfully");
                                } else break;
                            } else if (u instanceof Student) {
                                Student student2 = (Student) u;
                                if (student2.isBlocked()) {
                                    System.out.println("Your account is blocked");
                                    break;
                                }
                                System.out.println("Press [1] to see journal");
                                System.out.println("Press [2] to see lessons schedule");
                                System.out.println("Press [3] to see exams schedule");
                                System.out.println("Press [4] to see list of courses");
                                System.out.println("Press [5] to change password");
                                System.out.println("Press [6] to see trancript");
                                System.out.println("Press [0] to exit");
                                int first = in.nextInt();
                                if (first == 1) {
                                    System.out.println(student.getLessonsWithMarks());
                                } else if (first == 2) {
                                    System.out.println(student.getLessonSchedule());
                                } else if (first == 3) {
                                    System.out.println(student.getExamSchedule());
                                } else if (first == 4) {
                                    System.out.println(student.getCourses());
                                } else if (first == 5) {
                                    System.out.println("Enter new Password");
                                    String newPassword = in.next();
                                    student.changePassword(newPassword);
                                } else if (first == 6) {
                                    System.out.println(student.getTranscript());
                                } else break;
                            } else if (u instanceof ORManager) {
                                System.out.println("Press [1] to add student to course");
                                System.out.println("Press [2] to create course");
                                System.out.println("Press [3] to remove course");
                                System.out.println("Press [4] to add lessons to students and teacher");
                                System.out.println("Press [0] to exit");
                                int first = in.nextInt();
                                if (first == 1) {
                                    System.out.println("Enter student id");
                                    String studentId = in.next();
                                    for (Student student1 : Database.getAllStudents()) {
                                        if (student1.getId().equals(studentId)) {
                                            System.out.println("Choose course:");
                                            int cnt = 1;
                                            for (Course course : Database.getAllCourses()) {
                                                System.out.println("[" + cnt + "] " + course.getName());
                                            }
                                            int choice = in.nextInt();
                                            student1.addCourse(Database.getAllCourses().get(choice));
                                        }
                                    }
                                } else if (first == 2) {
                                    System.out.println("Enter code");
                                    String code = in.next();
                                    System.out.println("Enter name");
                                    String name = in.next();
                                    System.out.println("Enter credits");
                                    int credits = in.nextInt();
                                    System.out.println("Enter Teacher Id for course");
                                    String teacherId = in.next();
                                    Teacher teacher1 = null;
                                    for (Teacher teacher : Database.getAllTeachers()) {
                                        if (teacher.getId().equals(teacherId)) {
                                            teacher1 = teacher;
                                        }
                                    }
                                    if (teacher1 == null) {
                                        System.out.println("Such teacher id is not found");
                                        System.out.println("Course was created without teacher");
                                    }
                                    Course course = new Course(code, name, credits, teacher1);
                                    Database.getAllCourses().add(course);
                                    System.out.println("Course was created succesfully");
                                } else if (first == 3) {
                                    System.out.println("Enter course name");
                                    String name = in.next();
                                    for (Course course : Database.getAllCourses()) {
                                        if (course.getName().equals(name)) {
                                            Database.getAllCourses().remove(course);
                                            System.out.println("Course was removed successfully");
                                            break;
                                        }
                                    }
                                    System.out.println("Course was not found");
                                } else if (first == 4) {
                                    System.out.println("Which course you wanted to add?");
                                    ArrayList<Course> courses = Database.getAllCourses();
                                    int cnt = 1;
                                    for (Course course : courses) {
                                        System.out.println("[" + cnt + "] " + course.getName());
                                    }
                                    cnt = 1;
                                    int second = in.nextInt();
                                    Course chosen = courses.get(second - 1);
                                    System.out.println("To which teacher would you add this course?");
                                    ArrayList<Teacher> teachers2 = Database.getAllTeachers();
                                    for (Teacher teacher : teachers2) {
                                        System.out.println("[" + cnt + "] " + teacher.getName());
                                    }
                                    int third = in.nextInt();
                                    Teacher teacher = teachers.get(third - 1);

                                    System.out.println("To which students would you add this course?");
                                    System.out.println("Choose many");
                                    ArrayList<Student> students = Database.getAllStudents();
                                    cnt = 1;
                                    for (Student s : students) {
                                        System.out.println("[" + cnt + "] " + s.getName());
                                    }
                                    int fourth = in.nextInt();
                                    ArrayList<Student> chosens = new ArrayList<>();
                                    while (fourth != 0) {
                                        chosens.add(students.get(fourth - 1));
                                        System.out.println("Press [0] to stop choosing");
                                    }
                                    System.out.println("Choose date:");
                                    System.out.println("Year");
                                    long year = in.nextLong();
                                    System.out.println("Month");
                                    long month = in.nextLong();
                                    System.out.println("Day");
                                    long day = in.nextLong();
                                    Random random = new Random();
                                    Lesson lesson = new Lesson(new Date(convertToMillies(year, month, day)), random.nextInt(500), 2, teacher, chosens);

                                    teacher.getSchedule().getLessons().add(lesson);
                                    teacher.getLessons().add(lesson);
                                    Date date = lesson.getDate();
                                    for (Student s : chosens) {
                                        for (int i = 0; i < 10; i++) {
                                            s.getLessonsWithMarks().put(lesson, 0);
                                            lesson.setDate(new Date(convertToMillies(year, month, day + 7)));
                                        }
                                        lesson.setDate(date);
                                        student.getLessonSchedule().getLessons().add(lesson);
                                    }
                                    System.out.println("Lessons were added successfully");
                                } else break;
                            } else if (u instanceof TechSupportGuy) {
                                TechSupportGuy techSupportGuy = (TechSupportGuy) u;
                                System.out.println("All orders: " + techSupportGuy.getOrders());
                                System.out.println("Press [1] to execute all orders");
                                System.out.println("Press [0] to exit");
                                int first = in.nextInt();
                                if (first == 1) {
                                    techSupportGuy.executeAllOrders();
                                    System.out.println("Orders were executed");
                                } else break;
                            }
                        }
                    } else System.out.println("Password is incorrect");
                } else System.out.println("Such username does not exists");
            }
        }
    }

    public static long convertToMillies(long year, long month, long day) {
        return year * month * day * 24 * 60 * 1000;
    }


    public static ArrayList<User> findUserBy(Scanner in, int choise) {
        ArrayList<User> allUsers = Database.getAllUsers();
        ArrayList<User> returnUsers = new ArrayList<>();

        if (choise == 1) {
            String username2 = in.next();
            ArrayList<User> users = new ArrayList<>();
            for (User user : allUsers) {
                if (user.getUsername().equals(username2)) users.add(user);
            }
            System.out.println(users);
        } else if (choise == 2) {
            String userId = in.next();
            for (User user : allUsers) {
                if (user.getId().equals(userId)) returnUsers.add(user);
            }
        } else if (choise == 3) {
            String name = in.next();
            for (User user : allUsers) {
                if (user.getName().equals(name)) returnUsers.add(user);
            }
        }

        return returnUsers;
    }

    public static User addUser(Scanner in, int choice) {
        System.out.println("If you write null, there will be null");
        System.out.println("Enter name");
        String name = in.next();
        System.out.println("Enter surname");
        String surname = in.next();
        System.out.println("Enter patronymic");
        String patronymic = in.next();
        System.out.println("Enter birthday:");
        Date date = null;
        System.out.println("Enter year");
        String year = in.next();
        System.out.println("Enter month");
        String month = in.next();
        System.out.println("Enter day");
        String day = in.next();
        if (year != null && month != null && day != null) {
            date = new Date(convertToMillies(Long.parseLong(year), Long.parseLong(month), Long.parseLong(day)));
        }
        System.out.println("Enter username");
        String username = in.next();
        System.out.println("Enter password");
        String password = in.next();
        System.out.println("Enter gender");
        boolean gender = in.nextBoolean();
        System.out.println("Enter email");
        String email = in.next();
        if (choice == 1) {
            System.out.println("Enter year of study");
            int yearOdStudy = in.nextInt();
            System.out.println("Choose Faculty:");
            for (Faculty faculty1 : Database.getAllFaculties()) {
                System.out.println(faculty1.getName());
            }
            System.out.println("Enter the name of Faculty");
            Faculty faculty = null;
            do {
                String facultyName = in.next();
                if (facultyName.equals("null")) break;
                for (Faculty faculty1 : Database.getAllFaculties()) {
                    if (faculty1.getName().equals(facultyName)) {
                        faculty = faculty1;
                        break;
                    }
                }
            } while (faculty == null);

            return new Student(name, surname, patronymic, date, username, password, gender, email, null, yearOdStudy, faculty);
        } else if (choice > 1 && choice < 6) {
            System.out.println("Enter room number");
            int roomNumber = in.nextInt();
            System.out.println("Enter salary");
            int salary = in.nextInt();

            if (choice == 2) {
                System.out.println("Choose seniority:");
                System.out.println("[1] PhD");
                System.out.println("[2] Master");
                System.out.println("[3] Bachelor");
                Seniority seniority = null;
                String choice2 = in.next();
                if (choice2.equals("1")) seniority = Seniority.PhD;
                if (choice2.equals("2")) seniority = Seniority.Master;
                if (choice2.equals("3")) seniority = Seniority.Bachelor;
                return new Teacher(name, surname, patronymic, date, username, password, gender, email, null, seniority, roomNumber, salary);
            } else if (choice == 3) {
                return new ORManager(name, surname, patronymic, date, username, password, gender, email, null, roomNumber, salary);
            } else if (choice == 4) {
                return new Parent(name, surname, patronymic, date, username, password, gender, email, null);
            } else {
                return new TechSupportGuy(name, surname, patronymic, date, username, password, gender, email, null, roomNumber, salary);
            }
        } else {
            return null;
        }
    }
}