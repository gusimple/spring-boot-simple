package com.gusimple.dao;

import com.gusimple.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/14 17:35
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     *根据用户名查询用户结果集
     * @param username 用户名
     * @return 查询结果
     */
    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(User user);

    /**
     * 根据用户名统计
     * @param username 用户名
     * @return 统计结果
     */
    int countByUserName(String username);
}
