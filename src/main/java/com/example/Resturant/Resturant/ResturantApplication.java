package com.example.Resturant.Resturant;

import com.example.Resturant.Resturant.Entity.Customer;
import com.example.Resturant.Resturant.Repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResturantApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResturantApplication.class, args);

		// new ObjectMapper().writeValueAsString()
	}

}
