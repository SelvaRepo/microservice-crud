package com.microservice.app;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.microservice.entity*")
@EnableJpaRepositories(basePackages = "com.microservice.repository*")
@ComponentScan(basePackages = "com.microservice.*")
@Log4j2
public class MicroserviceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("Hey starts main app..");
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MicroserviceApplication.class);
    }

}
