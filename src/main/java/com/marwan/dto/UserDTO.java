package com.marwan.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDTO {

    private int id;
    private String first_name;
    private String last_name;
    private String email;

}