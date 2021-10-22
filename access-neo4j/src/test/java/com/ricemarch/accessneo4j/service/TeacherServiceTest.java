package com.ricemarch.accessneo4j.service;

import com.alibaba.fastjson.JSON;
import com.ricemarch.accessneo4j.entity.Teacher;
import com.ricemarch.accessneo4j.entity.TeacherCourse;
import com.ricemarch.accessneo4j.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@Slf4j
class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

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


    @Test
    void find() {
        Teacher byTeacherId = teacherRepository.findByTeacherId("T_李楠");
        log.info("{}", JSON.toJSON(byTeacherId));
    }
}