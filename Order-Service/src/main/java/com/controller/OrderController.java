package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.OrderDetails;
import com.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@PostMapping("/add")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) {
		LOGGER.info("Inside addOrder of orderController");
		OrderDetails newOrder = orderService.addOrder(order);
		LOGGER.info("Adding...");
		ResponseEntity<OrderDetails> responseEntity = new ResponseEntity<OrderDetails>(newOrder, HttpStatus.CREATED);
		LOGGER.info("Added order");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<OrderDetails>> fetchAllOrders() {
		LOGGER.info("Inside fetchAllCarts of orderController");
		List<OrderDetails> allOrders = orderService.getAllOrders();
		LOGGER.info("Fetching...");
		ResponseEntity<List<OrderDetails>> responseEntity = new ResponseEntity<List<OrderDetails>>(allOrders, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Order -END!");
		return responseEntity;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchOrderById(@PathVariable("id") int orderId) {
		LOGGER.info("Inside fetchOrderById of OrderController");
		ResponseEntity<?> responseEntity = null;
		OrderDetails order = orderService.getOrderById(orderId);
		responseEntity = new ResponseEntity<>(order, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") int orderId) {
		LOGGER.info("Inside deleteOrderById of orderController");
		orderService.deleteOrderById(orderId);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Order deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete Order -END!");
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateCoupon(@Valid @RequestBody OrderDetails order) {
		LOGGER.info("Inside updateOrder of OrderController");
		ResponseEntity<Object> responseEntity = null;
		orderService.updateOrder(order);
		responseEntity = new ResponseEntity<>("Order updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  OrderDetails");
		LOGGER.info("Updating  OrderDetails -END!");
		return responseEntity;
	}
	

}
