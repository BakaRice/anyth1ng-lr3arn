package com.ricemarch.accessneo4j.service;

import com.ricemarch.accessneo4j.entity.Course;
import com.ricemarch.accessneo4j.entity.Teacher;
import com.ricemarch.accessneo4j.entity.TeacherCourse;
import com.ricemarch.accessneo4j.repository.CourseRepository;
import com.ricemarch.accessneo4j.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author tanwentao
 * @since 2021/10/20
 */
@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ThreadPoolExecutor NeoThreadPoolExecutor;


    public void build() {
    }

    public void save() {
        String teacherId = "T_方维奇";
        String name = "方维奇";
        String about = "方维奇，男，陕西工业职业技术学院教师，讲师。主持并参与院级科研项目3项，发表教科研论文13篇，主编教材2本。多次获得全国高职高专教师教学能力大赛一等奖，并指导学生获得技能竞赛一等奖。";
        Teacher teacher = new Teacher(teacherId, name, about);
        teacherRepository.save(teacher);
    }

    public void saveList(List<Teacher> teacherList) throws ExecutionException, InterruptedException {
        int size = 200;
        int i = 0;

        List<CompletableFuture> futureList = new ArrayList<>();

        List<List<Teacher>> partition = ListUtils.partition(teacherList, size);
        for (List<Teacher> teachers : partition) {
            i++;

            int finalI = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                teacherRepository.saveAll(teachers);
                log.info("[插入完成]{}", finalI);
                return null;
            }, NeoThreadPoolExecutor));
            log.info("save-{}-{}", i, size);
        }
        final CompletableFuture<Void> future = CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new));
        future.get();

    }

    public void saveRelation(List<TeacherCourse> teacherCourseList) {
        List<String> cidList = teacherCourseList.stream().map(TeacherCourse::getCid).collect(Collectors.toList());
        List<String> tidList = teacherCourseList.stream().map(TeacherCourse::getTid).collect(Collectors.toList());

        List<String> disCidList = new ArrayList<>();
        List<String> disTidList = new ArrayList<>();
        Map<String, String> c2t = new HashMap<>();
        Map<String, String> t2c = new HashMap<>();
        Iterator<String> cidIterator = cidList.iterator();
        while (cidIterator.hasNext()) {
            String next = cidIterator.next();
            if (!disCidList.contains(next)) {
                disCidList.add(next);
            }
        }
        Iterator<String> tidIterator = tidList.iterator();
        while (tidIterator.hasNext()) {
            String next = tidIterator.next();
            if (!disTidList.contains(next)) {
                disTidList.add(next);
            }
        }
        Map<String, Course> courseMap = new HashMap<>();
        for (String s : disCidList) {
            Course byCourseId = courseRepository.findByCourseId(s);
            courseMap.put(byCourseId.getCourseId(), byCourseId);
        }

        Map<String, Teacher> teacherMap = new HashMap<>();

        List<Teacher> teacherList = new ArrayList<>();
        for (String s : disTidList) {
            Teacher byTeacherId = teacherRepository.findByTeacherId(s);
            teacherMap.put(byTeacherId.getTeacherId(), byTeacherId);
            teacherList.add(byTeacherId);
        }

        for (String tid : tidList) {
            String cid = t2c.get(tid);
            Teacher teacher = teacherMap.get(tid);
            teacher.haveCourse(courseMap.get(cid));
        }

        List<List<Teacher>> partition = ListUtils.partition(teacherList, 100);
        for (List<Teacher> teachers : partition) {
            teacherRepository.saveAll(teachers);
        }

    }
}