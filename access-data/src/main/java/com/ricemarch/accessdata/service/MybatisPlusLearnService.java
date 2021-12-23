package com.ricemarch.accessdata.service;

import java.util.List;
import java.util.Map;

/**
 * @author tanwentao
 * @since 2021/10/19
 */

public interface MybatisPlusLearnService {

    /**
     * mybatis-plus select test
     */
    void testSelect();


    /**
     * mybatis-plus select test2
     *
     * @param kvm
     */
    void testSelect2(Map<String, List<?>> kvm);
}
