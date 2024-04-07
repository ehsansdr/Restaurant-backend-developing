package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Customer;
import com.example.Resturant.Resturant.Entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveTransaction(){
        Customer customer1 = Customer.builder()
                .firstName("nima")
                .LastName("azar")
                .phoneNumber("0933641525")
                .postal_Code("21654")
                .subscription_Code("215326")
                .build();

        Transaction transaction = Transaction.builder()
                .customer(customer1)
                .build();

        this.transactionRepository.save(transaction);

        System.out.println("\n\ntransaction : " + transaction + "added\n");

    }

}