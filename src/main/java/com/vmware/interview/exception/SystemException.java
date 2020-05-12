package com.vmware.interview.exception;

import com.vmware.interview.constants.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * SystemException for any System related Errors
 */
public class SystemException extends BaseException {

    public SystemException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, cause, errorCodeEnum, status);
    }

    public SystemException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(message, cause, errorCodeEnum);
    }

    public SystemException(String message, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, errorCodeEnum, status);
    }

    public SystemException(String message, ErrorCodeEnum errorCodeEnum) {
        super(message, errorCodeEnum);
    }
}
