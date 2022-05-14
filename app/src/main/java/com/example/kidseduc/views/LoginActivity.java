package com.example.kidseduc.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kidseduc.R;
import com.example.kidseduc.controllers.UserController;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        loginListener();
    }

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    /**
     * Ecoute évènement sur le boutton login
     */
    private void loginListener(){
        ( (Button) findViewById(R.id.login)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                // récupération des données saisies
                String user = "";
                String mdp = "";
                try{
                    user = username.getText().toString();
                    mdp = password.getText().toString();
                }catch (Exception ex){
                    Toast.makeText(LoginActivity.this, "**************"+ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                if(user.equals("") || mdp.equals("")){
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                }
            }
        });
    }

}