package com.example.claimservice.claim.controller;

import com.example.claimservice.claim.entity.Claim;
import com.example.claimservice.claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<Claim> findAllClaim() {
        return claimService.findAllClaim();
    }

    @GetMapping("/{claimNo}")
    public Optional<Claim> findClaimByClaimNo(@PathVariable String claimNo) {
        return claimService.findClaimByClaimNo(claimNo);
    }
    @GetMapping("/findByPolicy/{policyNo}")
    List<Claim> findClaimByPolicyNo(@PathVariable String policyNo){
        return claimService.findClaimByPolicyNo(policyNo);
    }
    @PostMapping
    public Claim addNewCliam(@RequestBody Claim claim) {
        return claimService.addClaim(claim);
    }

    @PutMapping("/update")
    public Claim updateClaim(@RequestBody Claim claim) {
        return claimService.updateClaim(claim);
    }

    @DeleteMapping("/delete/{claimNo}")
    public void deleteClaim(@PathVariable String claimNo) {
        claimService.deleteClaim(claimNo);
    }

}
