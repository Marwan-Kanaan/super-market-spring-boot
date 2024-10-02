package com.marwan.dto;

import com.marwan.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<Product> order;

}