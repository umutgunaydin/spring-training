package com.company.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {

    @Bean
    public String myString(){
        return "Google";
    }

    @Bean
    public Integer myInteger(){
        return 5;
    }
}
