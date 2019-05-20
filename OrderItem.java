package standard.March2019.prob1;

public class OrderItem {
	
	private int quantity;
	private Product product;
	
	public OrderItem(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotalPrice() {
		return product.getPrice() * this.quantity;
	}	

}
