package com.example.articles;

import com.example.articles.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.articles")
@EnableJpaRepositories("com.example.articles.repository")
@Import(ApplicationConfiguration.class)
public class ArticlesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlesApplication.class, args);
    }
}
