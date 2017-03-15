package com.example;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.Random;
import java.util.logging.Logger;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class ConsumerApplication {

	@Bean
	@Scope("prototype")
	Logger logger (InjectionPoint injectionPoint){
		return Logger.getLogger(injectionPoint.getDeclaredType().getName());
	}

	@Bean
	IntegrationFlow integrationFlow(Logger logger, ConsumerChannels channels, MessageRepository repository){
		return IntegrationFlows.from(channels.producer())
				.handle(String.class, (payload,headers) -> {
					logger.info("new Message: "+ payload);
					repository.save(new Message(new Random().nextLong(), payload));
					return null;
				})
				.get();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
