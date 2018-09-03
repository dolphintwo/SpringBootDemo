package com.dolphintwo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by dd on 2018/9/3 16:16
 */

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "author")
public class Author {

    private String name;
    private Long age;

}
