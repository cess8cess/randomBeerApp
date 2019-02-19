package com.nrc.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nrc.model.Beer;

public interface BeerRepository extends MongoRepository<Beer, String> {

}
