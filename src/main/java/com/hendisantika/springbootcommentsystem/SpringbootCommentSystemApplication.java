package com.hendisantika.springbootcommentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootCommentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCommentSystemApplication.class, args);
    }

}
