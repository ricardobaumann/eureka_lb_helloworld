package comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ricardobaumann on 5/24/17.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@RestController
public class CommentApplication {

    private final Map<String,List<Comment>> map = new HashMap<>();

    public static void main (String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "comment");

        SpringApplication.run(CommentApplication.class, args);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    path = "/")
    public void post(@RequestBody Comment comment) {
        List<Comment> comments = map.getOrDefault(comment.getContentName(),new ArrayList<>());
        comments.add(comment);
        map.put(comment.getContentName(),comments);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            path = "{contentName}")
    public List<Comment> get(@PathVariable String contentName) {
        return map.get(contentName);
    }

}
