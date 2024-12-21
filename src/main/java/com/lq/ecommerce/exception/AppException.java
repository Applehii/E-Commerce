package com.lq.ecommerce.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
   private ErrorCode errorCode;
  public AppException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode =errorCode ;
  }
}
