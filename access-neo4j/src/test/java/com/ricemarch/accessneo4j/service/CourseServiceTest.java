package com.ricemarch.accessneo4j.service;

import com.ricemarch.accessneo4j.entity.Course;
import com.ricemarch.accessneo4j.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FileService fileService;

    @Test
    void saveList() throws FileNotFoundException, ExecutionException, InterruptedException {
        String path = "D:\\tanwentao\\project\\anyth1ng-lr3arn\\access-neo4j\\src\\main\\resources\\static\\course.csv";
        List<Course> courses = fileService.loadCourseCsvFile(path);
        courseService.saveList(courses);
    }
}