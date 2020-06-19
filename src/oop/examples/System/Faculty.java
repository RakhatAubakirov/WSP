package oop.examples.System;
import oop.examples.Account.Dean;
import oop.examples.Account.Teacher;

import java.util.*;
public class Faculty {
	private String name;
	private ArrayList<Speciality> specialities = new ArrayList<Speciality>();
	private Dean dean;
	private ArrayList<Teacher> teachers = new ArrayList<>();

	public Faculty(String name, ArrayList<Speciality> specialities, Dean dean, ArrayList<Teacher> teachers) {
		this.name = name;
		this.specialities = specialities;
		this.dean = dean;
		this.teachers = teachers;
	}

	public Faculty() {
	}

	public Faculty(String name, ArrayList<Speciality> specialities, Dean dean) {
		this.name = name;
		this.specialities = specialities;
		this.dean = dean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(ArrayList<Speciality> specialities) {
		this.specialities = specialities;
	}

	public Dean getDean() {
		return dean;
	}

	public void setDean(Dean dean) {
		this.dean = dean;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String toString() {
		return  specialities + " " + dean + " " + teachers;
	}
}
