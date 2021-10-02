package com.example.customerservice.claim.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Claim {
    @Id
    private String claimNo;
    private String policyNo;
    private Date admitDate;
    private Date dischargeDate;
    private String claimStatus;
    private String hospitalCode;
}