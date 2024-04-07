package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){
        Customer customer1 = Customer.builder()
                .firstName("amir")
                .LastName("Yegane")
                .phoneNumber("09412657")
                .postal_Code("326514")
                .subscription_Code("25136")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("ali")
                .LastName("karami")
                .phoneNumber("0912142785")
                .postal_Code("45478")
                .subscription_Code("98245")
                .build();

        Customer customer3 = Customer.builder()
                .firstName("masood")
                .LastName("nasiri")
                .phoneNumber("0912222222")
                .postal_Code("74516")
                .subscription_Code("21369")
                .build();

        Customer customer4 = Customer.builder()
                .firstName("ali")
                .LastName("khalili")
                .phoneNumber("09125543698")
                .postal_Code("152248")
                .subscription_Code("8547")
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        //System.out.println("\n\ncustomer : " + customer + "\nAdded\n");
    }

}