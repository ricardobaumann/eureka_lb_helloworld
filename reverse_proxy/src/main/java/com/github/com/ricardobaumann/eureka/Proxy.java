package com.github.com.ricardobaumann.eureka;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardobaumann on 11/10/16.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableResourceServer
public class Proxy {

    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "proxy");

        new SpringApplicationBuilder(Proxy.class).web(true).run(args);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "hello";
    }
}
