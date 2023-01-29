package comwsd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comwsd.model.Customers;
import comwsd.service.CustomerService;

@RestController
public class CustomersController {

	@Autowired
	private CustomerService customerService;
	
	// postman
	// http://localhost:8080/customers
	
	//Vissza adja az összes Customer-t a Customers táblából
	@GetMapping(value = "/customers")
	public List<Customers> listCustomer(){
		return customerService.listAllCustomer();
	}
	
//	@GetMapping(value = "/customers")
//	public List<Customers> listCustomer(){
//		List<Customers> customers = new ArrayList<>();
//		customers.add(new Customers("Abra", "Kadabra", "ak@mail.com", 007));
//		return customers;
//	}
	
	//id alapján adja vissza a Customer-t
	@GetMapping(value = "/customers/{id}")
	public ResponseEntity<Customers> getCustomer(@PathVariable Integer id){
		Customers customer = customerService.getCustomer(id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}
	
	//új Customer-t adunk hozzá
	@PostMapping(value = "/customers")
	public void addCustomer(@RequestBody Customers customer) {
		customerService.save(customer);
	}	
}