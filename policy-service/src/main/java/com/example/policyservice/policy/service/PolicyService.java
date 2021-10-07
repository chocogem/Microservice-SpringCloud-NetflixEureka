package com.example.policyservice.policy.service;

import com.example.policyservice.claim.client.ClaimClient;
import com.example.policyservice.claim.entity.Claim;
import com.example.policyservice.policy.entity.Policy;
import com.example.policyservice.policy.repository.PolicyRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimClient claimClient;

    public List<Policy> findAllPolicy() {
        return policyRepository.findAll();
    }


    @HystrixCommand(fallbackMethod = "fallbackFindPolicyByPolicyNo")
    public Policy findPolicyByPolicyNo(String policyNo) {
        Optional<Policy> policy = policyRepository.findById(policyNo);
        policy.ifPresent(p -> {
            List<Claim> claims = claimClient.findClaimByPolicyNo(p.getPolicyNo());
            p.setClaims(claims);
        });

        return policy.orElse(null);
    }
    private Policy fallbackFindPolicyByPolicyNo() {
        Policy policy = new Policy();
        policy.setClaims(Collections.emptyList());
        return policy;
    }
    @HystrixCommand(fallbackMethod = "fallbackFindPolicyByIdNumber")
    public List<Policy> findPolicyByIdNumber(String idNumber) {
        List<Policy> policy = policyRepository.findByIdNumber(idNumber);
        return policy;
    }
    private Policy fallbackFindPolicyByIdNumber() {
        Policy policy = new Policy();
        policy.setClaims(Collections.emptyList());
        return policy;
    }
    public Policy addPolicy(Policy policy) {
        return policyRepository.save(policy);
    }
    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }
    public void deletePolicy(String policyNo) {
        policyRepository.deleteById(policyNo);
    }


}
