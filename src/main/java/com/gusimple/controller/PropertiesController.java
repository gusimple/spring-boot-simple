package com.gusimple.controller;

import com.gusimple.entity.Myproperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author guxinxin
 * @Date 2020/1/9 17:11
 **/
@RequestMapping("/properties")
@RestController
public class PropertiesController {
    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);
    private final Myproperties myproperties;

    @Autowired
    public PropertiesController(Myproperties myproperties) {
        this.myproperties = myproperties;
    }
    @RequestMapping("/1")
    public Myproperties myproperties1(){
        log.info("===============================================================");
        log.info(myproperties.toString());
        log.info("===============================================================");
        return myproperties;
    }
}
