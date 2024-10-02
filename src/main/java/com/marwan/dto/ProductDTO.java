package com.marwan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int id;
    private String name;
    private String description;
    private int price;
    private boolean available;

}