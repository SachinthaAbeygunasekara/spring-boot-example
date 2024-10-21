package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

    record NewCustomerRequest(String name,String email,Integer age){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        custmorRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        custmorRepository.deleteById(id);
    }
}
