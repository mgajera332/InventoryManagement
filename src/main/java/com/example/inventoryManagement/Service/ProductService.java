package com.example.inventoryManagement.Service;

import com.example.inventoryManagement.Entity.Product;
import com.example.inventoryManagement.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public boolean addProduct(Product product){
        productRepo.save(product);
        return true;
    }
}
