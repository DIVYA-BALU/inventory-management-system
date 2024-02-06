package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Repository.UserRepository;
import com.divya.inventorymanagement.Service.UserService;
import com.divya.inventorymanagement.Users.User;


@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> getUser(String email) {

        return userRepository.findByEmail(email);
        
    }
    @Override
    public List<User> getAllUsers() {
       
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public User updateUser(String email, User user) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setFirstname(user.getFirstname());
            userToUpdate.setLastname(user.getLastname());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            return userRepository.save(userToUpdate);
        }
        return null;
    }
    
}
