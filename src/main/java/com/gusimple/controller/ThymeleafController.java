package com.gusimple.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 测试thymeleaf
 * @Author guxinxin
 * @Date 2020/1/10 16:33
 **/

@Controller
@RequestMapping
public class ThymeleafController {

    @GetMapping("index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        //设置跳转的视图，默认映射到src/main/resources/templates/{viewname}.html
        modelAndView.setViewName("index");
        modelAndView.addObject("title","第一个web页面");
        modelAndView.addObject("desc","欢迎进入gusimple系统");
        Author author = new Author();
        author.setAge(27);
        author.setName("gusimple");
        author.setEmail("634529909@qq.com");
        request.setAttribute("author",author);
        return modelAndView;
    }
    @Data
    private class Author {
        private int age;
        private String name;
        private String email;

    }
}
