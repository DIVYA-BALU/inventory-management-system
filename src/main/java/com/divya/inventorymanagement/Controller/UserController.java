package com.divya.inventorymanagement.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.inventorymanagement.Service.UserService;
import com.divya.inventorymanagement.Users.User;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    @GetMapping("/getuserbyemail/{email}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String email) {

        return ResponseEntity.ok(userService.getUser(email));
    }

   
    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> authenticate() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/updateuser/{email}") 
        public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User user) {
            return ResponseEntity.ok(userService.updateUser(email, user));
        }
    }

