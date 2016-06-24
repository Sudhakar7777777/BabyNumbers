package com.bc.babynumber.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bc.babynumber.model.ServerPing;

public interface ServerPingRepository extends MongoRepository<ServerPing, String>{
	
}