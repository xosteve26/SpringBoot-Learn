package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CustomerService {
    private final static Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService( CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }

    List<Customer> getCustomers(){
        LOGGER.info("In getCustomer method");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long customerId){
        return customerRepository
                .findById(customerId)
                .orElseThrow(()->{
                    NotFoundException notFoundException=new NotFoundException("Customer with ID "+customerId+" does not exist");
                    LOGGER.error("Error in getting customer {} ",customerId, notFoundException);
                    return notFoundException;
                });
    }

}
