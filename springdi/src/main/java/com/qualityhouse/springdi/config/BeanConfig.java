package com.qualityhouse.springdi.config;

import com.qualityhouse.springdi.beans.Planet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public Planet planet() {
        return new Planet();
    }
}
