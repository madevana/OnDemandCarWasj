package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.model.WashPack;

public interface WashPackRepository extends MongoRepository<WashPack, Integer>  {

}