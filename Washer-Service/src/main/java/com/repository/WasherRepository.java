package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Washer;


@Repository
public interface WasherRepository  extends MongoRepository<Washer, Integer>  {

	

}
