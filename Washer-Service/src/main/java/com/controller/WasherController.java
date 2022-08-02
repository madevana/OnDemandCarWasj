package com.controller;
import java.util.Arrays;

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
//import org.springframework.web.client.RestTemplate;

import com.model.OrderDetails;
import com.model.Washer;
import com.service.WasherService;


//import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/washer")
public class WasherController {
	@Autowired
	private WasherService washerService;

	private Logger LOGGER = LoggerFactory.getLogger(WasherController.class);

	@PostMapping("/add")
	public ResponseEntity<Washer> addOrder(@RequestBody Washer washer) {
		LOGGER.info("Inside addWasher of washerController");
		Washer newWasher = washerService.addWasher(washer);
		LOGGER.info("Adding...");
		ResponseEntity<Washer> responseEntity = new ResponseEntity<Washer>(newWasher, HttpStatus.CREATED);
		LOGGER.info("Added order");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Washer>> fetchAllOrders() {
		LOGGER.info("Inside fetchAllWashers of washerController");
		List<Washer> allWashers = washerService.getAllWashers();
		LOGGER.info("Fetching...");
		ResponseEntity<List<Washer>> responseEntity = new ResponseEntity<List<Washer>>(allWashers, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Order -END!");
		return responseEntity;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchWasherById(@PathVariable("id") int id) {
		LOGGER.info("Inside fetchWasherById of WasherController");
		ResponseEntity<?> responseEntity = null;
		Washer washer = washerService.getWasherById(id);
		responseEntity = new ResponseEntity<>(washer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWasherById(@PathVariable("id") int id) {
		LOGGER.info("Inside deleteWasherById of WasherController");
		washerService.getWasherById(id);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Washer deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete Order -END!");
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateWasher(@Valid @RequestBody Washer washer) {
		LOGGER.info("Inside updateWasher of WasherController");
		ResponseEntity<Object> responseEntity = null;
		washerService.updateWasher(washer);
		responseEntity = new ResponseEntity<>("Washer updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  Washer");
		LOGGER.info("Updating  Washer -END!");
		return responseEntity;
	}
	
}