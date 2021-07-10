package com.sparta.mungmung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MungmungServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MungmungServerApplication.class, args);
    }

}
