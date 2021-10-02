package com.example.claimservice.claim.repository;

import com.example.claimservice.claim.entity.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClaimRepository extends MongoRepository<Claim, String> {
    List<Claim> findByPolicyNo(String policyNo);
}
