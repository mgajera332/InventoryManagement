package com.example.inventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int BillId;
    private int gst;
    private int price;
    private int priseAfterGst;
    private int ProductQauntity;
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Product product;

}
