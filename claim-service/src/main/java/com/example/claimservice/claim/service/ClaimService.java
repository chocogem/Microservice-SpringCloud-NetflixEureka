package com.example.claimservice.claim.service;

import com.example.claimservice.claim.entity.Claim;
import com.example.claimservice.claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;
    public List<Claim> findAllClaim() {
        return claimRepository.findAll();
    }
    public Optional<Claim> findClaimByClaimNo(String claimNo) {
        return claimRepository.findById(claimNo);
    }
    public List<Claim> findClaimByPolicyNo(String policyNo) {
        return claimRepository.findByPolicyNo(policyNo);
    }
    public Claim addClaim(Claim claim) {
        return claimRepository.save(claim);
    }
    public Claim updateClaim(Claim claim) {
        return claimRepository.save(claim);
    }
    public void deleteClaim(String claimNo) {
        claimRepository.deleteById(claimNo);
    }


}
