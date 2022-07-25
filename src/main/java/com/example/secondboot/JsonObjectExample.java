package com.example.secondboot;

public class JsonObjectExample {
    private final long id;
    private final String content;

    public JsonObjectExample(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }
}