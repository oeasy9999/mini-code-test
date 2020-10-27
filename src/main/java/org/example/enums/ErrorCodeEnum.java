package org.example.enums;

import org.example.constant.DigitsLetterConstant;

/**
 *  errorcode Enum
 */
public enum ErrorCodeEnum {
    SUCCESS(DigitsLetterConstant.SUCCESS_CODE, DigitsLetterConstant.SUCCESS_MSG),
    NULL(DigitsLetterConstant.NULL_CODE, DigitsLetterConstant.NULL_MSG),
    CONTAINS_NULL_VALUE(DigitsLetterConstant.CONTAINS_NULL_VALUE_CODE, DigitsLetterConstant.CONTAINS_NULL_VALUE_MSG),
    OUT_RANG(DigitsLetterConstant.OUT_RANG_CODE, DigitsLetterConstant.OUT_RANG_MSG),
    ILLEGAL_VALUE(DigitsLetterConstant.ILLEGAL_VALUE_CODE, DigitsLetterConstant.ILLEGAL_VALUE_MSG);

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
