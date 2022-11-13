package com.example.demo.customer;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomer(){
        return Arrays.asList(
                new Customer(1L,"James"),
                new Customer(2L,"Alex"));
    }

}
