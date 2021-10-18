package com.ricemarch.accessdata.mapper;

import com.ricemarch.accessdata.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/18
 */
@Repository
public interface UserMapper {

    List<User> findAll();
}
