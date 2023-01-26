package comwsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comwsd.model.Orders;
import comwsd.repository.OrderRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Orders> listAllOrders(){
		return orderRepository.findAll();
	}
	
	public Orders getOrder(Integer id) {
		return orderRepository.findById(id).get();
	}
	
	public void saveOrder(Orders newOrders) {
		orderRepository.save(newOrders);
	}
	
}
