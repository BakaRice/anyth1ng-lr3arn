package com.ricemarch.accessdata.service.impl;

import com.ricemarch.accessdata.service.MybatisPlusLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisPlusLearnServiceImplTest {


    @Autowired
    private MybatisPlusLearnService mybatisPlusLearnService;

    @Test
    void testSelect() {
        mybatisPlusLearnService.testSelect();
    }

    @Test
    void testSelect2() {
        Map<String, List<?>> kvm = new HashMap<>();
        // kvm.put("id", List.of("111"));
        kvm.put("password", List.of("13251612723", "123"));
        mybatisPlusLearnService.testSelect2(kvm);
    }
}