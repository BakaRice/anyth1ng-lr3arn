package com.ricemarch.accessneo4j.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherCsvServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    void build() {
        teacherService.build();
    }

    @Test
    void save() {
        teacherService.save();
    }
}