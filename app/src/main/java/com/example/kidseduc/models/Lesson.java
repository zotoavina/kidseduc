package com.example.kidseduc.models;

public class Lesson {
    private String title;
    private String description;
    private int type;
    private String content;

    public Lesson(String title, String description, int type, String content) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
