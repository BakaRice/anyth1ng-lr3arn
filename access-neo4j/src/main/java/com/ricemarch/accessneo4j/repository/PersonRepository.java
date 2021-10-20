package com.ricemarch.accessneo4j.repository;

import com.ricemarch.accessneo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/20
 */

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByName(String name);

    List<Person> findByTeammatesName(String name);
}
