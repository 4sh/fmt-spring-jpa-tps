package com.qsh.learning.springRestJpa.core.config;

import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean
    @SessionScope
    public CurrentCarIdHolder currentCarIdHolderForUser() {
        CurrentCarIdHolder currentCarIdHolder = new CurrentCarIdHolder();
        currentCarIdHolder.setId("USER");
        return currentCarIdHolder;
    }
}
