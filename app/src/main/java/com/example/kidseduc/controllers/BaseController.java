package com.example.kidseduc.controllers;

import android.content.Context;

public class BaseController {
    private Context context;

    public Context getContext(){
        return context;
    }

    public void setContext(Context c){
        context = c;
    }
}
