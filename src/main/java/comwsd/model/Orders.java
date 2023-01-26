package comwsd.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private int id;
		
	// Több rendelés is tartozhat egy vásárlóhoz
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customers customer;
	
	// Egy rendeléshez több termék is tartozhat
	@OneToMany
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Products> product;
	
	public Orders() {
		
	}

	public Orders(int id, Customers customer, List<Products> product) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}	
	
}
