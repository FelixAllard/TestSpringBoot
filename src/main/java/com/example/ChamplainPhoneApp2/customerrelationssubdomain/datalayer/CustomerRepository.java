package com.example.ChamplainPhoneApp2.customerrelationssubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerIdentifier_CustomerId(String customerId);

    Customer findByCustomerIdentifier_emailAddress(String email);
}