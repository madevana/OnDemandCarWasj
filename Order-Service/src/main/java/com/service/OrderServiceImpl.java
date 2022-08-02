package com.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.OrderAlreadyExistException;
import com.exception.OrderNotFoundException;
import com.model.OrderDetails;
import com.repository.OrderRepository;



@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	private Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		LOGGER.info("Add Order -START!");
		Optional<OrderDetails> savedOrder = orderRepository.findById(order.getOrderId());
		if (savedOrder.isPresent()) {
			LOGGER.info("Order Already Exist");
			throw new OrderAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add Order -END!");
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(int orderId) {
		LOGGER.info("Delete Cart -START!");
		Optional<OrderDetails> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder == null) {
			LOGGER.info("Order not found");
			throw new OrderNotFoundException();
		} else {
			LOGGER.info("Deleting Cart");
			orderRepository.deleteById(orderId);
			LOGGER.info("Delete Order -END!");
		}

	}

	@Override
	public List<OrderDetails> getAllOrders() {
		LOGGER.info("Fetch Order -START!");
		List<OrderDetails> orders = orderRepository.findAll();
		if (orders == null) {
			LOGGER.info("Order Not Found");
			throw new OrderNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch Order -END!");
		return orders;
	}
	@Override
	public OrderDetails getOrderById(int orderId) {
		LOGGER.info("View Order (Service) -START!");
		Optional<OrderDetails> optionalOrder = orderRepository.findById(orderId);

		if (optionalOrder == null) {
			LOGGER.error("Order cannot be Found!");
			throw new OrderNotFoundException("Order not exising with id: " + orderId);
		}

		OrderDetails order = optionalOrder.get();

		LOGGER.info("Displaying Order!");
		LOGGER.info("View Order  (Service) -END!");

		return order;
	}
	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		LOGGER.info("Update Order -START!");
		Optional<OrderDetails> optionalOrder = orderRepository.findById(order.getOrderId());

		if (optionalOrder == null) {
			LOGGER.info("Order Not Found");
			throw new OrderNotFoundException("Coupon not exising with id: " + order.getOrderId());
		}

		OrderDetails updatedOrder = orderRepository.save(order);
		LOGGER.info("Order updated Successfully!");
		LOGGER.info("Update Order -End!");
		return updatedOrder;


}
}
