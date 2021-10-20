package com.ricemarch.accessneo4j.entity.csv;

import lombok.Data;

/**
 * @author tanwentao
 * @since 2021/10/20
 */
@Data
public class CourseCsv {
    // id,name,prerequisites,about,core_id,video_order,display_name,chapter

    private String id;
    private String name;
    private String prerequisites;
    private String about;
    private String core_id;
    private String video_order;
    private String display_name;
    private String chapter;

}
