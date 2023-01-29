package comwsd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import comwsd.service.OrderService;
import comwsd.model.Orders;

@RestController
public class OrdersController {

	private OrderService orderService;
	
	@GetMapping(value = "/orders")
	public List<Orders> listOrders(){
		return orderService.listAllOrders();
	}
	
	@GetMapping(value = "orders/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable Integer id){
		Orders order = orderService.getOrder(id);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
}
