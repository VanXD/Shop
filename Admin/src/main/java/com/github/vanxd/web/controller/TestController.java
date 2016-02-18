package com.github.vanxd.web.controller;

import com.github.vanxd.entity.UserTest;
import com.github.vanxd.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/2/18.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserTestService userTestService;

    @RequestMapping("/testAdd")
    @ResponseBody
    public UserTest testAdd(Long id, Integer num) {
        return userTestService.testAdd(id, num);
    }

    @RequestMapping("/testFindAll")
    @ResponseBody
    public List<UserTest> testFindAll() {
        return userTestService.findAll();
    }

}
