package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RequestMapping(path = "api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return
                customerService.getCustomers()
                        .stream()
                        .filter(customer -> customer.getId().equals(id))
                        .findFirst()
                        .orElseThrow(()->new IllegalStateException("Customer Not Found"));
    }

    @PostMapping
    void createCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST "+customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE CUSTOMER WITH ID: "+id);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE CUSTOMER "+customer);
    }

}
