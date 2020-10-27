package org.example;

import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.service.impl.LetterCombinationByOneDigit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LetterCombinationByOneDigitTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ILetterCombination letterCombination;

    @Before
    public void init() {
        letterCombination = new LetterCombinationByOneDigit();
    }

    @Test
    public void testMultiElementToLetterCombination() {
        String result1 = letterCombination.combiningLetters(new Integer[]{2, 3});
        String expect1 = "ad ae af bd be bf cd ce cf";
        Assert.assertEquals(result1, expect1);
    }

    @Test
    public void testSingleElementToLetterCombination() {
        String result3 = letterCombination.combiningLetters(new Integer[]{9});
        String expect3 = "w x y z";
        Assert.assertEquals(result3, expect3);
    }

    @Test
    public void testContains0or1ToLetterCombination() {
        String result2 = letterCombination.combiningLetters(new Integer[]{0, 2});
        String expect2 = "a b c";
        Assert.assertEquals(result2, expect2);
    }

    @Test
    public void testSingle0or1ToLetterCombination() {
        String result4 = letterCombination.combiningLetters(new Integer[]{0});
        String expect4 = "";
        Assert.assertEquals(result4, expect4);
    }

    @Test
    public void testNullException() {
        thrown.expect(CommonRuntimeException.class);
        thrown.expectMessage("parmameter is null!");
        letterCombination.combiningLetters(new Integer[]{});
    }

    @Test
    public void testContainsNullValueException() {
        thrown.expect(CommonRuntimeException.class);
        thrown.expectMessage("parameter contains null value!");
        letterCombination.combiningLetters(new Integer[]{null});
    }

    @Test
    public void testIllegalValueException() {
        thrown.expect(CommonRuntimeException.class);
        thrown.expectMessage("parameter contains illegal value!");
        letterCombination.combiningLetters(new Integer[]{12});
    }

    @Test
    public void testOutRangException() {
        thrown.expect(CommonRuntimeException.class);
        thrown.expectMessage("parameter value is out of rang!");
        letterCombination.combiningLetters(new Integer[]{1, 2, 3});
    }
}
