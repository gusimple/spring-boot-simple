package com.gusimple.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/14 14:18
 **/
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 8655851615465363473L;

    private Long id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
