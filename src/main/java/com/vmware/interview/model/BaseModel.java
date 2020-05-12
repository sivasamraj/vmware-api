package com.vmware.interview.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class BaseModel implements Serializable {

    private List<ValidationError> errors;

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
