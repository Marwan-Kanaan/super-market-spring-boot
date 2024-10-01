package com.marwan.controller;

import com.marwan.model.User;
import com.marwan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service ;

    @PostMapping("/add_user")
    public void createUser(@RequestBody User user){
        try {
            service.createUser(user);
            System.out.println(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers() , HttpStatus.OK);
    }

}
