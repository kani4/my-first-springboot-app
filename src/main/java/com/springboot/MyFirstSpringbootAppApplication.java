package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springboot")
public class MyFirstSpringbootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringbootAppApplication.class, args);
    }

}
