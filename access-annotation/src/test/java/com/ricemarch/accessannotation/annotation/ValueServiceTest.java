package com.ricemarch.accessannotation.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValueServiceTest {

    @Autowired
    private ValueService valueService;

    @Test
    void logValue() {
        valueService.logValue();
    }

}