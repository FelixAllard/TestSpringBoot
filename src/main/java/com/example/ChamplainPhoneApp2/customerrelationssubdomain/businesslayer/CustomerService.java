package com.example.ChamplainPhoneApp2.customerrelationssubdomain.businesslayer;


import com.example.ChamplainPhoneApp2.customerrelationssubdomain.datalayer.*;
import com.example.ChamplainPhoneApp2.customerrelationssubdomain.presentationlayer.*;

import java.util.List;

public interface CustomerService {

    List<com.example.ChamplainPhoneApp2.customerrelationssubdomain.presentationlayer.CustomerResponseModel> getCustomers();
    CustomerResponseModel getCustomerByCustomerId(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);
    void removeCustomer(String customerId);


    public void removeCustomerByEmail(String email);
}


