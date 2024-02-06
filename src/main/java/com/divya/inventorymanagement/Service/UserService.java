package com.divya.inventorymanagement.Service;

import java.util.List;
import java.util.Optional;

import com.divya.inventorymanagement.Users.User;

public interface UserService {

    Optional<User> getUser(String email);

    List<User> getAllUsers();

    User updateUser(String email, User user);
    
}
