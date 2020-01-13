package com.gusimple.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/9 17:02
 **/
@Data
@Component
@PropertySource("classpath:my.yml")
@ConfigurationProperties(prefix = "my")
public class Myproperties {
    private int age;
    private String name;


}
