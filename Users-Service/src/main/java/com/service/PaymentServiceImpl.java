package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.PaymentAlreadyExistException;
import com.Exception.PaymentNotFoundException;

import com.model.OrderDetails;
import com.model.Payment;
import com.repository.PaymentRepository;



@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;

	private Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public Payment addPayment(Payment payment) {
		LOGGER.info("Add Payment -START!");
		Optional<Payment> savedPayment = paymentRepository.findById(payment.getId());
		if (savedPayment.isPresent()) {
			LOGGER.info("Payment Already Exist");
			throw new PaymentAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add Payment -END!");
		return paymentRepository.save(payment);
	}

	@Override
	public void deletePaymentById(int id) {
		LOGGER.info("Delete Payment -START!");
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment == null) {
			LOGGER.info("Payment not found");
			throw new PaymentNotFoundException();
		} else {
			LOGGER.info("Deleting Payment");
			paymentRepository.deleteById(id);
			LOGGER.info("Delete payment -END!");
		}

	}

	@Override
	public List<Payment> getAllPayments() {
		LOGGER.info("Fetch Payment -START!");
		List<Payment> payments = paymentRepository.findAll();
		if (payments == null) {
			LOGGER.info("Payment Not Found");
			throw new PaymentNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch payment -END!");
		return payments;
	}
	@Override
	public Payment getPaymentById(int id) {
		LOGGER.info("View Payment (Service) -START!");
		Optional<Payment> optionalPayment = paymentRepository.findById(id);

		if (optionalPayment == null) {
			LOGGER.error("Payment cannot be Found!");
			throw new PaymentNotFoundException("Payment not exising with id: " + id);
		}

		Payment payment = optionalPayment.get();

		LOGGER.info("Displaying Payment!");
		LOGGER.info("View Payment  (Service) -END!");

		return payment;
	}
	@Override
	public Payment updatePayment(Payment payment) {
		LOGGER.info("Update Payment -START!");
		Optional<Payment> optionalPayment = paymentRepository.findById(payment.getId());

		if (optionalPayment == null) {
			LOGGER.info("Payment Not Found");
			throw new PaymentNotFoundException("Payment not exising with id: " + payment.getId());
		}

		Payment updatedPayment = paymentRepository.save(payment);
		LOGGER.info("Payment updated Successfully!");
		LOGGER.info("Update Payment -End!");
		return updatedPayment;


}



}
