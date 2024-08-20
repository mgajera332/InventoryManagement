package com.example.inventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private int customerId;
    private String customerName;
    private int customerMoNum;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Bill> bills;
}
