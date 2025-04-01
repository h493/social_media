package com.social.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaApplication.class, args);
	}

//	@Bean // We can initalize here also or can use @Configuration -> separate class and create bean there
//	public CommandLineRunner initializeData(){
//		return (args -> {
//			SocialUser user1 = new SocialUser("User1");
//		});
//	}
}
