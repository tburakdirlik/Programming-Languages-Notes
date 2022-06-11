package com.JWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtApplication.class, args);
    }
}
/**
 POST request --> localhost:8080/login

 raw-json -->
                 {
                 "username" : "burak",
                 "password" : "123"
                 }

 tokenı üretir

 GET request bearer token --> localhost:8080/message

 tokenı kullanır.
 */
