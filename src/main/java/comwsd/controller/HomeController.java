package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import comwsd.model.Customers;
import comwsd.model.Orders;
import comwsd.model.Products;
import comwsd.repository.CustomerRepository;
import comwsd.repository.OrderRepository;
import comwsd.repository.ProductRepository;

@Controller
public class HomeController {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderRepository orderRepo;

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("customers", getCustomer());
		model.addAttribute("products", getProduct());
		model.addAttribute("orders", getOrder());
		return "index";
	} 

	@RequestMapping("/customerRegister")
	public String customer(Model model) {
		return "customerRegister";
	}
	
	@RequestMapping("/productRegister")
	public String product(Model model){
		return "productRegister";
	}
	
	@RequestMapping("/orders")
	public String order(Model model) {
		return "orders";
	}

	private List<Customers> getCustomer(){
		List<Customers> customers = customerRepo.findAll();

		return customers;
	}

	private List<Products> getProduct(){
		List<Products> products = productRepo.findAll();

		return products;
	}
	
	private List<Orders> getOrder(){
		List<Orders> orders = orderRepo.findAll();
		
		return orders;
	}
}