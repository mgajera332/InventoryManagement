package com.example.inventoryManagement.Service;

import com.example.inventoryManagement.Entity.Bill;
import com.example.inventoryManagement.Entity.Customer;
import com.example.inventoryManagement.Entity.Order;
import com.example.inventoryManagement.Entity.Product;
import com.example.inventoryManagement.Repository.BillRepo;
import com.example.inventoryManagement.Repository.CustomerRepo;
import com.example.inventoryManagement.Repository.OrderRepo;
import com.example.inventoryManagement.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    BillRepo billRepo;

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;

    public boolean makePayment(){
        return new Random().nextBoolean();
    }

    public void makeOrder(Order order){

            Product product = productRepo.findById(order.getProduct().getProductID()).get();
            Customer customer = customerRepo.findById(order.getCustomer().getCustomerId()).get();

            Bill bill = new Bill();
            bill.setGst(product.getGst());
            bill.setPrice(product.getPrice() * order.getQuantity());

            bill.setProduct(product);
            bill.setCustomer(customer);
            bill.setProductQauntity(order.getQuantity());

            int afterPrice = (bill.getPrice() * product.getGst()) / 100;
            bill.setPriseAfterGst(afterPrice);

            order.setProduct(product);
            order.setCustomer(customer);
            billRepo.save(bill);
            orderRepo.save(order);

            ResponseEntity.ok("order Successfulyyy");


    }

//    public void makeOrder(Order order){
//        if (makePayment()){
//            Product product=productRepo.findById(order.getProduct().getPId()).get();
//
//            Customer customer=customerRepo.findById(order.getCustomer().getCustomerId()).get();
//
//
//        }
//    }

}
