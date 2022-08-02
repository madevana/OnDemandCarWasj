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
import com.model.Payment;
import com.model.Signup;
import com.service.LoginService;
import com.service.PaymentService;
import com.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/add")
	public ResponseEntity<Signup> addUser(@RequestBody Signup user) {
		LOGGER.info("Inside addUser of userController");
		Signup newSignup = userService.addUser(user);
		LOGGER.info("Adding...");
		ResponseEntity<Signup> responseEntity = new ResponseEntity<Signup>(newSignup, HttpStatus.CREATED);
		LOGGER.info("Added User");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Signup>> fetchAllUsers() {
		LOGGER.info("Inside fetchAllUsers of userController");
		List<Signup> allUsers = userService.getAllUsers();
		LOGGER.info("Fetching...");
		ResponseEntity<List<Signup>> responseEntity = new ResponseEntity<List<Signup>>(allUsers, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch User -END!");
		return responseEntity;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchUserById(@PathVariable("id") int id) {
		LOGGER.info("Inside fetchUserById of UserController");
		ResponseEntity<?> responseEntity = null;
		Signup signup = userService.getUserById(id);
		responseEntity = new ResponseEntity<>(signup, HttpStatus.OK);
		return responseEntity;
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
		LOGGER.info("Inside deleteuserById of userController");
		userService.deleteUserById(id);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Account deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete User -END!");
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateUserAccount(@Valid @RequestBody Signup user) {
		LOGGER.info("Inside updateUsers of UserController");
		ResponseEntity<Object> responseEntity = null;
		userService.updateUserAccount(user);
		responseEntity = new ResponseEntity<>("User updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  UserAccount");
		LOGGER.info("Updating  UserAccount -END!");
		return responseEntity;
	}
	

}