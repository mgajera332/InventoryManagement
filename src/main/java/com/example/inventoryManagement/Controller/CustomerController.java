package com.example.inventoryManagement.Controller;

import com.example.inventoryManagement.Entity.Customer;
import com.example.inventoryManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")

    public boolean Add(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return true;
    }

}
