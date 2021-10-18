package com.ricemarch.accessdata.controller;

import com.ricemarch.accessdata.entity.User;
import com.ricemarch.accessdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/18
 */
@RestController("/rice/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        List<User> list = userService.getList();
        return list;
    }
}
