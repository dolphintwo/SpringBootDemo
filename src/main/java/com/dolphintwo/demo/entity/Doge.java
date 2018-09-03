package com.dolphintwo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by dd on 2018/9/3 10:53
 */

@Getter
@Setter
public class Doge {

    @Id
    private Long id;

    private String name;
    private Integer age;

    public Doge(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
