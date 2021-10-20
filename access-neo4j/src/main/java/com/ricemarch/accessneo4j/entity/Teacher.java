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
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String teacherId;

    private String name;

    private String about;

    public Teacher(String teacherId, String name, String about) {
        this.teacherId = teacherId;
        this.name = name;
        this.about = about;
    }

    @Relationship(type = "HAVING")
    public Set<Course> courses;

    public void haveCourse(Course course) {
        if (courses == null) {
            courses = new HashSet<>();
        }
        courses.add(course);
    }


}
