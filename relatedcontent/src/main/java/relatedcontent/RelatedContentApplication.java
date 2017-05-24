package relatedcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@RestController
public class RelatedContentApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "relatedcontent");
        SpringApplication.run(RelatedContentApplication.class,args);
    }

    @RequestMapping(
            path = "content/{contentName}/related",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RelatedContent get(@PathVariable String contentName) {
        return new RelatedContent(1L,String.format("Related content for %s",contentName));
    }

}
