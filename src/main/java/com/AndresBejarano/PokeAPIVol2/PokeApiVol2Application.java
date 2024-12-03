package com.AndresBejarano.PokeAPIVol2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PokeApiVol2Application {

	public static void main(String[] args) {
		SpringApplication.run(PokeApiVol2Application.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Hi there!";
	}

}
