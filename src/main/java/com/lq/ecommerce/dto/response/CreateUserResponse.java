package com.lq.ecommerce.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserResponse {
    private String buyerId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
