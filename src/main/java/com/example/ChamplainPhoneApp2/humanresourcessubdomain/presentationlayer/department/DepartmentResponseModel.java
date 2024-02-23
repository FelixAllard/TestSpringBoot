package com.example.ChamplainPhoneApp2.humanresourcessubdomain.presentationlayer.department;

import com.example.ChamplainPhoneApp2.humanresourcessubdomain.dataaccesslayer.department.Position;
import lombok.*;

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
public class DepartmentResponseModel {

    String departmentId;
    String name;
    Integer headCount;

    List<Position> positions;

}
