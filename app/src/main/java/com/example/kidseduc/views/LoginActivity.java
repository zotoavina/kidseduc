package com.example.kidseduc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.kidseduc.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
}