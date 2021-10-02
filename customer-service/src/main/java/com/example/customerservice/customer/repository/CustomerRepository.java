package com.example.customerservice.customer.repository;

import com.example.customerservice.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByCustomerId(String policyNo);
}

