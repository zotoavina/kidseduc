package com.example.kidseduc.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kidseduc.NavbarActivity;
import com.example.kidseduc.R;
import com.example.kidseduc.controllers.UserController;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private EditText age;
    private TextView loginRedirection;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        registerListener();
        loginListener();

    }

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        username = (EditText) findViewById(R.id.reg_username);
        password = (EditText) findViewById(R.id.reg_passsword);
        email = (EditText) findViewById(R.id.reg_email);
        age = (EditText) findViewById(R.id.reg_age);
        loginRedirection = (TextView) findViewById(R.id.login_redirection);
        userController = UserController.getUserController();
        userController.setContext(this);
    }


    /**
     * Ecoute évènement sur le boutton register
     */
    private void registerListener(){
        ( (Button) findViewById(R.id.register)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                // récupération des données saisies
                String name = "";
                String mdp = "";
                String eml = "";
                int ag = 0;
                try{
                    name = username.getText().toString();
                    mdp = password.getText().toString();
                    eml = email.getText().toString();
                    ag = Integer.parseInt(age.getText().toString());
                    userController.setForRegister(name, mdp, ag, eml);
                    userController.register();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    Toast.makeText(RegisterActivity.this, "**************"+ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void moveToMenu(){
        startActivity(new Intent(RegisterActivity.this, NavbarActivity.class));
    }

    private void loginListener(){
        loginRedirection.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}