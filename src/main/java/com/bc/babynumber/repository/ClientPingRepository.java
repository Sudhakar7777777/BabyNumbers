package com.bc.babynumber.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bc.babynumber.model.ClientPing;

public interface ClientPingRepository extends MongoRepository<ClientPing, String>{
	
}