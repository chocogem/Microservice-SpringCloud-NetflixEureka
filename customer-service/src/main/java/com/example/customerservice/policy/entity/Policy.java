package com.example.customerservice.policy.entity;


import com.example.customerservice.claim.entity.Claim;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Policy {
    @Id
    private String policyNo;
    private String policyType;
    private String customerId;
    private List<Claim> claims;
}