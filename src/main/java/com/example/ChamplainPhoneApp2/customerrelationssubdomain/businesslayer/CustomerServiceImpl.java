package com.example.ChamplainPhoneApp2.customerrelationssubdomain.businesslayer;



import com.example.ChamplainPhoneApp2.customerrelationssubdomain.datamapperlayer.*;
import com.example.ChamplainPhoneApp2.customerrelationssubdomain.presentationlayer.*;
import com.example.ChamplainPhoneApp2.utils.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import com.example.ChamplainPhoneApp2.customerrelationssubdomain.datalayer.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerRequestMapper customerRequestMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerResponseMapper customerResponseMapper,
                               CustomerRequestMapper customerRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (customer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        return customerResponseMapper.entityToResponseModel(customer);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());

        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel, new CustomerIdentifier(), address);

        customer.setAddress(address);
        return customerResponseMapper.entityToResponseModel(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        //check if a customer with the provided UUID exists in the system. If it doesn't, return null
        //later, when we implement exception handling, we'll return an exception
        if (existingCustomer == null) {
            throw new com.example.ChamplainPhoneApp2.utils.exceptions.NotFoundException("Unknown customerId: " + customerId);
        }
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());
        Customer updatedCustomer = customerRequestMapper.requestModelToEntity(customerRequestModel,
            existingCustomer.getCustomerIdentifier(), address);
        updatedCustomer.setId(existingCustomer.getId());

        Customer response = customerRepository.save(updatedCustomer);
        return customerResponseMapper.entityToResponseModel(response);
    }

    @Override
    public void removeCustomer(String customerId) {
        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }

        customerRepository.delete(existingCustomer);
    }

    @Override
    public void removeCustomerByEmail(String email) {
        Customer existingCustomer = customerRepository.findByCustomerIdentifier_emailAddress(email);

        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + email);
        }

        customerRepository.delete(existingCustomer);
    }



}
