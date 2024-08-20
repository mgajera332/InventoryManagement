package com.example.inventoryManagement.Repository;

import com.example.inventoryManagement.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Integer> {

}
