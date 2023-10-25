package com.qsh.learning.springRestJpa.core.config;

import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CurrentCarIdHolder currentCarIdHolder() {
        return new CurrentCarIdHolder();
    }
}
