package com.example.inventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tbl_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productName;
    private int gst;
    private int price;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Bill> bills;
}
