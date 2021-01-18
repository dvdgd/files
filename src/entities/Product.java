package entities;

public class Product {
	
	String name;
	Double price;
	Integer quantity;
	
	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Double totalValue() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return name + "; " + totalValue();
	}
}
