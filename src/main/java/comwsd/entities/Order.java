package comwsd.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private int order_id;
	
	
	// Több Order-hez egy customer tartozhat
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	// Egy Order-hez több product is tartozhat (ezért kell a List)
	@OneToMany	//(mappedBy="order")
	@JoinColumn(name = "product_id")
	private List<Product> products;
	
	private Order() {
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
