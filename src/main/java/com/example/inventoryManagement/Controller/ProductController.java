package com.example.inventoryManagement.Controller;

import com.example.inventoryManagement.Entity.Product;
import com.example.inventoryManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public void AddProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}
