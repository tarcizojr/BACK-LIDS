package br.edu.ifpb.lids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class LidsApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LidsApplication.class, args);
	}

}
