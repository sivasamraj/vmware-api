package com.vmware.interview.model;

public class ResponseModel {

    private String result;

    public ResponseModel(String result) {
        this.result = result;
    }

    public ResponseModel() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
