package oop.examples.Database;

import oop.examples.Account.*;
import oop.examples.Account.Parent;
import oop.examples.System.Course;
import oop.examples.System.Faculty;

import java.util.ArrayList;

public class Database {
	private static ArrayList<Student> allStudents = new ArrayList<>();
	private static ArrayList<Course> allCourses = new ArrayList<>();
	private static ArrayList<Teacher> allTeachers = new ArrayList<>();
	private static ArrayList<User> allUsers = new ArrayList<>();
	private static ArrayList<Faculty> allFaculties = new ArrayList<>();
	private static ArrayList<Parent> allParents = new ArrayList<>();
	private static ArrayList<ORManager> allManagers = new ArrayList<>();
	private static ArrayList<TechSupportGuy> allTechSupportGuys = new ArrayList<>();
	private static ArrayList<Buh> buhs = new ArrayList<>();

	public static ArrayList<Student> getAllStudents() {
		return allStudents;
	}

	public static boolean addUser(User user){
		getAllUsers().add(user);
		if (user instanceof Student){
			Student student = (Student)user;
			allStudents.add(student);
			return true;
		}else if (user instanceof Teacher){
			Teacher teacher = (Teacher)user;
			allTeachers.add(teacher);
			return true;
		}else if (user instanceof Parent){
			Parent parent = (Parent)user;
			allParents.add(parent);
			return true;
		}else if (user instanceof ORManager){
			ORManager orManager = (ORManager)user;
			allManagers.add(orManager);
			return true;
		}else if(user instanceof TechSupportGuy){
			TechSupportGuy techSupportGuy = (TechSupportGuy)user;
			allTechSupportGuys.add(techSupportGuy);
			return true;
		}else if(user instanceof Buh){
			Buh buh = (Buh)user;
			buhs.add(buh);
			return true;
		}else if (user instanceof Admin){
			return true;
		}
		return false;
	}

	public static ArrayList<Course> getAllCourses() {
		return allCourses;
	}

	public static boolean deleteCourse(Course course){
		for (Course course1:allCourses){
			if (course.getName().equals(course1)){
				allCourses.remove(course);
				return true;
			}
		}
		return false;
	}
	public static ArrayList<Teacher> getAllTeachers() {
		return allTeachers;
	}

	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}

	public static ArrayList<Faculty> getAllFaculties() {
		return allFaculties;
	}

	public static ArrayList<Parent> getAllParents() {
		return allParents;
	}

	public static ArrayList<ORManager> getAllManagers() {
		return allManagers;
	}

	public static ArrayList<TechSupportGuy> getAllTechSupportGuys() {
		return allTechSupportGuys;
	}

	public static ArrayList<Buh> getBuhs() {
		return buhs;
	}
}
