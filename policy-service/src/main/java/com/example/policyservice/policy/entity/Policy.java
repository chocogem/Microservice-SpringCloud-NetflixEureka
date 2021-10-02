package com.example.policyservice.policy.entity;


import com.example.policyservice.claim.entity.Claim;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Policy {
    @Id
    private String policyNo;
    private String policyType;
    private String idNumber;
    private List<Claim> claims;
}