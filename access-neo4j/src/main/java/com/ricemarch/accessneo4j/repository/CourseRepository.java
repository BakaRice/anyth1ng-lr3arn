package com.ricemarch.accessneo4j.repository;

import com.ricemarch.accessneo4j.entity.Course;
import com.ricemarch.accessneo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author tanwentao
 * @since 2021/10/20
 */

public interface CourseRepository extends Neo4jRepository<Course, Long> {

    // Course findByCid(String cid);
    Course findByCourseId(String cid);
}
