package com.qsh.learning.springRestJpa.core.config;

import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public String userId;

    @Bean
    public CurrentCarIdHolder currentCarIdHolder() {
        CurrentCarIdHolder currentCarIdHolder = new CurrentCarIdHolder();
        currentCarIdHolder.setId(this.userId);
        return currentCarIdHolder;
    }
}
