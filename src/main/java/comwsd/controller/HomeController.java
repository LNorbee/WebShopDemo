package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import comwsd.entities.Customers;
import comwsd.repository.CustomersRepository;


@Controller
public class HomeController {
	
	@Autowired
	CustomersRepository customerRepo;


	@RequestMapping("/")
	public String index(Model model){
		//model.addAttribute("pagetitle", "Próba");
		model.addAttribute("customers", getCustomer());
		return "index";
	} 
	
	@RequestMapping("/customerRegister")
	public String customer(){
		return "customerRegister";
	}
	
	@RequestMapping("/productRegister")
	public String product(){
		return "productRegister";
	}
	
	
	private List<Customers> getCustomer(){
		List<Customers> customers = customerRepo.findAll();
		
		return customers;
	}
}
