package com.ricemarch.accessdata.service;

import com.ricemarch.accessdata.dao.UserDao;
import com.ricemarch.accessdata.repository.TestRepository;
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
    private TestRepository testRepository;

    public List<UserDao> getList(){
        List<UserDao> userDaos = testRepository.listAll("");
        return userDaos;
    }
}
