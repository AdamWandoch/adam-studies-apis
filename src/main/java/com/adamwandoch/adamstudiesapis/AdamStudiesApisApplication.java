package com.adamwandoch.adamstudiesapis;

import com.adamwandoch.adamstudiesapis.factory.FactorySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class AdamStudiesApisApplication {

	@Autowired
	public FactorySimulator factorySimulator;

	public static void main(String[] args) {
		SpringApplication.run(AdamStudiesApisApplication.class, args);
	}

	@Scheduled(fixedRate = 1000)
	void runTasks() {
		factorySimulator.refreshData();
	}
}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration {
}
