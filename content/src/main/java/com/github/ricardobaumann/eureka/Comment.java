package com.github.ricardobaumann.eureka;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ricardobaumann on 5/24/17.
 */
public class Comment {

    private String username;

    private String comment;

    private String contentName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonIgnore
    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }
}
