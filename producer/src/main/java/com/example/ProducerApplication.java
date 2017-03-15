package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding(ProducerChannels.class)
public class ProducerApplication {

    private final MessageChannel messageChannel;
    public ProducerApplication(ProducerChannels producerChannels) {
        this.messageChannel = producerChannels.consumer();
    }

    @PostMapping("/greet/{name}")
	public void publish(@PathVariable String name){
		String greeting = "Hello "+name+"!";
        Message<String> message = MessageBuilder.withPayload(greeting).build();
        this.messageChannel.send(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
