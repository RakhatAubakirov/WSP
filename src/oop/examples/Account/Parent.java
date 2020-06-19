package oop.examples.Account;

import oop.examples.System.Mail;
import oop.examples.System.MyDocuments;

import java.util.*;
public class Parent extends User {
	private ArrayList<Mail> mails;

	public Parent(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents) {
		super(name, surname, patronymic, birthday, username, password, gender, email, documents);
	}

	public void readMail() {
		for(Mail mail : mails) {
			mail.read();
		}
	}

	public ArrayList<Mail> getMails() {
		return mails;
	}

	public void setMails(ArrayList<Mail> mails) {
		this.mails = mails;
	}

	public String toString() {
		return super.toString() + mails + " ";
	}
}
