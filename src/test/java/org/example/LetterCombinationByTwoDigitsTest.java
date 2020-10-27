package org.example;

import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.service.impl.LetterCombinationByTwoDigits;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LetterCombinationByTwoDigitsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ILetterCombination letterCombination;

    @Before
    public void init() {
        letterCombination = new LetterCombinationByTwoDigits();
    }

    @Test
    public void testMultiElementToLetterCombination() {
        String result2 = letterCombination.combiningLetters(new Integer[]{12, 34});
        String expect2 = "adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi";
        Assert.assertEquals(result2, expect2);
    }

    @Test
    public void testSingleElementToLetterCombination() {
        String result1 = letterCombination.combiningLetters(new Integer[]{2});
        String expect1 = "a b c";
        Assert.assertEquals(result1, expect1);
    }

    @Test
    public void testContains0or1ToLetterCombination() {
        String result5 = letterCombination.combiningLetters(new Integer[]{12, 45});
        String expect5 = "agj agk agl ahj ahk ahl aij aik ail bgj bgk bgl bhj bhk bhl bij bik bil cgj cgk cgl chj chk chl cij cik cil";
        Assert.assertEquals(result5, expect5);
    }

    @Test
    public void testContainsDuplicateElementsToLetterCombination() {
        String result3 = letterCombination.combiningLetters(new Integer[]{22, 34});
        String expect3 = "aadg aadh aadi aaeg aaeh aaei aafg aafh aafi abdg abdh abdi abeg abeh abei abfg abfh abfi acdg acdh acdi aceg aceh acei acfg acfh acfi badg badh badi baeg baeh baei bafg bafh bafi bbdg bbdh bbdi bbeg bbeh bbei bbfg bbfh bbfi bcdg bcdh bcdi bceg bceh bcei bcfg bcfh bcfi cadg cadh cadi caeg caeh caei cafg cafh cafi cbdg cbdh cbdi cbeg cbeh cbei cbfg cbfh cbfi ccdg ccdh ccdi cceg cceh ccei ccfg ccfh ccfi";
        Assert.assertEquals(result3, expect3);
    }

    @Test
    public void testOneDigitToLetterCombination() {
        String result4 = letterCombination.combiningLetters(new Integer[]{2, 4});
        String expect4 = "ag ah ai bg bh bi cg ch ci";
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
        letterCombination.combiningLetters(new Integer[]{123});
    }

    @Test
    public void testOutRangException() {
        thrown.expect(CommonRuntimeException.class);
        thrown.expectMessage("parameter value is out of rang!");
        letterCombination.combiningLetters(new Integer[]{12, 23, 3});
    }
}
