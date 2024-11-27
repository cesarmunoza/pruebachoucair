package com.choucair.app;

import org.springframework.boot.SpringApplication;

public class TestChoucarchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChoucarchallengeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
