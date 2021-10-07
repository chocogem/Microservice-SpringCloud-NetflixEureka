package com.example.customerservice.customer.service;

import com.example.customerservice.claim.client.ClaimClient;
import com.example.customerservice.claim.entity.Claim;
import com.example.customerservice.customer.entity.Customer;
import com.example.customerservice.customer.repository.CustomerRepository;
import com.example.customerservice.policy.client.PolicyClient;
import com.example.customerservice.policy.entity.Policy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PolicyClient policyClient;

    @Autowired
    private ClaimClient claimClient;

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }


    @HystrixCommand(fallbackMethod = "fallbackFindCustomerByCustomerId")
    public Customer findCustomerByCustomerId(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresent(c -> {
            List<Policy> policies = policyClient.findPolicyByIdNumber(c.getIdNumber());
            policies.stream().filter(Objects::nonNull)
                    .collect(Collectors.toList()).forEach(p -> {
                List<Claim> claims = claimClient.findClaimByPolicyNo(p.getPolicyNo());
                p.setClaims(claims);
            });
            c.setPolicies(policies);
        });

        return customer.orElse(null);
    }
    private Customer fallbackFindCustomerByCustomerId() {
        Customer customer = new Customer();
        customer.setPolicies(Collections.emptyList());
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }


}
