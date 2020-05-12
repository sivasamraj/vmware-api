package com.vmware.interview.exception;

import com.vmware.interview.constants.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.VALIDATION_EXCEPTION;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BaseException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message, cause);
        this.errorCodeEnum = errorCodeEnum;
        this.status = status;
    }

    public BaseException(String message, Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(message, cause);
        this.errorCodeEnum = errorCodeEnum;
    }

    public BaseException(String message, ErrorCodeEnum errorCodeEnum, HttpStatus status) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
        this.status = status;
    }

    public BaseException(String message, ErrorCodeEnum errorCodeEnum) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
        if (errorCodeEnum.equals(ErrorCodeEnum.VALIDATION_EXCEPTION)) {
            this.status = HttpStatus.BAD_REQUEST;
        }
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
