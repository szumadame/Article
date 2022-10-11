package com.example.articles.configuration;

import com.example.articles.service.NytApiClient;
import org.springframework.context.annotation.Bean;
public class ApplicationConfiguration {

    @Bean
    public NytApiClient NytApiClient() {
        return new NytApiClient();
    }
}
