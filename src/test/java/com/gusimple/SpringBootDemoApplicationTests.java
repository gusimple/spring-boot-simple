package com.gusimple;

import com.gusimple.dao.UserMapper;
import com.gusimple.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootDemoApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}
	@Test
	public void test1(){
		final int row1 = userMapper.insert(new User("u1", "p1"));
		log.info("[添加结果] - [{}]", row1);
		final int row2 = userMapper.insert(new User("u2", "p2"));
		log.info("[添加结果] - [{}]", row2);
		final int row3 = userMapper.insert(new User("u1", "p3"));
		log.info("[添加结果] - [{}]", row3);
		final List<User> u1 = userMapper.findByUsername("u1");
		log.info("[根据用户名查询] - [{}]", u1);
	}

}
