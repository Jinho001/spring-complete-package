package com.fastcampus.programming.dmaker.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevDtoTest {
    @Test
    void test() {
        DevDto devDto = new DevDto();

        devDto.setName("snow");
        System.out.println(devDto.getName());
    }
}