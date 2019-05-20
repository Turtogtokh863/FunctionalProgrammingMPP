package standard.March2019.prob1;

import java.time.LocalDate;
import java.util.List;

public class Order {
	
	private int orderId;
	private LocalDate orderDate;
	private List<OrderItem> items;
	private Payment payment;
	
	public Order(int orderId, List<OrderItem> items, LocalDate orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.items = items;
		this.setPayment(new Payment());
	}

	public int getOrderId() {
		return orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItems(OrderItem oi) {
		items.add(oi);
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for(OrderItem i : items) {
			total += i.getTotalPrice();
		}
		return total;
	}
	
	
	
	

}
