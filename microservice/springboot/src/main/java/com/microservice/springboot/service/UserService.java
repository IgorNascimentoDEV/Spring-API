package com.microservice.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.springboot.dto.UserDTO;
import com.microservice.springboot.model.UserModel;
import com.microservice.springboot.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> getUsers() {
        log.error("getUsers");
        return userRepository.findAll();
    }

    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("User not found with id {}", id);
            return new RuntimeException("User not found with id " + id);
        });
    }

    public UserModel create(UserDTO userDTO) {
        UserModel userModel = UserModel.builder()
        .name(userDTO.getName())
        .email(userDTO.getEmail())
        .build();
        return userRepository.save(userModel);
    }

    public UserModel update(Long id, UserDTO userDTO){
        UserModel userModel = userRepository.findById(id).orElseThrow(()->{
            log.error("User not found with id {}", id);
            return new RuntimeException("User not found with id" + id);
        });

        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());

        return userRepository.save(userModel);
    }

    public UserModel delete(Long id){
        UserModel userModel = userRepository.findById(id).orElseThrow(()->{
            log.error("User not fouf with id {}", id);
            return new RuntimeException("User not found with id" + id);
        });

        userRepository.delete(userModel);
        return userModel;
    }
}
