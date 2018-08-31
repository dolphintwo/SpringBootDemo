package com.dolphintwo.demo.repository;

import com.dolphintwo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by dd on 2018/8/31 10:29
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query(value = "from User u where u.name=:name")
    User findUser(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "delete from User")
    void deleteAllUsers();
}
