package com.marwan.controller;

import com.marwan.dto.ProductDTO;
import com.marwan.model.Product;
import com.marwan.service.ProductService;
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
    public void createProduct(@RequestBody Product product) {
        try {
            service.createProduct(product);
            System.out.println(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getAllProductDTO() {
        try {
            return new ResponseEntity<>(service.getAllProductDTO(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductDtoById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getProductDtoById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        try {
            service.deleteProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable int id, @RequestBody Product product) {
        try {
            return new ResponseEntity<>(service.updateProduct(id, product), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

}
