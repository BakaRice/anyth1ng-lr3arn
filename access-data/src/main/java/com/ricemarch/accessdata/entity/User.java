package com.ricemarch.accessdata.entity;

import lombok.Data;

/**
 * @author tanwentao
 * @since 2021/10/18
 */
@Data
public class User {
    private String id;//编号
    private String updateBy;//用户名
    private String password;//密码
    //省略get set方法
}