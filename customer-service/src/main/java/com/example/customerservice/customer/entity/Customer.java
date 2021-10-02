package com.example.customerservice.customer.entity;

import com.example.customerservice.policy.entity.Policy;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Customer {
    @Id
    private String customerId;
    private String idNumber;
    private String firstName;
    private String LastName;
    private List<Policy> policies;
}
