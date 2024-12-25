package com.lq.ecommerce.service;

import com.lq.ecommerce.dto.request.AuthenticationRequest;
import com.lq.ecommerce.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
