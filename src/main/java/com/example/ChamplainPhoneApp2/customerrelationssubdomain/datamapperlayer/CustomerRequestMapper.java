
package com.example.ChamplainPhoneApp2.customerrelationssubdomain.datamapperlayer;

import com.example.ChamplainPhoneApp2.customerrelationssubdomain.datalayer.*;
import com.example.ChamplainPhoneApp2.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
    })
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel,
                                  CustomerIdentifier customerIdentifier,
                                  Address address);
}
