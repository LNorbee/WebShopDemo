package comwsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comwsd.model.Product;
import comwsd.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// postman
	// http://localhost:8080/customers
	
	// Meglévő termékeket kilistázza
	@GetMapping(value = "/products")
	public List<Product> listProduct(){
		return productService.listAllProduct();
	}
	
	// Meglévő terméket kilistázza id alapján
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id){
		Product product = productService.getProduct(id);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	// Terméket ad hozzá a products táblához
	@PostMapping(value = "/products")
	public void addProduct(@RequestBody Product newProduct) {
		productService.saveProduct(newProduct);
	}
}
