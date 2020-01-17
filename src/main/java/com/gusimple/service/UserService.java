package com.gusimple.service;

import com.gusimple.entity.User;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/16 17:27
 **/
public interface UserService {
    /**
     * 保存或者更新
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrupdate(User user);

    /**
     * 获取用户
     * @param id key值
     * @return 返回结果
     */
    User get(Long id);

    /**
     * 删除
     * @param id key值
     */
    void delete(Long id);
}
