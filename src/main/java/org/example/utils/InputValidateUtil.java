package org.example.utils;

import org.example.enums.ErrorCodeEnum;

import java.util.List;

import static org.example.enums.ErrorCodeEnum.CONTAINS_NULL_VALUE;
import static org.example.enums.ErrorCodeEnum.ILLEGAL_VALUE;
import static org.example.enums.ErrorCodeEnum.NULL;
import static org.example.enums.ErrorCodeEnum.OUT_RANG;
import static org.example.enums.ErrorCodeEnum.SUCCESS;

public class InputValidateUtil {

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    /**
     *  validate input
     * @param input     digits of input
     * @param size      1:one digit number, 2: two digits numbers
     * @return          ErrorCodeEnum contains code and message
     */
    public static ErrorCodeEnum inputValidate(Integer[] input, int size) {
        if (null == input || input.length == 0) {
            return NULL;
        }
        if (input.length > 2) {
            return OUT_RANG;
        }

        for (Integer i : input) {
            if (null == i) {
                return CONTAINS_NULL_VALUE;
            } else if (i > sizeTable[size - 1] || i < 0) {
                return ILLEGAL_VALUE;
            }
        }
        return SUCCESS;
    }
}
