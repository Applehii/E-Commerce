package com.lq.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USERNAME_ALREADY_EXISTS(400, "Username already exists", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(400, "Username must be from 4 to 10 characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(400, "Password length must be at least 8", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(400, "Invalid email", HttpStatus.BAD_REQUEST),
    EMAIL_EXIST(400, "This email has been used by other", HttpStatus.BAD_REQUEST),
    INVALID_PHONE(400, "Phone number length must contains 10 numbers", HttpStatus.BAD_REQUEST),
    INCORRECT_USERNAME_OR_PASSWORD(400, "Incorrect username or password", HttpStatus.BAD_REQUEST)
    ;
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
