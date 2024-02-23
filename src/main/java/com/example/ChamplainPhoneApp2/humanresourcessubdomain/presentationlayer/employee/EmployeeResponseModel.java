package com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.employee;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.employee.CurrencyType;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Christine Gerard
 * @created 02/02/2024
 * @project cardealership-ws-2024
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseModel {

    String employeeId;
    String firstName;
    String lastName;
    String emailAddress;
    List<PhoneNumber> phoneNumbers;

    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;

    String departmentId;
    String departmentName; //comes from DepartmentIdentifier

    String title;

    BigDecimal salary;
    CurrencyType currency;
    Double commissionRate;


}
