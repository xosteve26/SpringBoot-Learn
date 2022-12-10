package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomer(){
        return Arrays.asList(
                new Customer(1L,"James", "password123"),
                new Customer(2L,"Alex", "1234password"));
    }

}
