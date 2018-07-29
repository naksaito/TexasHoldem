package com.nak.texas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TexasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TexasApplication.class, args);
	}

	@RestController
	class GreetingController {

		@RequestMapping("/hello/{name}")
		String hello(@PathVariable String name) {
			return "Hello, " + name + "!";
		}
	}
}
