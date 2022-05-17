package com.example.kidseduc.controllers;

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
import com.example.kidseduc.models.ResponseFormat;
import com.example.kidseduc.models.User;
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

    public void withCredentials(String userName, String pass){
        user.setUsername(userName);
        user.setPassword(pass);
    }

    public void setForRegister(String username, String pass, int age, String email){
        user.setPassword(pass);
        user.setUsername(username);
        user.setAge(age);
        user.setEmail(email);
    }

    public String login()throws Exception{
        String url = "http://10.0.2.2:8080/api/user/login";
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
                    Gson gson = new Gson();
                    ResponseFormat<User> responseFormat =new  ResponseFormat<>();
                    responseFormat.fromJson(response, User.class);
                    if(responseFormat.ok())
                        System.out.println("redirection menu");
                    else
                        System.out.println("error");
                    int a = 0;
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


    public String register()throws Exception{
        String url =  "http://10.0.2.2:8080/api/user/register";
        JSONObject parameter = new JSONObject();
        parameter.put("password", user.getPassword());
        parameter.put("username", user.getUsername());
        parameter.put("age", user.getAge());
        parameter.put("email", user.getEmail());
        String requestBody = parameter.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
                response ->  {
                    System.out.println("register response ********* " + response.toString());
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


}
