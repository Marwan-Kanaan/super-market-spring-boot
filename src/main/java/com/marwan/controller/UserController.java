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

    //DTO
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getAllUserDTOById(@PathVariable int id){
        try {
            return new ResponseEntity<>(service.getUserDTO(id) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //DTO
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUserDTO(){
        return new ResponseEntity<>(service.getAllUserDTO() , HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable int id){
        service.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id , @RequestBody User user){
        return new ResponseEntity<>(service.updateUser(id, user) , HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getALlUsers(){
        return new ResponseEntity<>(service.getAllUsers() , HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return new ResponseEntity<>(service.getUserById(id) , HttpStatus.OK);
    }

    @PutMapping("/order/{id}/{productId}")
    public User order(@PathVariable int id , @PathVariable int productId){
        return service.order(id , productId);
    }

    @DeleteMapping("/order/{id}")
    public User deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }

}
