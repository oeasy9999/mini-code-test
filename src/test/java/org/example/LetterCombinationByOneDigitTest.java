package org.example;

import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.service.impl.LetterCombinationByOneDigit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.enums.ErrorCodeEnum.CONTAINS_NULL_VALUE;
import static org.example.enums.ErrorCodeEnum.ILLEGAL_VALUE;
import static org.example.enums.ErrorCodeEnum.NULL;
import static org.example.enums.ErrorCodeEnum.OUT_RANG;

public class LetterCombinationByOneDigitTest {

    private ILetterCombination letterCombination;

    @Before
    public void init() {
        letterCombination = new LetterCombinationByOneDigit();
    }

    @Test
    public void test1() {
        String result1 = letterCombination.combiningLetters(new Integer[]{2, 3});
        String expect1 = "ad ae af bd be bf cd ce cf";
        Assert.assertEquals(result1, expect1);
        String result2 = letterCombination.combiningLetters(new Integer[]{0, 2});
        String expect2 = "a b c";
        Assert.assertEquals(result2, expect2);
        String result3 = letterCombination.combiningLetters(new Integer[]{9});
        String expect3 = "w x y z";
        Assert.assertEquals(result3, expect3);
        String result4 = letterCombination.combiningLetters(new Integer[]{0});
        String expect4 = "";
        Assert.assertEquals(result4, expect4);
    }

    @Test
    public void test2() {
        try {
            letterCombination.combiningLetters(new Integer[]{});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), NULL.getMessage());
        }

        try {
            letterCombination.combiningLetters(new Integer[]{null});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), CONTAINS_NULL_VALUE.getMessage());
        }

        try {
            letterCombination.combiningLetters(new Integer[]{12});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), ILLEGAL_VALUE.getMessage());
        }

        try {
            letterCombination.combiningLetters(new Integer[]{1, 2, 3});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), OUT_RANG.getMessage());
        }
    }
}
