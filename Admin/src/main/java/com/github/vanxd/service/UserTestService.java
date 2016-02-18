package com.github.vanxd.service;

import com.github.vanxd.entity.UserTest;
import com.github.vanxd.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/2/18.
 */
@Service
@Transactional
public class UserTestService {
    @Autowired
    private UserTestRepository userTestRepository;

    public UserTest testAdd(Long id, Integer num) {
        UserTest userTest = new UserTest();
        userTest.setId(id);
        userTest.setNum(num);
        return userTestRepository.save(userTest);
    }

    public List<UserTest> findAll() {
        return userTestRepository.findAll();
    }


}
