package com.marwan.service;

import com.marwan.dto.UserDTO;
import com.marwan.model.User;
import com.marwan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo ;
    @Autowired
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

    public UserDTO getUserDTO(int id ){
        User user = getUserById(id);
        this.userDTO.setId(user.getId());
        this.userDTO.setFirst_name(user.getFirst_name());
        this.userDTO.setLast_name(user.getLast_name());
        this.userDTO.setEmail(user.getEmail());
        this.userDTO.setOrder(user.getOrder());
        return userDTO;
    }

    // not working
    public List<UserDTO> getAllUserDTO(){
        List<User> users = repo.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (User n : users) {
            userDTO.setId(n.getId());
            userDTO.setFirst_name(n.getFirst_name());
            userDTO.setLast_name(n.getLast_name());
            userDTO.setEmail(n.getEmail());
            dtos.add(userDTO);
        }
        return dtos;
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
