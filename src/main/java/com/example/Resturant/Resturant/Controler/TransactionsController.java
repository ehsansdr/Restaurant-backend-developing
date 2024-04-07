package com.example.Resturant.Resturant.Controler;

import com.example.Resturant.Resturant.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

}
