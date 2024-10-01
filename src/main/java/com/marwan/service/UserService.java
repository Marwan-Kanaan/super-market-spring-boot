package com.marwan.service;

import com.marwan.dto.UserDTO;
import com.marwan.model.User;
import com.marwan.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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

}
