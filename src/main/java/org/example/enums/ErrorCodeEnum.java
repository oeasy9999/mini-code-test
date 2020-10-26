package org.example.enums;

/**
 *  errorcode Enum
 */
public enum ErrorCodeEnum {
    SUCCESS("0000", "success"),
    NULL("E001", "parmameter is null!"),
    CONTAINS_NULL_VALUE("E002", "parameter contains null value!"),
    OUT_RANG("E003", "parameter value is out of rang!"),
    ILLEGAL_VALUE("E004", "parameter contains illegal value!");

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
