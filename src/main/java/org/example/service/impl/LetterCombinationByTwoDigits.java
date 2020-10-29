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
        Integer[] arr = preprocessData(inputArr);
        int arrLen = arr.length;
        int bit[] = new int[arrLen];
        int num = 1;
        for (int i = 0; i < arrLen; i++) {
            bit[i] = DigitsLetterConstant.DIGITS_MAP.get(arr[i]).size();
            num *= bit[i];
        }

        List<String> letters = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int[] index = DigitsLetterUtil.getIndex(bit, i);
            String str = DigitsLetterUtil.getLetter(DigitsLetterConstant.DIGITS_MAP, arr, index);
            letters.add(str);
        }
        return  letters.stream().collect(Collectors.joining(" "));
    }

    @Override
    public Integer[] preprocessData(Integer[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return new Integer[0];
        }

        List<Integer> filterList = new ArrayList<>();
        //split [12, 3] into [1, 2, 3]
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] > 10 && inputArr[i] < 100) {
                filterList.add(inputArr[i] / 10);
                filterList.add(inputArr[i] % 10);
            } else {
                filterList.add(inputArr[i]);
            }
        }
        //filter 0,1
        filterList = filterList.stream().filter(x -> x != 0 && x != 1).collect(Collectors.toList());
        return filterList.toArray(new Integer[filterList.size()]);
    }
}
