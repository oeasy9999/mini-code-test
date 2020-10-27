package org.example.service.impl;

import org.example.constant.DigitsLetterConstant;
import org.example.enums.ErrorCodeEnum;
import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.utils.DigitsLetterUtil;
import org.example.utils.InputValidateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinationByTwoDigits implements ILetterCombination {

    @Override
    public String combiningLetters(Integer[] inputArr) {
        ErrorCodeEnum errorCodeEnum = InputValidateUtil.inputValidate(inputArr, 2);
        if (!DigitsLetterConstant.SUCCESS_CODE.equals(errorCodeEnum.getCode())) {
            throw new CommonRuntimeException(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
        }
        if (inputArr.length == 1) {
            return preprocessData(inputArr).stream().collect(Collectors.joining(" "));
        } else {
            List<String> list = new ArrayList<>();
            List<String> leftList = preprocessData(new Integer[]{inputArr[0]});
            List<String> rightList = preprocessData(new Integer[]{inputArr[1]});
            List<String> resultList = DigitsLetterUtil.commonCombin(leftList, rightList, list);
            return resultList.stream().collect(Collectors.joining(" "));
        }
    }

    @Override
    public List<String> preprocessData(Integer[] inputArr) {
        Integer[] tempArrays = new Integer[2];
        if (inputArr[0] < 10) {
            tempArrays[0] = inputArr[0];
            tempArrays[1] = 0;
        } else {
            tempArrays[0] = inputArr[0] / 10;
            tempArrays[1] = inputArr[0] % 10;
        }
        List<String> list = new ArrayList<>();
        List<String> leftList = DigitsLetterConstant.DIGITS_MAP.get(tempArrays[0]);
        List<String> rightList = DigitsLetterConstant.DIGITS_MAP.get(tempArrays[1]);
        return DigitsLetterUtil.commonCombin(leftList, rightList, list);
    }
}
