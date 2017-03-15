package com.example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by amarendra on 15/3/17.
 */
public interface ProducerChannels {

    @Output
    MessageChannel consumer();
}
