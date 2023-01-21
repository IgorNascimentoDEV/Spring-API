package com.microservice.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.springboot.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
    
}
