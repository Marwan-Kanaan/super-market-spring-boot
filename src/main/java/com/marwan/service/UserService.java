package com.marwan.service;

import com.marwan.dto.UserDTO;
import com.marwan.model.Product;
import com.marwan.model.User;
import com.marwan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    ProductService service ;
    @Autowired
    private UserRepository repo;


    public void createUser(User user) {
        try {
            if (user != null) {
                repo.save(user);
            } else {
                System.out.println("please provide all the necessary data");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            if (!repo.findAll().isEmpty()) {
                return repo.findAll();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public User getUserById(int id) {
        try {
            return repo.findById(id).orElse(new User());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public UserDTO getUserDTO(int id) {
        User user = getUserById(id);
        return new UserDTO(user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getOrder());
    }


    public List<UserDTO> getAllUserDTO() {
        return repo.findAll().stream()
                .map(user -> new UserDTO(user.getId(),
                        user.getFirst_name(),
                        user.getLast_name(),
                        user.getEmail(),
                        user.getOrder()))
                .collect(Collectors.toList());
    }


    public void deleteUser(int id) {
        if (!repo.findAll().isEmpty()) {
            repo.deleteById(id);
            System.out.println(HttpStatus.OK);
        } else {
            System.out.println(HttpStatus.NO_CONTENT);
        }
    }

    public User updateUser(int id, User user) {
        User user1 = getUserById(id);
        user1 = user;
        return repo.save(user1);
    }

    public User order(int userId, int productId) {
        User user = getUserById(userId);
        Product product = service.getProductById(productId);
        List<Product> products = user.getOrder();
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        user.setOrder(products);
        return repo.save(user);
    }

    public User deleteOrder(int id){
        User user = getUserById(id);
        user.getOrder().clear();
        return repo.save(user);
    }

}
