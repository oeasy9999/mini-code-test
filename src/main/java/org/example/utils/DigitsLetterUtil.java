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

    /**
     *
     * @param map
     * @param arr
     * @param index
     * @return
     */
    public static String getLetter(Map<Integer, List<String>> map,Integer[] arr, int[] index){
        StringBuilder letter = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            letter.append(map.get(arr[i]).get(index[i]));
        }
        return letter.toString();
    }

    /**
     *
     * @param bit
     * @param n
     * @return
     */
    public static int[] getIndex(int[] bit, int n){
        int[] index = new int[bit.length];
        for (int i = bit.length -1; i >= 0 ; i--) {
            index[i] = n % bit[i];
            n /= bit[i];
        }
        return index;
    }
}
