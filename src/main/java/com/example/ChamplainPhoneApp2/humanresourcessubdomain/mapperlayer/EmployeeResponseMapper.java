package com.example.ChamplainPhoneApp2.humanresourcessubdomain.mapperlayer;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.employee.Address;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Christine Gerard
 * @created 02/06/2024
 * @project cardealership-ws-2024
 */

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    @Mapping(expression = "java(employee.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(employee.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(employee.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(employee.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(employee.getAddress().getPostalCode())", target = "postalCode")
    @Mapping(source = "employee.phoneNumberList", target = "phoneNumbers")
    @Mapping(source = "employee.positionTitle", target = "title")
    @Mapping(expression = "java(employee.getSalary().getSalary())", target = "salary")
    @Mapping(expression = "java(employee.getSalary().getCurrency())", target = "currency")
    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    @Mapping(expression = "java(department.getName())", target = "departmentName")
    EmployeeResponseModel entityToResponseModel(Employee employee, Department department);

}
