package comwsd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("pagetitle", "Próba");
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
}
