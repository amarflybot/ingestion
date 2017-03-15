package com.example;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.Map;

/**
 * Created by amarendra on 16/3/17.
 */
public class MessageSerde implements Serde<Message<String>> {


    private final Serializer<String> serializer;
    private final Deserializer<String> deserializer;

    public MessageSerde(Serializer<String> serializer, Deserializer<String> deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    @Override
    public void configure(Map<String, ?> map, boolean b) {
        this.serializer.configure(map, b);
        this.deserializer.configure(map, b);
    }

    @Override
    public void close() {
        this.serializer.close();
        this.deserializer.close();
    }

    @Override
    public Serializer<Message<String>> serializer() {
        return this.serializer;
    }

    @Override
    public Deserializer<Message<String>> deserializer() {
        return null;
    }
}
