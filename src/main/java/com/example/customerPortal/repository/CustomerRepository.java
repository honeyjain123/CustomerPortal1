package com.example.customerPortal.repository;

import com.example.customerPortal.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    }
