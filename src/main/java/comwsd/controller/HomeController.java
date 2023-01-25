package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import comwsd.entities.Customers;
import comwsd.entities.Products;
import comwsd.repository.CustomersRepository;
import comwsd.repository.ProductsRepository;


@Controller
public class HomeController {
	
	@Autowired
	CustomersRepository customerRepo;
	
	@Autowired
	ProductsRepository productRepo;


	@RequestMapping("/")
	public String index(Model model){
		return "index";
	} 
	
	@RequestMapping("/customerRegister")
	public String customer(){
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
	
	
	private List<Customers> getCustomer(){
		List<Customers> customers = customerRepo.findAll();
		
		return customers;
	}
	
	private List<Products> getProduct(){
		List<Products> products = productRepo.findAll();
		
		return products;
	}
	
	
	
	
	
}
