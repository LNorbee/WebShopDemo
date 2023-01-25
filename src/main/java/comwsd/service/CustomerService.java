package comwsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comwsd.model.Customer;
import comwsd.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public List<Customer> listAll(){
		return customerRepo.findAll();
	}
	
	public void save(Customer customer) {
		customerRepo.save(customer);
	}
	
	public Customer get(Integer id) {
		return customerRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		customerRepo.deleteById(id);
	}
}
