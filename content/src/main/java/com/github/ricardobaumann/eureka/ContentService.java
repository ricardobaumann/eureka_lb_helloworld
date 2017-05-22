package com.github.ricardobaumann.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ricardobaumann on 5/22/17.
 */
@Service
public class ContentService {

    @Autowired
    private InsecureClient insecureClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public Something get() {
        System.out.println("Getting from insecure");
        return insecureClient.get();
    }

    public Something fallback(Throwable throwable) {
        System.out.println("Getting from fallback");
        throwable.printStackTrace();
        return new Something();
    }

}
