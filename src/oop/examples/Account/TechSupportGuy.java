package oop.examples.Account;
import oop.examples.System.MyDocuments;
import oop.examples.System.Order;

import java.util.*;
public class TechSupportGuy extends Employee {
	private ArrayList<Order> orders;

	public TechSupportGuy(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents, int roomNumber, int salary) {
		super(name, surname, patronymic, birthday, username, password, gender, email, documents, roomNumber, salary);
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void executeAllOrders() {
		for(Order order : this.orders) {
			order.setExecuted(true);
		}
	}
	public String toString() {
		return super.toString() + "Order: "+orders;
	}
	
}
