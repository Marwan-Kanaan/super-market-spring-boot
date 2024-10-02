package com.marwan.controller;

import com.marwan.model.Product;
import com.marwan.model.User;
import com.marwan.service.ProductService;
import com.marwan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add_product")
    public void createProduct(@RequestBody Product product){
        try {
            service.createProduct(product);
            System.out.println(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(){
        try {
            return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return new ResponseEntity<>(service.getProductById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable int id){
        service.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable int id , @RequestBody Product product){
        return new ResponseEntity<>(service.updateProduct(id, product) , HttpStatus.OK);
    }

}
