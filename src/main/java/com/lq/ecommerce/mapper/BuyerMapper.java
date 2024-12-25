package com.lq.ecommerce.mapper;

import com.lq.ecommerce.dto.response.CreateUserResponse;
import com.lq.ecommerce.model.Buyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper {
    CreateUserResponse toCreateUserResponse(Buyer buyer);
}
