package com.nebula.collection.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class NebulaCollectionApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(NebulaCollectionApiApplication.class, args);
    }
}
