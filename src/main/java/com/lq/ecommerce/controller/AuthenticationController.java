//package com.lq.ecommerce.controller;
//
//import com.lq.ecommerce.dto.request.AuthenticationRequest;
//import com.lq.ecommerce.dto.response.APIResponse;
//import com.lq.ecommerce.dto.response.AuthenticationResponse;
//import com.lq.ecommerce.service.AuthenticationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthenticationController {
//    @Autowired
//    private AuthenticationService authenticationService;
//    @PostMapping("/log-in")
//    public APIResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        AuthenticationResponse response = authenticationService.authenticate(request);
//        APIResponse<AuthenticationResponse> apiResponse = new APIResponse<>();
//        apiResponse.setData(response);
//        return apiResponse;
//    }
//
//
//}
