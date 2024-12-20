package com.lq.ecommerce.mapper;

import com.lq.ecommerce.dto.response.SupplierReponse;
import com.lq.ecommerce.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierReponse toSupplierReponse(Supplier supplier);

}
