package com.dolphintwo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DolphinTwo
 * @date 2018/5/21
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
