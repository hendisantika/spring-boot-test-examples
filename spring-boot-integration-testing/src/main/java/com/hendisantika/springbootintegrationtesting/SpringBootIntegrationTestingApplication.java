package com.hendisantika.springbootintegrationtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootIntegrationTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationTestingApplication.class, args);
    }

}
