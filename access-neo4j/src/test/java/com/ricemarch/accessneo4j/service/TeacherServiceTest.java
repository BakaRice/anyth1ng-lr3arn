package com.ricemarch.accessneo4j.service;

import com.ricemarch.accessneo4j.entity.Teacher;
import com.ricemarch.accessneo4j.entity.TeacherCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FileService fileService;

    @Test
    void saveList() throws FileNotFoundException, ExecutionException, InterruptedException {
        String path = "D:\\tanwentao\\project\\anyth1ng-lr3arn\\access-neo4j\\src\\main\\resources\\static\\teacher.csv";
        List<Teacher> teachers = fileService.loadTeacherCsvFile(path);
        teacherService.saveList(teachers);
    }

    @Test
    void saveRelation() throws FileNotFoundException {
        String path = "D:\\tanwentao\\project\\anyth1ng-lr3arn\\access-neo4j\\src\\main\\resources\\static\\teacher-course.csv";
        List<TeacherCourse> teacherCourseList = fileService.loadTeacherCourseCsvFile(path);
        teacherService.saveRelation(teacherCourseList);
    }
}