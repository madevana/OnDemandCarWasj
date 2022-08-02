package com.controller;

import java.util.List;

import javax.print.PrintService;
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

import com.model.Admin;
import com.model.UserRating;
import com.model.WashPack;
import com.model.Washer;
import com.service.AdminService;
import com.service.LoginService;



@RestController
@RequestMapping("/admin")
public class AdminController {

//	private static final List<UserRating> allWpacks = null;

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginService admin;

	private Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

//	@PostMapping("/add")
//	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
//		LOGGER.info("Inside addAdmin of adminController");
//		Admin newAdmin = adminService.addAdmin(admin);
//		LOGGER.info("Adding...");
//		ResponseEntity<Admin> responseEntity = new ResponseEntity<Admin>(newAdmin, HttpStatus.CREATED);
//		LOGGER.info("Added admin");
//		return responseEntity;
//	}
//
//	@GetMapping("/getAll")
//	public ResponseEntity<List<Admin>> fetchAllAdmins() {
//		LOGGER.info("Inside fetchAllAdmin of adminController");
//		List<Admin> allAdmins = adminService.getAllAdmins();
//		LOGGER.info("Fetching...");
//		ResponseEntity<List<Admin>> responseEntity = new ResponseEntity<List<Admin>>(allAdmins, HttpStatus.ACCEPTED);
//		LOGGER.info("Fetch Order -END!");
//		return responseEntity;
//	}
//	@GetMapping("/get/{id}")
//	public ResponseEntity<?> fetchAdminById(@PathVariable("id") int id) {
//		LOGGER.info("Inside fetchAdminById of AdminController");
//		ResponseEntity<?> responseEntity = null;
//		Admin admin = adminService.getAdminById(id);
//		responseEntity = new ResponseEntity<>(admin, HttpStatus.OK);
//		return responseEntity;
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteAdminById(@PathVariable("id") int id) {
//		LOGGER.info("Inside deleteAdminById of AdminController");
//		adminService.deleteAdminById(id);
//		LOGGER.info("Deleting...");
//		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Admin deleted successfully", HttpStatus.OK);
//		LOGGER.info("Delete Admin -END!");
//		return responseEntity;
//	}
//	@PutMapping("/update")
//	public ResponseEntity<Object> updateAdmin(@Valid @RequestBody Admin admin) {
//		LOGGER.info("Inside updateAdmin of AdminController");
//		ResponseEntity<Object> responseEntity = null;
//		adminService.updateAdmin(admin);
//		responseEntity = new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
//		LOGGER.info("Updating  Admin");
//		LOGGER.info("Updating  Admin -END!");
//		return responseEntity;
//	/}
//	
	
	
//	************************************************WASHPACK OPERATIONS**********************************************
	@PostMapping("/addWashpack")
	public ResponseEntity<WashPack> addWashPack(@RequestBody WashPack Wpack) {
		LOGGER.info("Inside addWashpack of adminController");
		WashPack newWpack = adminService.addWashPack(Wpack);
		LOGGER.info("Adding...");
		ResponseEntity<WashPack> responseEntity = new ResponseEntity<WashPack>(newWpack, HttpStatus.CREATED);
		LOGGER.info("Added Washpack");
		return responseEntity;
	}

	@GetMapping("/getAllWashpacks")
	public ResponseEntity<List<WashPack>> fetchAllWashPacks() {
		LOGGER.info("Inside fetchAllWashpack of adminController");
		List<WashPack> allWpacks = adminService.getAllWashPacks();
		LOGGER.info("Fetching...");
		ResponseEntity<List<WashPack>> responseEntity = new ResponseEntity<List<WashPack>>(allWpacks, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Washpack -END!");
		return responseEntity;
	}
	@GetMapping("/getWashpack/{id}")
	public ResponseEntity<?> fetchWashPackById(@PathVariable("id") int id) {
		LOGGER.info("Inside fetchAdminById of AdminController");
		ResponseEntity<?> responseEntity = null;
		WashPack wPack = adminService.getWashPackById(id);
		responseEntity = new ResponseEntity<>(wPack , HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/deleteWashpack/{id}")
	public ResponseEntity<String> deleteWashPackById(@PathVariable("id") int id) {
		LOGGER.info("Inside deleteWashpackById of AdminController");
		adminService.deleteWashPackById(id);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Washpack deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete Admin -END!");
		return responseEntity;
	}
	@PutMapping("/updateWashpack")
	public ResponseEntity<Object> updateWashPack(@Valid @RequestBody WashPack wpack) {
		LOGGER.info("Inside updateWashpack of AdminController");
		ResponseEntity<Object> responseEntity = null;
		adminService.updateWashPack(wpack);
		responseEntity = new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  Washpack");
		LOGGER.info("Updating  Washpack -END!");
		return responseEntity;
	}
//	********************************************User Rating********************************
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<UserRating>> fetchAllUserRatings() {
		LOGGER.info("Inside fetchAllRatings of AdminController");
		List<UserRating> allRatings = adminService.getAllUserRatings();
		LOGGER.info("Fetching...");
		ResponseEntity<List<UserRating>> responseEntity = new ResponseEntity<List<UserRating>>(allRatings, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Rating -END!");
		return responseEntity;
	}
	
	@PostMapping("/login")

	public String adminLogin(@Valid @RequestBody Admin login) {

		return admin.adminLogin(login);
	}
}

