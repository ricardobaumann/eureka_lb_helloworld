package com.github.ricardobaumann.eureka.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by ricardobaumann on 10/10/16.
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "registration-server");

        SpringApplication.run(RegistrationServer.class, args);
    }
}

/*
Manually register an instance
POST /eureka/apps/tester

<?xml version="1.0" encoding="utf-8"?>
<instance>
  <hostName>ricardos-mbp.asv.local</hostName>
  <app>tester</app>
  <ipAddr>10.10.75.13</ipAddr>
  <vipAddress>tester</vipAddress>
  <secureVipAddress>tester</secureVipAddress>
  <status>UP</status>
  <port enavbled="true">1234</port>
  <securePort enabled="false">443</securePort>
  <homePageUrl>http://ricardos-mbp.asv.local:1234</homePageUrl>
  <statusPageUrl>http://ricardos-mbp.asv.local:4444/info</statusPageUrl>
  <healthCheckUrl>http://ricardos-mbp.asv.local:4444/health</healthCheckUrl>
  <dataCenterInfo class="com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo">
	<name>MyOwn</name>
	</dataCenterInfo>
  <leaseInfo>
    <evictionDurationInSecs>745</evictionDurationInSecs>
  </leaseInfo>
  <metadata />
</instance>

Manually unregister it

DELETE /eureka/apps/TESTER/ricardos-mbp.asv.local
 */
