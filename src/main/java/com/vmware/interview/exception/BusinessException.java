package com.vmware.interview.exception;

import com.vmware.interview.constants.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * BusinessException for any Business related Errors
 */
public class BusinessException extends BaseException {

    public BusinessException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, cause, errorCodeEnum, status);
    }

    public BusinessException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(message, cause, errorCodeEnum);
    }

    public BusinessException(String message, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, errorCodeEnum, status);
    }

    public BusinessException(String message, ErrorCodeEnum errorCodeEnum) {
        super(message, errorCodeEnum);
    }


}

