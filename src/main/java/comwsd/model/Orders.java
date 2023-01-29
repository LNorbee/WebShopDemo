package comwsd.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue
	private int id;
		
	// Több rendelés is tartozhat egy vásárlóhoz
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customers customer;
	
	private Date date;

	public Orders() {
		
	}

	public Orders(int id, Customers customer, Date date) {
		super();
		this.id = id;
		this.customer = customer;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
