package com.gusimple.controller;

import com.gusimple.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/14 14:22
 **/
@RestController
@RequestMapping("/users")
public class SpringJdbcController {

    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping
    public List<User> queryUsers(){
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // 根据主键ID查询
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @DeleteMapping("/{id}")
    public int delUser(@PathVariable Long id) {
        // 根据主键ID删除用户信息
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        // 添加用户
        String sql = "insert into t_user(username, password) values(?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }


    @PutMapping("/{id}")
    public int editUser(@PathVariable Long id, @RequestBody User user) {
        // 根据主键ID修改用户信息
        String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
    }
}
