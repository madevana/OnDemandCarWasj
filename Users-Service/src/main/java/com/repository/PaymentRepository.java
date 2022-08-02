package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Payment;



@Repository
public interface PaymentRepository  extends MongoRepository<Payment, Integer>  {
}