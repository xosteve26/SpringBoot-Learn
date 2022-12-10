package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("COMMAND LINE RUNNER");
        };
    }
    @Bean
    CustomerRepo customerRepo(){
        if(useFakeCustomerRepo){
            System.out.println("USE FAKE REPOSITORY");
            return new CustomerFakeRepository();
        }else{
            System.out.println("USE PRODUCTION REPOSITORY");
            return new CustomerRepository();
        }
    }
}
