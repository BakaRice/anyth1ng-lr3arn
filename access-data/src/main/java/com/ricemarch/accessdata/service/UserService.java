package com.ricemarch.accessdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ricemarch.accessdata.entity.User;
import com.ricemarch.accessdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/18
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getList() {
        List<User> all = userMapper.findAll();
        return all;
    }
}
