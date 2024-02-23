package com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.department;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Christine Gerard
 * @created 01/30/2024
 * @project cardealership-ws-2024
 */


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findDepartmentByDepartmentIdentifier_DepartmentId(String departmentId);

}
