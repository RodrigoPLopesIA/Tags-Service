package com.rodrigolopesai.tags_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TagsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagsServiceApplication.class, args);
	}

}
