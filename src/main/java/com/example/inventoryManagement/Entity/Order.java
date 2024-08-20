package com.example.inventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String city;
    private String state;
    private int quantity;
    private String country;

    @ManyToOne
    @JoinColumn(name = "fk_p_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_c_id")
    private Customer customer;
}
