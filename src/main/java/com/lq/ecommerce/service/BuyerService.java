package com.lq.ecommerce.service;

import com.lq.ecommerce.dto.request.CreateUserRequest;
import com.lq.ecommerce.dto.response.CreateUserResponse;

public interface BuyerService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
