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
	
	public List<Customer> listAllCustomer(){
		return customerRepo.findAll();
	}
	
	public void saveCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public Customer getCustomer(Integer id) {
		return customerRepo.findById(id).get();
	}
	
	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
	}
}
