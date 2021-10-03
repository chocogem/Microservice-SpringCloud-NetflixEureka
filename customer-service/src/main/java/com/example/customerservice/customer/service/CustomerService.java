package com.example.customerservice.customer.service;

import com.example.customerservice.policy.client.PolicyClient;
import com.example.customerservice.policy.entity.Policy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.example.customerservice.customer.entity.Customer;
import com.example.customerservice.customer.repository.CustomerRepository;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PolicyClient policyClient;

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }


    @HystrixCommand(fallbackMethod = "fallbackFindCustomerByCustomerId")
    public Customer findCustomerByCustomerId(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresent(c -> {
            List<Policy> policies = policyClient.findPolicyByIdNumber(c.getIdNumber());
            c.setPolicies(policies);
        });

        return customer.orElse(null);
    }
    private Customer fallbackFindCustomerByCustomerId() {
        Customer customer = new Customer();
        customer.setPolicies(Collections.emptyList());
        return customer;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer) {
         customerRepository.save(customer);
    }
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }


}
