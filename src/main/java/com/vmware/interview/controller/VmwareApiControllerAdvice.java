package com.vmware.interview.controller;

import com.vmware.interview.constants.ErrorCodeEnum;
import com.vmware.interview.exception.BusinessException;
import com.vmware.interview.exception.BaseException;
import com.vmware.interview.exception.SystemException;
import com.vmware.interview.exception.ValidationException;
import com.vmware.interview.model.BaseModel;
import com.vmware.interview.model.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Iterator;

@ControllerAdvice
public class VmwareApiControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(VmwareApiControllerAdvice.class);

    /**
     * Exception Handler for application specific custom ProductExceptions
     *
     * @param ex      Product exception
     * @param request Web request
     * @return Response object with the Product Base Model
     */
    @ExceptionHandler({SystemException.class, ValidationException.class, BusinessException.class, BaseException.class})
    public ResponseEntity<BaseModel> handleProductExceptions(BaseException ex, WebRequest request) {
        LOG.error("BaseException found : " + ex.getMessage(), ex);
        ValidationError error = new ValidationError(ex.getErrorCodeEnum(), ex.getMessage());
        BaseModel errorModel = new BaseModel();
        errorModel.setErrors(Arrays.asList(error));
        return new ResponseEntity<>(errorModel, ex.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Exception found : " + ex.getMessage(), ex);

        ValidationError error = new ValidationError(ErrorCodeEnum.VALIDATION_EXCEPTION, ex.getMessage());
        BaseModel errorModel = new BaseModel();
        errorModel.setErrors(Arrays.asList(error));
        return handleExceptionInternal(ex, errorModel, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("MethodArgumentNotValidException found : " + ex.getMessage(), ex);


        StringBuilder sb = (new StringBuilder("Validation failed for ")).append(ex.getBindingResult().getErrorCount()).append(" arguments: ");
        Iterator var2 = ex.getBindingResult().getAllErrors().iterator();

        while (var2.hasNext()) {
            ObjectError error = (ObjectError) var2.next();
            DefaultMessageSourceResolvable df = (DefaultMessageSourceResolvable) error.getArguments()[0];

            sb.append("[").append(df.getDefaultMessage() + " " + error.getDefaultMessage()).append("] ");
        }

        ValidationError error = new ValidationError(ErrorCodeEnum.VALIDATION_EXCEPTION, sb.toString());
        BaseModel errorModel = new BaseModel();
        errorModel.setErrors(Arrays.asList(error));
        return handleExceptionInternal(ex, errorModel, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("HttpMessageNotReadableException found : " + ex.getMessage(), ex);

        ValidationError error = new ValidationError(ErrorCodeEnum.VALIDATION_EXCEPTION, "Required request body is missing or invalid format ");
        BaseModel errorModel = new BaseModel();
        errorModel.setErrors(Arrays.asList(error));
        return handleExceptionInternal(ex, errorModel, headers, status, request);
    }

    /**
     * Exception Handler for all other unhandled application exceptions
     *
     * @param ex      Exception
     * @param request Web request
     * @return Response object with the Product Base Model
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseModel> handleExceptions(Exception ex, WebRequest request) {
        LOG.error("Exception found : " + ex.getMessage(), ex);
        ValidationError error = new ValidationError(ErrorCodeEnum.SYSTEM_EXCEPTION, ex.getMessage());
        BaseModel errorModel = new BaseModel();
        errorModel.setErrors(Arrays.asList(error));
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
