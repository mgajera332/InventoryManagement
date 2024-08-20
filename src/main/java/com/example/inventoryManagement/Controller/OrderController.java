package com.example.inventoryManagement.Controller;

import com.example.inventoryManagement.Entity.Bill;
import com.example.inventoryManagement.Entity.Order;
import com.example.inventoryManagement.Repository.BillRepo;
import com.example.inventoryManagement.Service.EmailService;
import com.example.inventoryManagement.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    BillRepo billRepo;

    @Autowired
    EmailService emailService;


    @PostMapping("/add")
    public ResponseEntity<String> makeOrder(@RequestBody Order order){
        if (orderService.makePayment()) {
            orderService.makeOrder(order);
            Bill bill=billRepo.findById(order.getOrderId()).get();
            emailService.sendMail("darshanvirani12349824970828@gmail.com","Bill","Customer Name : "+order.getCustomer().getCustomerName()+
                                                                                          "\nBill Number : "+bill.getBillId()+
                                                                                          "\n GST : "+bill.getGst());
            return ResponseEntity.ok("Bill Send to your Mail Id");

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment Not Done!!!");
        }
    }

    @PostMapping("/sendmail")
    public boolean sendmail(){
        emailService.sendMail("ajaysinhsarvaiya1111@gmail.com","Testing...","Hyyy");
        return true;
    }

}
