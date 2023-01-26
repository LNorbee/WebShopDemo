package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import comwsd.model.Customer;
import comwsd.model.Product;
import comwsd.repository.CustomerRepository;
import comwsd.repository.ProductRepository;

@Controller
public class HomeController {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ProductRepository productRepo;


	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("customers", getCustomer());
		model.addAttribute("products", getProduct());
		return "index";
	} 

	@RequestMapping("/customerRegister")
	public String customer(Model model) {
		return "customerRegister";
	}
	
	@RequestMapping("/productRegister")
	public String product(Model model){
		//model.addAttribute("productRegister", model)
		return "productRegister";
	}
	
	@RequestMapping("/customersData")
	public String customersData(Model model){
		model.addAttribute("customers", getCustomer());
		return "customersData";
	}

	@RequestMapping("/productsData")
	public String productsData(Model model){
		model.addAttribute("products", getProduct());
		return "productsData";
	}


	private List<Customer> getCustomer(){
		List<Customer> customers = customerRepo.findAll();

		return customers;
	}

	private List<Product> getProduct(){
		List<Product> products = productRepo.findAll();

		return products;
	}





}