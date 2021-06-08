package com.example.customerPortal.contoller;


import com.example.customerPortal.exception.CustomerNotFoundException;
import com.example.customerPortal.model.Customer;
import com.example.customerPortal.service.CustomerService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerservice")
@ApiModel(description = "Controller for Customer Details Operations")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customer/")
    @ApiOperation(value = "Creates a new Customer", notes = "It creates a new Customer and save it in H2 database")
    public String createCustomer(@RequestBody Customer customer)
    {
    	logger.error("Inside CreateCustomer method..");
    	return customerService.createCustomer(customer);

    }
    
    @GetMapping("/customer/")
    @ApiOperation(value = "Display All Customers", notes = "It fetches all the Customers from H2 database")
    public List<Customer> getAll()
    {
    	logger.error("Inside GetAllCustomers method..");
        return customerService.getAll();
    }
    
    @GetMapping("/customer/{id}")
    @ApiOperation(value = "Display a Customer", notes = "It fetches a Customer from H2 database by its Id")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) throws CustomerNotFoundException
    {
    	logger.error("Inside CreateCustomerById method..");
    	return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    
    @PutMapping("/customer/{id}")
    @ApiOperation(value = "Update the Customer details by its Id", notes = "It updates the details of a particular Customer from H2 database by its Id")
    public ResponseEntity<Object> updateCustomer(@PathVariable long id,@RequestBody Customer customer) throws CustomerNotFoundException
    {
    	logger.error("Inside UpdateCustomerById method..");
        return new ResponseEntity<>(customerService.updateCustomer(id,customer),HttpStatus.CREATED);
    }
    @DeleteMapping("/customer/{id}")
    @ApiOperation(value = "Deletes a particular Customer", notes = "It deletes a particular customer by its Id")
    public ResponseEntity<Object> deleteCustomer(@PathVariable long id) throws CustomerNotFoundException
    {
    	logger.error("Inside DeleteCustomerById method..");
        return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
    }
}