package com.qsh.learning.springRestJpa.core.config;

import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean("adminHolder")
    @SessionScope
    public CurrentCarIdHolder currentCarIdHolderForAdmin() {
        CurrentCarIdHolder currentCarIdHolder = new CurrentCarIdHolder();
        currentCarIdHolder.setId("ADMIN");
        return currentCarIdHolder;
    }

    @Bean("userHolder")
    @SessionScope
    public CurrentCarIdHolder currentCarIdHolderForUser() {
        CurrentCarIdHolder currentCarIdHolder = new CurrentCarIdHolder();
        currentCarIdHolder.setId("USER");
        return currentCarIdHolder;
    }
}
