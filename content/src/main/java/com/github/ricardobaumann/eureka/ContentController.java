package com.github.ricardobaumann.eureka;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by ricardobaumann on 10/10/16.
 */
@RestController
@RequestMapping(value = "/content", consumes = "application/json", produces = "application/json")
public class ContentController {

    @RequestMapping(method = RequestMethod.GET)
    public Content getContent() {
        return new Content();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Content post(@RequestBody  Content content, Principal principal) {

        content.setUsername(principal.getName());
        return content;
    }

}
