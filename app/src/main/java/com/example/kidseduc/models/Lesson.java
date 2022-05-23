package com.example.kidseduc.models;

import java.io.Serializable;

public class Lesson extends BaseModal implements Serializable {
    public String getTitle() {
        return title;
    }
    private String title;
    private String type;
    private String content;
    private String description;

    public Lesson(String title, String type, String content, String description) {
        this.title = title;
        this.type = type;
        this.content = content;
        this.description = description;
    }

    public Lesson(Object obj){

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

    public Boolean isPicture(){
        return this.type.compareToIgnoreCase("image") == 0;
    }

    public Boolean isVideo(){
        return this.type.compareToIgnoreCase("video") == 0;
    }

    public Boolean isWeb(){
        return this.type.compareToIgnoreCase("html") == 0;
    }
}
