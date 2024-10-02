package com.marwan.service;

import com.marwan.dto.UserDTO;
import com.marwan.model.User;
import com.marwan.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo ;
    @Setter
    private List<UserDTO> listDTO ;
    private UserDTO userDTO;

    public void createUser(User user){
      try {
          if (user != null){
          repo.save(user);
          } else {
              System.out.println("please provide all the necessary data"); ;
          }
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      }
    }
    public List<User> getAllUsers(){
        try {
            if (!repo.findAll().isEmpty()) {
                return repo.findAll();
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            return null ;
        }
    }

    public User getUserById(int id){
        try {
            return repo.findById(id).orElse(new User());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteUser(int id){
       if (!repo.findAll().isEmpty()){
           repo.deleteById(id);
           System.out.println(HttpStatus.OK);
       } else {
           System.out.println(HttpStatus.NO_CONTENT);
       }
    }

    public User updateUser(int id , User user){
        User user1 = getUserById(id);
        user1 = user ;
        return repo.save(user1);
    }



}
