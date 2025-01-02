package com.lq.ecommerce.exception;

import com.lq.ecommerce.dto.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<APIResponse<String>> handleAppException(AppException e) {
        APIResponse<String> response = APIResponse.<String>builder()
                .success(false)
                .message(e.getErrorCode().getMessage())
                .code(e.getErrorCode().getCode())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Use appropriate HTTP status
    }
}

