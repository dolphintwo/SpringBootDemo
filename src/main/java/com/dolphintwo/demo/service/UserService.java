package com.dolphintwo.demo.service;

/**
 * Created by dd on 2018/8/29 16:03
 */

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name,Integer age);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
