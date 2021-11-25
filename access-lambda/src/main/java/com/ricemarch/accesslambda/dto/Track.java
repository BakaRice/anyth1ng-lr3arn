package com.ricemarch.accesslambda.dto;

import lombok.Data;

/**
 * @author tanwentao
 * @since 2021/11/23
 */

@Data
public class Track {
    private String name;

    private Integer length;

    public Track(String name, Integer num) {
        this.name = name;
        this.length = num;
    }


}
