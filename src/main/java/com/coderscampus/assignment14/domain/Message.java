package com.coderscampus.assignment14.domain;

import jakarta.persistence.*;


public class Message {

    Long id;
    String content;
    Channel channel;
    String username;

    public Message(Long id, String content, Channel channel, String username) {
        this.id = id;
        this.content = content;
        this.channel = channel;
        this.username = username;
    }

    public Message() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
