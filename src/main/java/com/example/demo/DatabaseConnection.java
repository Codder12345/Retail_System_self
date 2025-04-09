package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConnection {


    @Bean(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate(DataSource datasource) {
	        return new JdbcTemplate(datasource);
	    }

}
