package com.service;

import java.util.List;

import javax.validation.Valid;

import com.model.OrderDetails;

public interface OrderService {

	OrderDetails addOrder(OrderDetails order);

	List<OrderDetails> getAllOrders();

	void deleteOrderById(int orderId);

	OrderDetails getOrderById(int orderId);

	  OrderDetails updateOrder(@Valid OrderDetails order);

	 
		
		
	

 
		
	}



	

	
	


