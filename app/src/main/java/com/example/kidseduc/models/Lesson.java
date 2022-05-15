package com.example.kidseduc.models;

public class Lesson {
    private String title;
    private String description;
    private String type;
    private String content;

    public Lesson(String title, String description, String type, String content) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
