package standard.March2019.prob1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prob1 {
	
	static double getTotalPrice(List<Order> orders, List<Customer> customers) {
		return customers.stream().flatMap(c->c.getOrders().stream())
				.filter(o->orders.contains(o) && o.getOrderDate().isAfter(LocalDate.of(2018,6,1)))
				.collect(Collectors.summingDouble(e->e.getTotalPrice()));
	}
	
	static List<Integer> findProductIds(List<OrderItem> orderItems){
		return orderItems.stream()
				.filter(o->o.getQuantity() > 3 && o.getProduct().getPrice()>10)
				.map(m->m.getProduct().getProductId())
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}



	public static void main(String[] args) {

		//creating products
		Product p1 = new Product(101, "PopCorn", "Snack", 5);
		Product p2 = new Product(102, "Coke", "Drink", 3);
		Product p3 = new Product(103, "Chicken", "Food", 13);
		Product p4 = new Product(104, "Beef", "Food", 90);
		Product p5 = new Product(105, "Pretzel", "Snack", 1);
		Product p6 = new Product(106, "Chips", "Snack", 4);
		Product p7 = new Product(107, "Sprite", "Drink", 2);
		Product p8 = new Product(108, "Fanta", "Drink", 2);
		Product p9 = new Product(109, "Fish", "Food", 12);
		Product p10 = new Product(110, "Chocolate", "Snack", 2);
		Product p11 = new Product(111, "Water", "Drink", 1);
		Product p12 = new Product(112, "Fries", "Snack", 11);

		//creating list of OrderItems
		OrderItem[] itemArray1 = {new OrderItem(p1, 3), new OrderItem(p2, 1)};
		List<OrderItem> itemList1= Arrays.asList(itemArray1);

		OrderItem[] itemArray2 = {new OrderItem(p3, 4), new OrderItem(p4, 2), new OrderItem(p5, 8)};
		List<OrderItem> itemList2= Arrays.asList(itemArray2);

		OrderItem[] itemArray3 = {new OrderItem(p6, 3)};
		List<OrderItem> itemList3= Arrays.asList(itemArray3);

		OrderItem[] itemArray4 = {new OrderItem(p6, 2), new OrderItem(p8, 7)};
		List<OrderItem> itemList4= Arrays.asList(itemArray4);

		OrderItem[] itemArray5 = {new OrderItem(p9, 1), new OrderItem(p10, 4)};
		List<OrderItem> itemList5= Arrays.asList(itemArray5);

		OrderItem[] itemArray6 = {new OrderItem(p11, 2), new OrderItem(p12, 1)};
		List<OrderItem> itemList6= Arrays.asList(itemArray6);

		//creating Payments
		Payment payment1 = new Payment(401, "4400 5567 8877 9900", PaymentType.CREDIT);
		Payment payment2 = new Payment(402, "3300 5567 8877 9900", PaymentType.DEBIT);
		Payment payment3 = new Payment(403, "2200 5567 8877 9900", PaymentType.CREDIT);
		Payment payment4 = new Payment(404, "4400 5567 8877 9900", PaymentType.CREDIT);
		Payment payment5 = new Payment(405, "5500 5567 8877 9900", PaymentType.DEBIT);
		Payment payment6 = new Payment(406, "7700 5567 8877 9900", PaymentType.DEBIT);

		//creating Orders and assigning Payment
		Order order1  = new Order(201, itemList1, LocalDate.of(2018, 7, 1));
		order1.setPayment(payment1);
		Order order2  = new Order(202, itemList2, LocalDate.of(2018, 5, 2));
		order2.setPayment(payment2);
		Order order3  = new Order(203, itemList3, LocalDate.of(2018, 8, 3));
		order3.setPayment(payment3);
		Order order4  = new Order(204, itemList4, LocalDate.of(2018, 5, 4));
		order4.setPayment(payment4);
		Order order5  = new Order(205, itemList5, LocalDate.of(2018, 9, 5));
		order5.setPayment(payment5);
		Order order6  = new Order(206, itemList6, LocalDate.of(2018, 3, 6));
		order6.setPayment(payment6);

		//creating customers and adding orders
		Customer cust1 = new Customer(301, "John");
		cust1.addOrder(order1);
		cust1.addOrder(order2);
		cust1.addOrder(order3);
		Customer cust2 = new Customer(302, "Marry");
		cust2.addOrder(order4);
		cust2.addOrder(order5);
		Customer cust3 = new Customer(303, "Daniel");
		cust3.addOrder(order6);

		//creating List of Customers
		List<Customer> allCustomers = new ArrayList<>();
		allCustomers.add(cust1);
		allCustomers.add(cust2);
		allCustomers.add(cust3);

		List<Customer> customers1 = new ArrayList<>();
		customers1.add(cust1);
		customers1.add(cust2);

		//creating List of Orders
		List<Order> allOrders = new ArrayList<>();
		allOrders.add(order1);
		allOrders.add(order2);
		allOrders.add(order3);
		allOrders.add(order4);
		allOrders.add(order5);
		allOrders.add(order6);

		List<Order> orders1 = new ArrayList<>();
		orders1.add(order1);
		orders1.add(order2);
		orders1.add(order4);

		List<Order> orders2 = new ArrayList<>();
		orders2.add(order1);
		orders2.add(order3);
		orders2.add(order6);

		//creating list of Order Items
		OrderItem[] all = {new OrderItem(p1, 3), new OrderItem(p2, 1), new OrderItem(p3, 4),
				new OrderItem(p4, 2), new OrderItem(p5, 8), new OrderItem(p6, 3),
				new OrderItem(p7, 2), new OrderItem(p8, 7), new OrderItem(p9, 5),
				new OrderItem(p10, 4), new OrderItem(p11, 2), new OrderItem(p12, 1)};
		List<OrderItem> allOrderItems = Arrays.asList(all);
		
		/* expected result 
		 * 
			TOTAL PRICE = 30.00
			------------------------------------------------------
			IDs: [103, 109]

		 *
		*/
		System.out.printf("TOTAL PRICE = %,.2f", getTotalPrice(orders2, allCustomers));
		System.out.println("\n------------------------------------------------------");
		System.out.println("IDs: " + findProductIds(allOrderItems));

	}

}
