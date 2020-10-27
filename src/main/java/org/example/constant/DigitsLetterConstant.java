package org.example.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DigitsLetterConstant {
    /**
     *  digits mapping letters
     */
    public static final Map<Integer, List<String>> DIGITS_MAP = new HashMap<Integer, List<String>>() {
        {
            put(0, Arrays.asList(""));
            put(1, Arrays.asList(""));
            put(2, Arrays.asList("a", "b", "c"));
            put(3, Arrays.asList("d", "e", "f"));
            put(4, Arrays.asList("g", "h", "i"));
            put(5, Arrays.asList("j", "k", "l"));
            put(6, Arrays.asList("m", "n", "o"));
            put(7, Arrays.asList("p", "q", "r", "s"));
            put(8, Arrays.asList("t", "u", "v"));
            put(9, Arrays.asList("w", "x", "y", "z"));

        }
    };

    /**
     *  rsponse code : 0000
     */
    public static final String SUCCESS_CODE = "0000";
    /**
     *  rsponse code : E001
     */
    public static final String NULL_CODE = "E001";
    /**
     *  rsponse code : E002
     */
    public static final String CONTAINS_NULL_VALUE_CODE = "E002";
    /**
     *  rsponse code : E003
     */
    public static final String OUT_RANG_CODE = "E003";
    /**
     *  rsponse code : E004
     */
    public static final String ILLEGAL_VALUE_CODE = "E004";
    /**
     *  rsponse msg : success
     */
    public static final String SUCCESS_MSG = "success";
    /**
     *  rsponse msg : parmameter is null!
     */
    public static final String NULL_MSG = "parmameter is null!";
    /**
     *  rsponse msg : parameter contains null value!
     */
    public static final String CONTAINS_NULL_VALUE_MSG = "parameter contains null value!";
    /**
     *  rsponse msg : parameter value is out of rang!
     */
    public static final String OUT_RANG_MSG = "parameter value is out of rang!";
    /**
     *  rsponse msg : parameter contains illegal value!
     */
    public static final String ILLEGAL_VALUE_MSG = "parameter contains illegal value!";

}
