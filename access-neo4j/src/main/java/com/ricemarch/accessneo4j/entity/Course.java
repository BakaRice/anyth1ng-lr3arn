package com.ricemarch.accessneo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

/**
 * @author tanwentao
 * @since 2021/10/20
 */
@Data
public class Course {
    // name	prerequisites	about	core_id	video_order	display_name	chapter

    @Id
    @GeneratedValue
    private Long id;

    private String courseId;

    private String name;

    private String about;

    private String coreId;

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }


    public Course(String courseId, String name, String about) {
        this.courseId = courseId;
        this.name = name;
        this.about = about;
    }
}
