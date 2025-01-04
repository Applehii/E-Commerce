package com.lq.ecommerce.controller;

import com.lq.ecommerce.dto.request.CreateUserRequest;
import com.lq.ecommerce.dto.response.APIResponse;
import com.lq.ecommerce.dto.response.CreateUserResponse;
import com.lq.ecommerce.service.BuyerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PostMapping("/sign-up")
    public APIResponse<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return APIResponse.<CreateUserResponse>builder()
                .success(true)
                .message("success")
                .code(200)
                .data(buyerService.createUser(createUserRequest))
                .build();
    }
}
