package com.lq.ecommerce.controller;

import com.lq.ecommerce.dto.request.CreateUserRequest;
import com.lq.ecommerce.dto.response.APIResponse;
import com.lq.ecommerce.dto.response.CreateUserResponse;
import com.lq.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/sign-up")
    public APIResponse<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        APIResponse<CreateUserResponse> apiResponse = new APIResponse<>();
        apiResponse.setData(buyerService.createUser(createUserRequest));
        return apiResponse;
    }
}