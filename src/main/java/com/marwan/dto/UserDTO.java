package com.marwan.dto;

import com.marwan.model.Product;
import com.marwan.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class UserDTO {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<Product> order;

}