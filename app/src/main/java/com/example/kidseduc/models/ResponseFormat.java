package com.example.kidseduc.models;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponseFormat <T extends BaseModal>{
    private int code;
    private T data;
    private List<T> listData;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void fromJson( JSONObject jsonObject, Type typeOfT) throws JsonParseException, JSONException {
        Gson gson = new Gson();
        setCode(jsonObject.getInt("code"));
        setMessage(jsonObject.getString("message"));
        setData( gson.fromJson(jsonObject.get("data").toString(), typeOfT ));
    }

    public void listFromJson(JSONObject jsonObject, Type typeOfT)throws JsonParseException, JSONException{
        Gson gson = new Gson();
        gson.toJson(listData, typeOfT);
        setCode(jsonObject.getInt("code"));
        setMessage(jsonObject.getString("message"));
        listData = gson.fromJson(jsonObject.get("data").toString(), typeOfT );
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }

    public boolean ok(){
        return code < 300 && code >= 200;
    }

}
