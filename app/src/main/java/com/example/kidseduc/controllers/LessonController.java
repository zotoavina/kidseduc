package com.example.kidseduc.controllers;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kidseduc.models.Lesson;
import com.example.kidseduc.models.ResponseFormat;
import com.example.kidseduc.models.User;
import com.example.kidseduc.views.LessonListActivity;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LessonController extends BaseController{
    private static LessonController lessonController = new LessonController();
    private List<Lesson> lessons;
    private RequestQueue requestQueue;

    private LessonController(){}

    public static LessonController getLessonController(){
        return lessonController;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons(){
        return lessons;
    }

    public String getLessonList(String url)throws Exception{
        JsonObjectRequest lessonRequest = new JsonObjectRequest(Request.Method.GET, url , null,
                response -> {
                    System.out.println("############ " + response.toString());
                    try{
                        Type tp = new TypeToken<List<Lesson>>(){}.getType();
                        ResponseFormat<Lesson> responseFormat =new  ResponseFormat<>();
                        responseFormat.listFromJson(response,  tp);
                        if(responseFormat.ok()){
                            lessons = responseFormat.getListData();
                            Lesson l = lessons.get(0);
                            ( (LessonListActivity) this.getContext()).showList();
                        }
                        else
                            System.out.println("error");
                        int a = 0;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                },
                error -> {

                }){
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

//            @Override
//            public byte[] getBody(){
//                try {
//                    Log.d("0000000000" , mRequestBody);
//                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
//                } catch (UnsupportedEncodingException uee) {
//                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
//                    return null;
//                }
//            }
        };
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(lessonRequest);
        return null;
    }

}
