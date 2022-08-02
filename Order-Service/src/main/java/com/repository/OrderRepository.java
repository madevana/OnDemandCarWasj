package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.OrderDetails;

public interface OrderRepository extends MongoRepository<OrderDetails, Integer>  {

}
