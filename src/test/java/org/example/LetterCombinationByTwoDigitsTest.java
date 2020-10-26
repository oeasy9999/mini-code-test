package org.example;

import org.example.exception.CommonRuntimeException;
import org.example.service.ILetterCombination;
import org.example.service.impl.LetterCombinationByOneDigit;
import org.example.service.impl.LetterCombinationByTwoDigits;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.enums.ErrorCodeEnum.CONTAINS_NULL_VALUE;
import static org.example.enums.ErrorCodeEnum.ILLEGAL_VALUE;
import static org.example.enums.ErrorCodeEnum.NULL;
import static org.example.enums.ErrorCodeEnum.OUT_RANG;

public class LetterCombinationByTwoDigitsTest {

    private ILetterCombination letterCombination;

    @Before
    public void init() {
        letterCombination = new LetterCombinationByTwoDigits();
    }

    @Test
    public void test1() {
        String result1 = letterCombination.combiningLetters(new Integer[]{2});
        String expect1 = "a b c";
        Assert.assertEquals(result1, expect1);
        String result2 = letterCombination.combiningLetters(new Integer[]{12, 34});
        String expect2 = "adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi";
        Assert.assertEquals(result2, expect2);
        String result3 = letterCombination.combiningLetters(new Integer[]{22, 34});
        String expect3 = "aadg aadh aadi aaeg aaeh aaei aafg aafh aafi abdg abdh abdi abeg abeh abei abfg abfh abfi acdg acdh acdi aceg aceh acei acfg acfh acfi badg badh badi baeg baeh baei bafg bafh bafi bbdg bbdh bbdi bbeg bbeh bbei bbfg bbfh bbfi bcdg bcdh bcdi bceg bceh bcei bcfg bcfh bcfi cadg cadh cadi caeg caeh caei cafg cafh cafi cbdg cbdh cbdi cbeg cbeh cbei cbfg cbfh cbfi ccdg ccdh ccdi cceg cceh ccei ccfg ccfh ccfi";
        Assert.assertEquals(result3, expect3);
        String result4 = letterCombination.combiningLetters(new Integer[]{2, 4});
        String expect4 = "ag ah ai bg bh bi cg ch ci";
        Assert.assertEquals(result4, expect4);
        String result5 = letterCombination.combiningLetters(new Integer[]{2, 45});
        String expect5 = "agj agk agl ahj ahk ahl aij aik ail bgj bgk bgl bhj bhk bhl bij bik bil cgj cgk cgl chj chk chl cij cik cil";
        Assert.assertEquals(result5, expect5);
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
            letterCombination.combiningLetters(new Integer[]{123});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), ILLEGAL_VALUE.getMessage());
        }

        try {
            letterCombination.combiningLetters(new Integer[]{12, 23, 3});
        } catch (CommonRuntimeException e) {
            Assert.assertEquals(e.getMessage(), OUT_RANG.getMessage());
        }
    }
}
