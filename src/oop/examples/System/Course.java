package oop.examples.System;

import oop.examples.Account.Teacher;

public class Course{
	private String code;
	private String name;
	private int credits;
	private Teacher teacher;
	
	public Course(String code, String name, int credits, Teacher teacher){
		this.code=code;
		this.name=name;
		this.credits=credits;
		this.teacher=teacher;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String toString() {
		return code + " " + name + " " + credits + " " + teacher;
	}
}
