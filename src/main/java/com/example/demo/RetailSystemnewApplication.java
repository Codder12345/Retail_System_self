package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;






@SpringBootApplication

public class RetailSystemnewApplication {

	public static void main(String[] args) {
	
		ApplicationContext contex= SpringApplication.run(RetailSystemnewApplication.class, args);
  
		  JdbcTemplate conn=(JdbcTemplate)contex.getBean("jdbcTemplate");
			 if(conn!=null)
			 {
				 System.out.println(" Database connected");
			 }
			 else {
				 System.out.println("Database is not connected");
			 }
	 
	}

		

}
