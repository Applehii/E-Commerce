package com.lq.ecommerce.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class APIResponse<T> {
    private boolean success;
    private String message;
    private int code;
    private T data;

    public APIResponse() {
        success = true;
        code = 200;
    }
}
