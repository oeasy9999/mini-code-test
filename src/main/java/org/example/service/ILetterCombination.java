package org.example.service;

import org.example.exception.CommonRuntimeException;

import java.util.List;

public interface ILetterCombination {
    /**
     *  combinination Letters by digits arrays
     * @param inputArr      digits of input
     * @return              combination letter string
     */
    String combiningLetters(Integer[] inputArr);

    /**
     *  preprocessing data for digits arrays
     * @param inputArr      digits of input
     * @return              preprocessed data
     */
    List<String> preprocessData(Integer[] inputArr);
}
