package standard.March2019.prob1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	private List<Payment> payments;
	private List<Order> orders;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		this.payments = new ArrayList<>();
		this.orders = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public void addPayment(Payment p) {
		payments.add(p);
	}

}
