package com.example.policyservice.claim.client;

import com.example.policyservice.claim.entity.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("claim-service")
public interface ClaimClient {

    @GetMapping("/claims/findByPolicy/{policyNo}")
    List<Claim> findClaimByPolicyNo(@PathVariable String policyNo);

}
