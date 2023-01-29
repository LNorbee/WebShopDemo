package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import comwsd.model.Customers;
import comwsd.model.Products;
import comwsd.repository.CustomerRepository;
import comwsd.repository.ProductRepository;
import comwsd.service.CustomerService;
import comwsd.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ProductRepository productRepo;
	
//	@Autowired
//	OrderRepository orderRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/")
	public String index(Model model){
		model.addAttribute("customers", getCustomer());
		model.addAttribute("products", getProduct());
		//model.addAttribute("orders", getOrder());
		return "index";
	} 

//	@RequestMapping("/customerRegister")
//	public String customer(Model model) {
//		return "customerRegister";
//	}
	
	@RequestMapping("/productRegister")
	public String product(Model model){
		return "productRegister";
	}
	
//	@RequestMapping("/orders")
//	public String order(Model model) {
//		return "orders";
//	}

	private List<Customers> getCustomer(){
		List<Customers> customers = customerRepo.findAll();

		return customers;
	}

	private List<Products> getProduct(){
		List<Products> products = productRepo.findAll();

		return products;
	}
	
//	private List<Orders> getOrder(){
//		List<Orders> orders = orderRepo.findAll();
//		
//		return orders;
//	}
	
	// Vásárló regisztrálása html felületen
	@GetMapping("/customerRegister")
	public String addCustomer(Model model) {
		Customers customer = new Customers();
		model.addAttribute("customer", customer);
		return "customerRegister_form";
	}
	
	@PostMapping("/customerRegister")
	public String saveCustomer(@ModelAttribute("customer") Customers customer) {
		customerService.save(customer);
		return "redirect:/";
	}
	
	// Termék regisztrálása html felületen
	@GetMapping("/productRegister")
	public String addProduct(Model model) {
		Products product = new Products();
		model.addAttribute("product", product);
		return "productRegister_form";
	}
	
	@PostMapping("/productRegister")
	public String saveProduct(@ModelAttribute("product") Products product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
}