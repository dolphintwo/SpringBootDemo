package com.dolphintwo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DolphinTwo
 * @date 2018/5/21
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://dinghui.me");
        return "index";
    }
}
