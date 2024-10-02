package com.marwan.controller;

import com.marwan.dto.UserDTO;
import com.marwan.model.User;
import com.marwan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add_user")
    public void createUser(@RequestBody User user) {
        try {
            service.createUser(user);
            System.out.println(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    //DTO
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getAllUserDTOById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getUserDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //DTO
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUserDTO() {
        try {
            return new ResponseEntity<>(service.getAllUserDTO(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        try {
            service.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        try {
            return new ResponseEntity<>(service.updateUser(id, user), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getALlUsers() {
        try {
            return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/order/{id}/{productId}")
    public ResponseEntity<User> order(@PathVariable int id, @PathVariable int productId) {
        try {
            return new ResponseEntity<>(service.order(id, productId), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<User> deleteOrder(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.deleteOrder(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

}
