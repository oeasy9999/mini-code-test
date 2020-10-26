package org.example.service.impl;

import org.example.constant.DigitsLetter;
import org.example.enums.ErrorCodeEnum;
import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.utils.DigitsLetterUtil;
import org.example.utils.InputValidateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinationByOneDigit implements ILetterCombination {

    @Override
    public String combiningLetters(Integer[] inputArr) {
        ErrorCodeEnum errorCodeEnum = InputValidateUtil.inputValidate(inputArr, 1);
        if (!"0000".equals(errorCodeEnum.getCode())) {
            throw new CommonRuntimeException(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
        }
        return preprocessData(inputArr).stream().collect(Collectors.joining(" "));
    }

    @Override
    public List<String> preprocessData(Integer[] inputArr) {
        Integer[] tempArrays = new Integer[2];
        List<String> list = new ArrayList<>();
        tempArrays[0] = inputArr[0];
        if (inputArr.length == 1) {
            tempArrays[1] = 0;
        } else {
            tempArrays[1] = inputArr[1];
        }
        List<String> leftList = DigitsLetter.DIGITS_MAP.get(tempArrays[0]);
        List<String> rightList = DigitsLetter.DIGITS_MAP.get(tempArrays[1]);
        list = DigitsLetterUtil.commonCombin(leftList, rightList, list);
        return list;
    }
}

