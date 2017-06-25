package com.travix.medusa.busyflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.BufferingClientHttpRequestFactory;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.travix.medusa"})
public class BusyFlightsApplication {

     public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
        
     @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        return restTemplate;
    }
}
