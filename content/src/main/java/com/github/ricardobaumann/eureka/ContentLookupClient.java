package com.github.ricardobaumann.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ricardobaumann on 5/19/17.
 */
@FeignClient("content")
public interface ContentLookupClient {

    @RequestMapping(path = "/resource/content",method = RequestMethod.GET)
    public Content get();

}
