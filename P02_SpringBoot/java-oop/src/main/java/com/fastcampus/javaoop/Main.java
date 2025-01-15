package com.fastcampus.javaoop;

import com.fastcampus.javaoop.logic.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BubbleSort<String> bubbleSort = new BubbleSort<>();

        System.out.println("[Result] " + bubbleSort.sort(Arrays.asList(args)));
    }
}