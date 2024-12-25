package com.lq.ecommerce.service;


import com.lq.ecommerce.dto.request.AuthenticationRequest;
import com.lq.ecommerce.dto.response.AuthenticationResponse;
import com.lq.ecommerce.exception.AppException;
import com.lq.ecommerce.exception.ErrorCode;
import com.lq.ecommerce.model.Buyer;
import com.lq.ecommerce.repository.BuyerRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.experimental.NonFinal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private BuyerRepository buyerRepository;

    @NonFinal
    protected static final String SIGNER_KEY = "7VoCUTXxrWuUD+YoZPnLovQ8f11PsdMNSA4QEGaSjLI4tSaF6vzk6H2sifqExGU1\n";


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Buyer buyer = buyerRepository.findByUsername(authenticationRequest.getUsername());
        if (buyer == null) {
            throw new AppException(ErrorCode.INCORRECT_USERNAME_OR_PASSWORD);
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean matches = passwordEncoder.matches(authenticationRequest.getPassword(), buyer.getPassword());
        if (!matches) {
            throw new AppException(ErrorCode.INCORRECT_USERNAME_OR_PASSWORD);
        }
    String token = generateToken(authenticationRequest.getUsername());
        return  AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    private String generateToken(String username) {
        JWSHeader jwsHeader= new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("ecommerce.app")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
