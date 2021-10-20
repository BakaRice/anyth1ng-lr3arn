package com.ricemarch.accessneo4j.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    void loadFile() throws FileNotFoundException {
        String path = "D:\\tanwentao\\project\\anyth1ng-lr3arn\\access-neo4j\\src\\main\\resources\\static\\teacher.csv";
        fileService.loadTeacherCsvFile(path);
    }

    @Test
    void loadCourseCsvFile() {
    }

    @Test
    void loadTeacherCsvFile() {
    }

    @Test
    void loadTeacherCourseCsvFile() throws FileNotFoundException {
        String path = "D:\\tanwentao\\project\\anyth1ng-lr3arn\\access-neo4j\\src\\main\\resources\\static\\teacher-course.csv";
        fileService.loadTeacherCourseCsvFile(path);
    }
}