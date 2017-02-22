package com.github.ricardobaumann.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardobaumann on 10/10/16.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping(produces = "application/json")
public class InsecureApplication {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "insecure");

        SpringApplication.run(InsecureApplication.class, args);
    }

    @Autowired
    private Environment environment;

    @RequestMapping(method = RequestMethod.GET)
    public Something get() {
        Something something = new Something();
        something.setText(environment.getProperty("test"));
        return something;
    }

}
