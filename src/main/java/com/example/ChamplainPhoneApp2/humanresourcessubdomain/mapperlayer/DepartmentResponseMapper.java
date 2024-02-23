package com.example.ChamplainPhoneApp2.humanresourcessubdomain.mapperlayer;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.department.DepartmentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Christine Gerard
 * @created 02/02/2024
 * @project cardealership-ws-2024
 */

@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseModel entityToResponseModel(Department department);

    List<DepartmentResponseModel> entityListToResponseModelList(List<Department> departments);
}
