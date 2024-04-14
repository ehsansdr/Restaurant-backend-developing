package com.example.Resturant.Resturant.Controler;

import com.example.Resturant.Resturant.Entity.Transaction;
import com.example.Resturant.Resturant.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Restaurant/Transactions")
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

//    @GetMapping("/getAllTransaction")
//    public List<Transaction> getAllTransactions(){
//        System.out.println("getAllTransactions called");
//
//        return transactionRepository.findAll();
//    }
    @GetMapping("/getAllTransaction")
    public List<Object> getAllTransactionAndName(){
        System.out.println("getAllTransactionAndName called");
        /** because we get not unique object and not same for join , I put return type as List<Object> */
        return transactionRepository.getAllTransactionAndName();
    }
    @GetMapping("/getTransactionByTransactionId")
    public Object getTransactionByTransactionId(@RequestBody int transaction_id){
        System.out.println("getAllTransactionAndName called");
        /** because we get not unique object and not same for join , I put return type as List<Object> */

        return transactionRepository.getTransactionByTransactionId(transaction_id);
    }

    @PutMapping("/addtransactionwithfoods")
    public Transaction addTransaction(@RequestBody Transaction transaction){


        return transactionRepository.save(transaction);
    }

}
