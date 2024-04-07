package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {





}
