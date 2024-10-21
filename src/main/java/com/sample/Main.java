package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustmorRepository custmorRepository;

    public Main(CustmorRepository custmorRepository) {
        this.custmorRepository = custmorRepository;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return custmorRepository.findAll();
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
