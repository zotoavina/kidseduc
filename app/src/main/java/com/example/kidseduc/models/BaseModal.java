package com.example.kidseduc.models;

import java.io.Serializable;

public abstract class BaseModal implements Serializable {
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
