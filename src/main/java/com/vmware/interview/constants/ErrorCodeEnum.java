package com.vmware.interview.constants;

public enum ErrorCodeEnum {

    SYSTEM_EXCEPTION("1000", "System Exception"),
    BUSINESS_EXCEPTION("2000", "Business Exception"),
    VALIDATION_EXCEPTION("3000", "Data Validation Exception");

    private String id ;

    private String description;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    ErrorCodeEnum(String id, String description) {
        this.id=id;
        this.description = description;
    }
}
