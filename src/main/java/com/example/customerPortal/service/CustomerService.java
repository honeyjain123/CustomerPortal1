package com.example.customerPortal.service;


import com.example.customerPortal.model.Customer;
import com.example.customerPortal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository cust;
    
    public String createCustomer(Customer customer)
    {
        Customer tempcustomer = new Customer();
        tempcustomer.setFirstname(customer.getFirstname());
        tempcustomer.setLastname(customer.getLastname());
        tempcustomer.setDob(customer.getDob());
		
        cust.save(tempcustomer);
        
        return "Customer created successfully";
    }
    
    public List<Customer> getAll()
    {
        List<Customer> customerlist = cust.findAll();
        return customerlist;
    }
    
    public String updateCustomer(long id,Customer customer)
    {
        Customer tempcustomer = cust.findById(id).get();
       
        if(customer.getFirstname() != null){
        	tempcustomer.setFirstname(customer.getFirstname());
        }
        if(customer.getLastname() != null){
        	tempcustomer.setLastname(customer.getLastname());
        }
        if(customer.getDob() != null){
        	tempcustomer.setDob(customer.getDob());
        }
        cust.save(tempcustomer);
        return "Customer Updated Successfully";
    }
    
    public String deleteCustomer(long id)
    {
        cust.deleteById(id);
        return "Customer deleted successfully";
    }
    
	public Customer getCustomerById(long id) 
	{	
		Customer customer = cust.findById(id).get();
		return customer;
	}
}
