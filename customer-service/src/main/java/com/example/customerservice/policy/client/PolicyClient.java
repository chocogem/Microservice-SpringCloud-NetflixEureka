package com.example.customerservice.policy.client;

import com.example.customerservice.policy.entity.Policy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "policy-service")
public interface PolicyClient {

    @GetMapping("/policies/findByIdNumber/{idNumber}")
    List<Policy> findPolicyByIdNumber(@PathVariable String idNumber);

}
