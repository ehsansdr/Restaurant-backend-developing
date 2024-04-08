package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query(
            value = "select transactions.customer_id ,customer.first_name, customer.last_name\n" +
                    "from transactions \n" +
                    "left join customer on transactions.customer_id = customer.customer_id;",
            nativeQuery = true
    )
    List<Object> getAllTransactionAndName();

    @Query(
            value = "select transactions.transaction_id ,transactions.customer_id ,customer.first_name, customer.last_name\n" +
                    "from transactions \n" +
                    "left join customer on transactions.customer_id = customer.customer_id\n" +
                    "where transaction_id = :Id",
            nativeQuery = true
    )
    Object getTransactionByTransactionId(@Param("Id") int transaction_id);



}
