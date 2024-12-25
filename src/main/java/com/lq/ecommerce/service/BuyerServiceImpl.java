package com.lq.ecommerce.service;

import com.lq.ecommerce.dto.request.CreateUserRequest;
import com.lq.ecommerce.dto.response.CreateUserResponse;
import com.lq.ecommerce.exception.AppException;
import com.lq.ecommerce.exception.ErrorCode;
import com.lq.ecommerce.mapper.BuyerMapper;
import com.lq.ecommerce.model.Buyer;
import com.lq.ecommerce.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BuyerMapper buyerMapper;


    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if(buyerRepository.existsBuyerByUsername(createUserRequest.getUsername())){
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        buyerRepository.saveBuyer(createUserRequest.getUsername(),passwordEncoder.encode(createUserRequest.getPassword()),createUserRequest.getEmail(), createUserRequest.getPhone(), createUserRequest.getAddress());
        Buyer buyer = buyerRepository.findByUsername(createUserRequest.getUsername());
        return buyerMapper.toCreateUserResponse(buyer) ;
    }
}
