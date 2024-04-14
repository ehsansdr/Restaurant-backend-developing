package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Customer;
import com.example.Resturant.Resturant.Entity.Food;
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

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void saveTransaction(){
        Customer customer1 = Customer.builder()
                .firstName("melina")
                .LastName("Mahmoodi")
                .phoneNumber("092968585")
                .postal_Code("78661")
                .subscription_Code("88399")
                .build();
        /** be careful you should have ( cascade = CascadeType.ALL ) in the class that has @ManyToOne this test class or7
         * you should save the component and fill of that class in the=ier Repository
         * then put them in build class
         * and if you do not have cascade andif you do not have this you get error*/
        //customerRepository.save(customer1);
        /** so have ( cascade = CascadeType.ALL ) in the annotation of class and table that will contain the
         * @ManyToOne you will not get that error
         * not necessary for @OneToMany class*/

        Transaction transaction = Transaction.builder()
                .customer(customer1)
                .build();

        //System.out.println("customer : " + customerRepository.getCustomerById(2));

        this.transactionRepository.save(transaction);

        System.out.println("\n\ntransaction : " + transaction + "added\n");

    }

    @Test
    public void addingTransactionAndFood(){

        Food food1 = Food.builder()
                .FoodsName("hot dog")
                .amount(3)
                .price(5236)
                .build();
        foodRepository.save(food1);
        Food food2 = Food.builder()
                .FoodsName("kerakof")
                .amount(8)
                .price(1000)
                .build();
        foodRepository.save(food2);
        Food food3 = Food.builder()
                .FoodsName("royal")
                .amount(2)
                .price(5500)
                .build();
        foodRepository.save(food3);

        Customer customer1 = Customer.builder()
                .firstName("akbar")
                .LastName("Rahimi nia")
                .phoneNumber("0929684557")
                .postal_Code("786646")
                .subscription_Code("265555")
                .build();

        customerRepository.save(customer1);

        Transaction transaction = Transaction.builder()
                .customer(customer1)
                .build();

        transaction.addFood(food1);
        transaction.addFood(food2);
        transaction.addFood(food3);

        transactionRepository.save(transaction);
    }

}