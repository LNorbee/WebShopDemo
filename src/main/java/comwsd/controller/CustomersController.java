package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import comwsd.model.Customer;
import comwsd.service.CustomerService;

@RestController
public class CustomersController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> list(){
		return customerService.listAll();
	}
}
