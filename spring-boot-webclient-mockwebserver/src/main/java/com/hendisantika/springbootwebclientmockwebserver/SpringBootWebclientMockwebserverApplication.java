package com.hendisantika.springbootwebclientmockwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootWebclientMockwebserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebclientMockwebserverApplication.class, args);
    }

}
