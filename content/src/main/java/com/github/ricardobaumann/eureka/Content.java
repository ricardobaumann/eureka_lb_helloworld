package com.github.ricardobaumann.eureka;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

/**
 * Created by ricardobaumann on 10/10/16.
 */

public class Content {

    private final RelatedContent relatedContent;
    private final List<Comment> comments;
    private JsonNode body;

    private String name;

    public Content(JsonNode body, String name, RelatedContent relatedContent, List<Comment> comments) {
        this.body = body;
        this.name = name;
        this.relatedContent = relatedContent;
        this.comments = comments;
    }

    public JsonNode getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public RelatedContent getRelatedContent() {
        return relatedContent;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
