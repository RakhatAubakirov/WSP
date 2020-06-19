package oop.examples.System;

import java.util.*;
public class Schedule {
	private ArrayList<Lesson> lessons;
	private boolean type;

	public Schedule() {
	}

	public Schedule(ArrayList<Lesson> lessons, boolean type) {
		this.lessons = lessons;
		this.type = type;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String toString() {
		return lessons + " " + type;
	}
	
}
