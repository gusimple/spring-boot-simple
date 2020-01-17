package com.gusimple.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gusimple.dao.UserMapper;
import com.gusimple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/15 17:50
 **/
@RestController
@RequestMapping("/page")
public class PagehelperController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagehelperController.class);
    @Autowired
    private UserMapper mapper;

    @RequestMapping("/test")
    public void test1(){
//        User ss1 = new User("ss1", "123");
//        User ss2 = new User("ss2", "123");
//        User ss3 = new User("ss3", "123");
//        mapper.insertSelective(ss1);
//        LOGGER.info("[user1回写主键] - [{}]", ss1.getId());
//        mapper.insertSelective(ss2);
//        LOGGER.info("[user2回写主键] - [{}]", ss2.getId());
//        mapper.insertSelective(ss3);
//        LOGGER.info("[user3回写主键] - [{}]", ss3.getId());
//        final int count = mapper.countByUserName("ss1");
//        LOGGER.info("[调用自己写的SQL] - [{}]", count);
        //模拟分页
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        mapper.insertSelective(new User("u1","p1"));
        PageInfo<Object> objectPageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.mapper.selectAll());
        LOGGER.info("[lambda写法] - [分页信息] - [{}]",objectPageInfo.toString());

    }


}
