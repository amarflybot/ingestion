package com.example;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by amarendra on 15/3/17.
 */
public interface ConsumerChannels {

    @Input
    SubscribableChannel producer();
}
