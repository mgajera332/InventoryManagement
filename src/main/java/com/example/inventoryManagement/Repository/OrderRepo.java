package com.example.inventoryManagement.Repository;

import com.example.inventoryManagement.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
