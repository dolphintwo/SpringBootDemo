package com.dolphintwo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DolphinTwo
 * @date 2018/5/21
 */
@Component
@RestController
public class ValueController {

    @Value("${com.dolphintwo.demo.name}")
    private String name;

    @Value("${com.dolphintwo.demo.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @RequestMapping("/value")
    public String showValue(){
        return "My name is "+name+", and this article's title is 《"+title+"》";
    }
}
