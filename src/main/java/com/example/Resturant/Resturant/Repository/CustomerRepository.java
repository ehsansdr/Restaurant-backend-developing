package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Customer;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(
            value = "select * from customer where customer_id = :customerId",
            nativeQuery = true
    )
    public Customer getCustomerById(@Param("customerId")int id);
}
