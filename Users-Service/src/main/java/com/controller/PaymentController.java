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
import com.service.PaymentService;

;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	private Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping("/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		LOGGER.info("Inside addPayment of paymentController");
		Payment newPayment = paymentService.addPayment(payment);
		LOGGER.info("Adding...");
		ResponseEntity<Payment> responseEntity = new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
		LOGGER.info("Added Payment");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Payment>> fetchAllPayments() {
		LOGGER.info("Inside fetchAllPayments of paymentsController");
		List<Payment> allPayments = paymentService.getAllPayments();
		LOGGER.info("Fetching...");
		ResponseEntity<List<Payment>> responseEntity = new ResponseEntity<List<Payment>>(allPayments, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Payment -END!");
		return responseEntity;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchPaymentById(@PathVariable("id") int id) {
		LOGGER.info("Inside fetchPaymentById of PaymentController");
		ResponseEntity<?> responseEntity = null;
		Payment payment = paymentService.getPaymentById(id);
		responseEntity = new ResponseEntity<>(payment, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePaymentById(@PathVariable("id") int id) {
		LOGGER.info("Inside deletePaymentrById of paymentController");
		paymentService.deletePaymentById(id);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Payment deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete Payment -END!");
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updatePayment(@Valid @RequestBody Payment payment) {
		LOGGER.info("Inside updatePayment of PaymentController");
		ResponseEntity<Object> responseEntity = null;
		paymentService.updatePayment(payment);
		responseEntity = new ResponseEntity<>("Payment updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  Payment");
		LOGGER.info("Updating  Payment -END!");
		return responseEntity;
	}
	

}