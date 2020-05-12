package com.vmware.interview.exception;

import com.vmware.interview.constants.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * ValidationException for any Input Data Validation related Errors
 */
public class ValidationException extends BaseException {

    public ValidationException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, cause, errorCodeEnum, status);
    }

    public ValidationException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(message, cause, errorCodeEnum);
    }

    public ValidationException(String message, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, errorCodeEnum, status);
    }

    public ValidationException(String message, ErrorCodeEnum errorCodeEnum) {
        super(message, errorCodeEnum);
    }
}
