package com.huaxin.fim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"javax.persistence"})
public class FimApplication {

    public static void main(String[] args) {
        SpringApplication.run(FimApplication.class, args);
    }

}

