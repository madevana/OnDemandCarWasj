//package com.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.model.OrderDetails;
//import com.repository.OrderRepository;
//
//
//
//@SpringBootTest
//class OrderServiceTests {
//
//	@Autowired
//	private OrderService orderService;
//
//	@MockBean
//	private OrderRepository orderRepository;
//
//	@Test
//	public void addWasherTest() {
//		OrderDetails c = new OrderDetails();
//		c.setOrderId(100);
//		c.setCarName("xyz");
//		c.setCarModel("Abc");
//		c.setUsername("Mani");
//		c.setDate("8/1/2022");
//		c.setContactno(9951454602l);
//		c.setAddress(null);
//		
//
//		Mockito.when(orderRepository.save(c)).thenReturn(c);
//		assertThat(orderService.addOrder(c)).isEqualTo(c);
//	}
//
//	@Test
//	public void getAllOrdersTest() {
//		OrderDetails c = new OrderDetails();
//		c.setOrderId(100);
//		c.setCarName("xyz");
//		c.setCarModel("Abc");
//		c.setUsername("Mani");
//		c.setDate("8/1/2022");
//		c.setContactno(9951454602l);
//		c.setAddress("Bangalore");
//
//		OrderDetails c1 = new OrderDetails();
//		c1.setOrderId(100);
//		c1.setCarName("xyz");
//		c1.setCarModel("Abc");
//		c1.setUsername("Mani");
//		c1.setDate("8/1/2022");
//		c1.setContactno(9951454602l);
//		c1.setAddress("Bangalore");
//		List<OrderDetails> w = new ArrayList<>();
//		w.add(c1);
//		w.add(c);
//
//		Mockito.when(orderRepository.findAll()).thenReturn(w);
//		assertThat(orderService.getAllOrders()).isEqualTo(w);
//	}
//
//	@Test
//	public void getWasherTest() {
//		OrderDetails c = new OrderDetails();
//		c.setOrderId(100);
//		c.setCarName("xyz");
//		c.setCarModel("Abc");
//		c.setUsername("Mani");
//		c.setDate("8/1/2022");
//		c.setContactno(9951454602l);
//		c.setAddress("Bangalore");
//		Mockito.when(orderRepository.findById(100).get()).thenReturn(c);
//		assertThat(orderService.getOrderById(100)).isEqualTo(c);
//	}
//
//}
