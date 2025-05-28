package com.coderscampus.assignment14.domain;

public class Channel {

    Long id;
    String name;

    public Channel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Channel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
