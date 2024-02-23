package com.example.ChamplainPhoneApp2.customerrelationssubdomain.presentationlayer;

import lombok.*;
import com.example.ChamplainPhoneApp2.customerrelationssubdomain.datalayer.PhoneNumber;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CustomerResponseModel {

    String customerId;
    String firstName;
    String lastName;
    String emailAddress;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
    List<PhoneNumber> phoneNumbers;

}
