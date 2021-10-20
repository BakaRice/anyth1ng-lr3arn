package com.ricemarch.accessneo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanwentao
 * @since 2021/10/20
 */

@Node
@Data
public class Person {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "TEAMMATE")
    public Set<Person> teammates;

    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public Person(String name) {
        this.name = name;
    }
}
