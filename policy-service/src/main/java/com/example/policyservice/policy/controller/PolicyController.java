package com.example.policyservice.policy.controller;

import com.example.policyservice.claim.client.ClaimClient;
import com.example.policyservice.policy.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.policyservice.policy.service.PolicyService;
import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @Autowired
    private ClaimClient claimClient;

    @GetMapping
    public List<Policy> findAll() {
        return policyService.findAllPolicy();
    }

    @GetMapping("/{policyNo}")
    public Policy findPolicyByPolicyNo(@PathVariable String policyNo) {
        return policyService.findPolicyByPolicyNo(policyNo);
    }
    @GetMapping("findByIdNumber/{idNumber}")
    public List<Policy> findPolicyByIdNumber(@PathVariable String idNumber) {
        return policyService.findPolicyByIdNumber(idNumber);
    }
    @PostMapping
    public void addNewPolicy(@RequestBody Policy policy) {
         policyService.addPolicy(policy);
    }

    @PostMapping
    public void updatePolicy(@RequestBody Policy policy) {
         policyService.updatePolicy(policy);
    }

    @DeleteMapping("delete/{policyNo}")
    public void deletePolicy(@PathVariable String policyNo) {
        policyService.deletePolicy(policyNo);
    }

}
