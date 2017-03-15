package com.example;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.messaging.Message;

import java.util.Map;

/**
 * Created by amarendra on 16/3/17.
 */
public class MessageSerializer implements Serializer<Message<String>> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Message<String> stringMessage) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
