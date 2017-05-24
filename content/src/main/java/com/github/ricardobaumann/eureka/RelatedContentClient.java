package com.github.ricardobaumann.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ricardobaumann on 5/24/17.
 */
@FeignClient("relatedcontent")
public interface RelatedContentClient {

    @RequestMapping(
            path = "content/{contentName}/related",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RelatedContent get(@PathVariable("contentName") String contentName);

}
