package com.ricemarch.accessdata.repository;

import com.ricemarch.accessdata.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/18
 */
@Repository
public interface TestRepository {
    List<UserDao> listAll(@Param("pwd") String pwd);
}
