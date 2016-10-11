package com.github.ricardobaumann.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;

/**
 * Created by ricardobaumann on 10/10/16.
 *  curl -XPOST -k foo:foosecret@localhost:9000/hascode/oauth/token    -d grant_type=password -d client_id=foo -d client_secret=abc123    -d redirect_uri=http://www.hascode.com -d username=bar -d password=barsecret

 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableResourceServer
@EnableAuthorizationServer
public class Oauth2AuthorizationServerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "auth");
        SpringApplication.run(Oauth2AuthorizationServerApplication.class, args);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}