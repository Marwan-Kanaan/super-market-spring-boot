package com.marwan.service;

import com.marwan.model.Product;
import com.marwan.model.User;
import com.marwan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;



    public void createProduct(Product product){
        try {
            if (product != null){
                repository.save(product);
            } else {
                System.out.println("please provide all the necessary data"); ;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Product> getAllProducts(){
        try {
            if (!repository.findAll().isEmpty()) {
                return repository.findAll();
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            return null ;
        }
    }

    public Product getProductById(int id){
        try {
            return repository.findById(id).orElse(new Product());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteProduct(int id){
        if (!repository.findAll().isEmpty()){
            repository.deleteById(id);
            System.out.println(HttpStatus.OK);
        } else {
            System.out.println(HttpStatus.NO_CONTENT);
        }
    }

    public Product updateProduct(int id , Product product){
        Product product1 = getProductById(id);
        product1 = product ;
        return repository.save(product1);
    }
}
