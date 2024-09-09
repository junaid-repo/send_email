package com.scheduler.dokcer_fo_mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DokcerFoMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(DokcerFoMailApplication.class, args);
	}

}
