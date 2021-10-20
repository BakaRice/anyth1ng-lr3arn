package com.ricemarch.accessneo4j.service;

import com.ricemarch.accessneo4j.entity.Course;
import com.ricemarch.accessneo4j.entity.Teacher;
import com.ricemarch.accessneo4j.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tanwentao
 * @since 2021/10/20
 */
@Service
@Slf4j
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ThreadPoolExecutor NeoThreadPoolExecutor;


    public void saveList(List<Course> CourseList) throws ExecutionException, InterruptedException {
        int size = 200;
        int i = 0;

        List<CompletableFuture> futureList = new ArrayList<>();

        List<List<Course>> partition = ListUtils.partition(CourseList, size);
        for (List<Course> courses : partition) {
            i++;

            int finalI = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                courseRepository.saveAll(courses);
                log.info("[插入完成]{}", finalI);
                return null;
            }, NeoThreadPoolExecutor));
            log.info("save-{}-{}", i, size);
        }
        final CompletableFuture<Void> future = CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new));
        future.get();

    }

}
