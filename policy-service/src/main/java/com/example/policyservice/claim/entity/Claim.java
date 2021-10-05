package com.example.policyservice.claim.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Claim {
    @Id
    private String claimNo;
    private String policyNo;
    private String admitDate;
    private String dischargeDate;
    private String claimStatus;
    private String hospitalCode;
}