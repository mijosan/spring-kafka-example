package com.example.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.RequiredArgsConstructor;


@SpringBootApplication
public class SpringKafkaApplication implements CommandLineRunner {

    private static String TOPIC_NAME = "test";

	@Autowired
    private KafkaTemplate<String, String> template;

    public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            template.send(TOPIC_NAME, "test" + i);
        }
        System.exit(0);
    }
	
}
