package com.service;

import java.util.List;

import javax.validation.Valid;

import com.model.Payment;

public interface PaymentService {

	Payment getPaymentById(int id);

	List<Payment> getAllPayments();

	Payment addPayment(Payment payment);

	void deletePaymentById(int id);

	Payment updatePayment(@Valid Payment payment);

	
}
