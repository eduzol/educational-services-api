package com.github.eduzol;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.eduzol.*")
@EnableJSONDoc
public class WebApp  extends SpringBootServletInitializer {

	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(WebApp.class);
	}
	 
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(WebApp.class, args);

	}

}
