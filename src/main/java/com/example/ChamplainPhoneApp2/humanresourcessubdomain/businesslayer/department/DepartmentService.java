package com.example.ChamplainPhoneApp2.humanresourcessubdomain.businesslayer.department;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.department.DepartmentRequestModel;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.department.DepartmentResponseModel;

import java.util.List;

/**
 * @author Christine Gerard
 * @created 02/02/2024
 * @project cardealership-ws-2024
 */


public interface DepartmentService {

    List<DepartmentResponseModel> getAllDepartments();
    DepartmentResponseModel getDepartmentByDepartmentId(String departmentId);
    DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);
    DepartmentResponseModel updateDepartment(DepartmentRequestModel departmentRequestModel, String departmentId);
    void removeDepartmentByDepartmentId(String departmentId);
}
