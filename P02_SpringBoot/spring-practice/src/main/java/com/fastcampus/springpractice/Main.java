package com.fastcampus.springpractice;

import com.fastcampus.springpractice.logic.JavaSort;
import com.fastcampus.springpractice.logic.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort<String> sort = new JavaSort<>();

        System.out.println("[Result] " + sort.sort(Arrays.asList(args)));
    }
}