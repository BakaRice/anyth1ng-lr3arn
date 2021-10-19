package com.ricemarch.accessannotation.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AspectServiceTest {

    @Autowired
    private AspectService aspectService;

    @Test
    void riceLog() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        aspectService.riceLog("!~!");
    }
}