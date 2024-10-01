package com.marwan.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductDTO {

    private int id;
    private String name;
    private String description;
    private int price;
    private boolean available;

}