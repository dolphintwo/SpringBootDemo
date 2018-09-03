package com.dolphintwo.demo.repository;

import com.dolphintwo.demo.entity.Doge;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dd on 2018/9/3 11:00
 */

public interface DogeRepository  extends MongoRepository<Doge, Long> {

    Doge findByName(String name);

}
