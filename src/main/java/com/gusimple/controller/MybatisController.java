package com.gusimple.controller;

import com.gusimple.dao.UserMapper;
import com.gusimple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/15 16:38
 **/
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisController.class);

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/test")
    public void mybatisTest(){
        int insert = mapper.insert(new User("gu15", "gu12"));
        LOGGER.info("insert0执行"+insert);
        int insert2 = mapper.insert(new User("gu16", "gu12"));
        LOGGER.info("insert2执行"+insert2);
        List<User> gu15 = mapper.findByUsername("gu15");
        LOGGER.info("gu15"+gu15);
    }
}
