package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amarendra on 16/3/17.
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, Long>{
}
