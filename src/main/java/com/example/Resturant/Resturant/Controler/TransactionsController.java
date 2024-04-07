package com.example.Resturant.Resturant.Controler;

import com.example.Resturant.Resturant.Entity.Transaction;
import com.example.Resturant.Resturant.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Transactions")
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/getAllTransaction")
    public List<Transaction> getAllTransactions(){
        System.out.println("getAllTransactions called");

        return transactionRepository.findAll();
    }

}
