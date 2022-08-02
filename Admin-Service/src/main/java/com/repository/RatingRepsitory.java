package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.UserRating;



public interface RatingRepsitory extends MongoRepository<UserRating, Integer>  {

}