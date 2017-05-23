package com.github.ricardobaumann.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by ricardobaumann on 10/10/16.
 */
@RestController
@RequestMapping(value = "/content", consumes = "application/json", produces = "application/json")
public class ContentController {

    private final ContentService contentService;

    ContentController(final ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(method = RequestMethod.GET,path = "{name}")
    public Content getContent(@PathVariable String name) {
        return contentService.getContent(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Content post(@RequestBody  Content content, Principal principal) {


        //TODO post
        //content.setSomething(insecureClient.get());

        //System.out.print("Making a crazy request to content to get "+contentLookupClient.get().getText());

        //content.setUsername(principal.getName());
        return content;
    }


}
