package com.example.policyservice.policy.repository;

import com.example.policyservice.policy.entity.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PolicyRepository extends MongoRepository<Policy, String> {
    List<Policy> findByIdNumber(String idNumber);
}
