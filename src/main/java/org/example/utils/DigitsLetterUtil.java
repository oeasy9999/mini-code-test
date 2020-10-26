package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DigitsLetterUtil {

    /**
     *  A general method of combining string list
     * @param leftlist      left part of combining string
     * @param rightlist     right part of combining string
     * @param tempList      the temporary part of combining string
     * @return              concatenated string
     */
    public static List<String> commonCombin(List<String> leftlist, List<String> rightlist, List<String> tempList) {
        for (String aString : leftlist) {
            for (String bString : rightlist) {
                tempList.add(aString + bString);
            }
        }
        return tempList;
    }
}
