package com.example.customerPortal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.customerPortal.model.Customer;

import com.example.customerPortal.repository.CustomerRepository;
import com.example.customerPortal.service.CustomerService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CustomerPortalApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Test
	@Order(1)
	public void testcreateCustomer()
	{
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstname("Honey");
		customer.setLastname("Jain");
		customer.setDob("01/01/2001");
			
		customerService.createCustomer(customer);
		assertNotNull(customerRepository.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testgetAll()
	{
		List<Customer> customerlist = customerService.getAll();
        assertThat(customerlist).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testupdateCustomer()
	{
		Customer customer = customerRepository.findById(1L).get();
		customer.setFirstname("Rohit");
		customerService.updateCustomer(1L, customer);
		assertNotEquals("Honey", customerRepository.findById(1L).get().getFirstname());
	}
	
	@Test
	@Order(4)
	public void testdeleteCustomer()
	{
		customerService.deleteCustomer(1L);
		assertThat(customerRepository.existsById(1L)).isFalse();
	}
}