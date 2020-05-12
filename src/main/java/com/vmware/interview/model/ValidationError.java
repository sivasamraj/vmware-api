package com.vmware.interview.model;

import com.vmware.interview.constants.ErrorCodeEnum;

public class ValidationError {

    private String id;
    private String description;
    private String message;

    public ValidationError() {
    }

    public ValidationError(ErrorCodeEnum errorEnum, String message) {
        this.id = errorEnum.getId();
        this.description = errorEnum.getDescription();
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
