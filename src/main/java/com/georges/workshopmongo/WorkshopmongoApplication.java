package com.georges.workshopmongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class WorkshopmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongoApplication.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017/workshop_mongo");
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(settings);
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "workshop_mongo");
	}
}