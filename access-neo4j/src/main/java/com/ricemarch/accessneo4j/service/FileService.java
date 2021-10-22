package com.ricemarch.accessneo4j.service;

import com.alibaba.fastjson.JSON;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ricemarch.accessneo4j.entity.Course;
import com.ricemarch.accessneo4j.entity.Teacher;
import com.ricemarch.accessneo4j.entity.csv.CourseCsv;
import com.ricemarch.accessneo4j.entity.TeacherCourse;
import com.ricemarch.accessneo4j.entity.csv.TeacherCsv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/20
 */

@Service
@Slf4j
public class FileService {

    public List<Course> loadCourseCsvFile(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        List<CourseCsv> courseCsvList = new CsvToBeanBuilder<CourseCsv>(fileReader).withType(CourseCsv.class).build().parse();
        List<Course> courseList = convertCsvCourse(courseCsvList);
        return courseList;
    }

    public List<Teacher> loadTeacherCsvFile(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        List<TeacherCsv> teacherCsvList = new CsvToBeanBuilder<TeacherCsv>(fileReader).withType(TeacherCsv.class).build().parse();
        List<Teacher> teachersList =
                convertCsvTeacher(teacherCsvList);
        return teachersList;
    }

    public List<TeacherCourse> loadTeacherCourseCsvFile(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        List<TeacherCourse> teacherCourseList = new CsvToBeanBuilder<TeacherCourse>(fileReader).withType(TeacherCourse.class).build().parse();
        for (TeacherCourse teacherCourse : teacherCourseList) {
            log.info("{}", JSON.toJSON(teacherCourse));
        }
        return teacherCourseList;

    }

    private List<Course> convertCsvCourse(List<CourseCsv> courseCsvList) {
        List<Course> courseList = new ArrayList<>();
        for (CourseCsv courseCsv : courseCsvList) {
            Course course = new Course();
            //courseCsv.getId(), courseCsv.getName()
            course.setCourseId(courseCsv.getId());
            course.setName(courseCsv.getName());
            courseList.add(course);
        }
        return courseList;
    }


    private List<Teacher> convertCsvTeacher(List<TeacherCsv> teacherCsvList) {
        List<Teacher> teachersList = new ArrayList<>();
        for (TeacherCsv teacherCsv : teacherCsvList) {
            // log.info("{}", teacherCsv);
            Teacher teacher = new Teacher(teacherCsv.getId(), teacherCsv.getName(), teacherCsv.getAbout());
            teachersList.add(teacher);
        }
        return teachersList;
    }

}
