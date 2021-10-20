package com.ricemarch.accessneo4j.repository;

import com.ricemarch.accessneo4j.entity.Person;
import com.ricemarch.accessneo4j.entity.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author tanwentao
 * @since 2021/10/20
 */

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {

    Teacher findByTeacherId(String tid);
}
