package com.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Signup;



public interface UserRepository extends MongoRepository<Signup, Integer>  {

}
