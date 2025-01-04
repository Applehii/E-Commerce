package com.lq.ecommerce.dto.request;

import com.lq.ecommerce.annotations.EmailUnique;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @Size(min = 4, max = 10, message = "INVALID_USERNAME")
    private String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    @Email(message = "INVALID_EMAIL")
    @EmailUnique
    private String email;
    @Size(min = 10, max = 10, message = "INVALID_PHONE")
    private String phone;
    private String address;
}
