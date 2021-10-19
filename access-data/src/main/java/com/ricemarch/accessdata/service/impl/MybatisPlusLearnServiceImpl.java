package com.ricemarch.accessdata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.accessdata.entity.User;
import com.ricemarch.accessdata.mapper.UserMapper;
import com.ricemarch.accessdata.service.MybatisPlusLearnService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author tanwentao
 * @since 2021/10/19
 */
@Service
@Slf4j
public class MybatisPlusLearnServiceImpl implements MybatisPlusLearnService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void testSelect() {
        log.info("--- selectAll method test ---");
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            log.info("User:{}", JSON.toJSON(user));
        }
    }

    @Override
    public void testSelect2(Map<String, List<?>> kvm) {
        //old version using EntityWrapper
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        List<?> idList = kvm.get("idList");
        List<?> nameList = kvm.get("password");
        if (CollectionUtils.isNotEmpty(idList)) {
            userQueryWrapper.eq("id", idList.get(0));
        }
        userQueryWrapper.in("password", nameList);
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            log.info("[Mybatis-plus]User:{}", JSON.toJSON(user));
        }
    }
}
