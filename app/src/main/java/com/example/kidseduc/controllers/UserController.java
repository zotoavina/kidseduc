package com.example.kidseduc.controllers;

import android.content.Intent;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kidseduc.R;
import com.example.kidseduc.models.ResponseFormat;
import com.example.kidseduc.models.User;
import com.example.kidseduc.views.LoginActivity;
import com.example.kidseduc.views.MenuActivity;
import com.example.kidseduc.views.RegisterActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public  class UserController extends BaseController{
    private static  UserController userController = new UserController();
    private User user = new User();
    private RequestQueue requestQueue;

    public static UserController getUserController(){
        return userController;
    }

    private UserController(){

    }

    public void setUser(User user){
        this.user = user;
    }

    public void withCredentials(String userName, String pass){
        user.setUsername(userName);
        user.setPassword(pass);
    }

    public void setForRegister(String username, String pass, int age, String email, int gender){
        user.setPassword(pass);
        user.setUsername(username);
        user.setAge(age);
        user.setEmail(email);
        user.setGender(gender);
    }

    public String
    login(String url)throws Exception{
        JSONObject parameter = new JSONObject();
        parameter.put("password", user.getPassword());
        parameter.put("username", user.getUsername());
        System.out.println(parameter.toString());
        String mRequestBody = parameter.toString();
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, null,
            response -> {
                System.out.println("#################   "+response.toString());
                try {
                    System.out.println("#################   "+response.get("data").toString());
                    ResponseFormat<User> responseFormat =new  ResponseFormat<>();
                    responseFormat.fromJson(response, User.class);
                    if(responseFormat.ok()){
                        setUser( responseFormat.getData() );
                        ((LoginActivity)getContext()).moveToMenu();
                    }
                    else ((LoginActivity)getContext()).toastInformation();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("******************" + error.toString());
            }
        }){
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody(){
                try {
                    Log.d("0000000000" , mRequestBody);
                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                    return null;
                }
            }

//            @Override
//            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
//                String responseString = "";
//                Log.d("http response",  response.toString());
//                if (response != null) {
//                    responseString = String.valueOf(response.statusCode);
//                }
//                return Response.success(new JSONObject(), HttpHeaderParser.parseCacheHeaders(response));
//            }
        };

        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        return null;
    }


    public String register(String url)throws Exception{
        JSONObject parameter = new JSONObject();
        parameter.put("password", user.getPassword());
        parameter.put("username", user.getUsername());
        parameter.put("age", user.getAge());
        parameter.put("email", user.getEmail());
        parameter.put("gender", user.getGender());
        String requestBody = parameter.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
                response ->  {
                    ResponseFormat<User> responseFormat =new  ResponseFormat<>();
                    try {
                        System.out.println("#################   "+response.get("data").toString());
                        responseFormat.fromJson(response, User.class);
                        if(responseFormat.ok()){
                            setUser( responseFormat.getData() );
                            ((RegisterActivity)getContext()).moveToMenu();
                        }
                        else ((RegisterActivity)getContext()).toastInformation();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    System.out.println("register response ********* " + error.toString());
                }){
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody(){
                try {
                    Log.d("0000000000" , requestBody);
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
        return null;
    }


    public String getName(){
        return user.getUsername();
    }

    public String getEmail(){
        return user.getEmail();
    }

    public int getAge(){
        return user.getAge();
    }

    public int getGender(){
        return user.getGender();
    }


}
