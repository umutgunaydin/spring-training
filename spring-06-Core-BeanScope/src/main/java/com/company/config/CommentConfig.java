package com.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.company.proxy","com.company.service","com.company.repository"})
public class CommentConfig {

}
