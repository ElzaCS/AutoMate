package com.example.automate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    @Value("${db_user}")
    private String user;
    @Value("${pass}")
    private String pass;
    @Value("${db_url}")
    private String url;
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder= DataSourceBuilder.create();
        builder.url(url);
         builder.username(user);
        builder.password(pass);
        System.out.println("My custom datasource bean has been initialized and set");
        return builder.build();
    }

}
