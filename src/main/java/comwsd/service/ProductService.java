package comwsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comwsd.model.Products;
import comwsd.repository.ProductRepository;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Products> listAllProduct(){
		return productRepo.findAll();
	}
	
	public void saveProduct(Products product) {
		productRepo.save(product);
	}
	
	public Products getProduct(Integer id) {
		return productRepo.findById(id).get();
	}
	
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
	}
}
