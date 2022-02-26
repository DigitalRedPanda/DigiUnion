package com.DigiUnionOfBots.DigiUnion;

import com.DigiUnionOfBots.DigiUnion.DiscordBot.RunBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigiUnionApplication {

@Autowired
private RunBot runBot;
public static void main(String[] args) {
		SpringApplication.run(RunBot.class, args);
	}


}