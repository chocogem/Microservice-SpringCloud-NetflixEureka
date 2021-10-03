package com.example.customerservice.customer.controller;

import com.example.customerservice.policy.client.PolicyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.customerservice.customer.service.*;
import java.util.List;
import com.example.customerservice.customer.entity.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PolicyClient policyClient;

    @GetMapping
    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomer();
    }

    @GetMapping("/{customerId}")
    public Customer findCustomerByCustomerId(@PathVariable String customerId) {
        return customerService.findCustomerByCustomerId(customerId);
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer) {
         customerService.addCustomer(customer);
    }

    @PostMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
         customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }

}
