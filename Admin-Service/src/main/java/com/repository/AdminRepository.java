package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Admin;
import com.model.WashPack;

public interface AdminRepository extends MongoRepository<Admin, Integer>  {

	

}

