//package com.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.model.Admin;
//import com.repository.AdminRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AdminServiceTests 
//{
//   @Autowired
//	private AdminService adminService;
//   
//   @MockBean
//   private AdminRepository adminRepository;
//   
//   @Test
//	public void getAdminsTest() {
//		when(adminRepository.getAllAdmins()).thenReturn(Stream
//				.of(new Admin(1,"Danile","dany123"),
//						new Admin( 2,"Huy","sfgt123")).collect(Collectors.toList()));
//		assertEquals(2, adminService.getAllAdmins().size());
//	}
//   @Test
//	public void saveAdminTest() {
//	   Admin admin= new Admin(3,"Pranya","pranu345");
//		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
//	}
//   
//}