package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService( CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomer();
    }

    Customer getCustomer(Long customerId){
        return customerRepo.getCustomer()
                .stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Customer with id "+ customerId+ " was not found"));
    }

}
