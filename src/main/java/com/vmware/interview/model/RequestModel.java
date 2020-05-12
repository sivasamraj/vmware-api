package com.vmware.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class RequestModel {
    @JsonProperty("X")
    @NotEmpty(message = "Value can't be null or empty")
    private String operandX;

    @JsonProperty("Y")
    private String operandY;

    public RequestModel(String x, String y) {
        this.operandX = x;
        this.operandY = y;
    }

    public RequestModel() {
    }

    public String getOperandX() {
        return operandX;
    }

    public void setOperandX(String operandX) {
        this.operandX = operandX;
    }

    public String getOperandY() {
        return operandY;
    }

    public void setOperandY(String operandY) {
        this.operandY = operandY;
    }
}
