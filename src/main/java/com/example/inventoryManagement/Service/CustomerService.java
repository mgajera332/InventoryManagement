package com.example.inventoryManagement.Service;

import com.example.inventoryManagement.Entity.Customer;
import com.example.inventoryManagement.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }
}
