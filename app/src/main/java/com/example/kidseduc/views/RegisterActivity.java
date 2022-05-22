package com.example.kidseduc.views;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private RadioButton boy;
    private RadioButton girl;
    private RadioGroup genre;
    private TextView loginRedirection;
    private UserController userController;
    private int profil_gender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        genderListener();
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
        boy = (RadioButton) findViewById(R.id.boy);
        girl = (RadioButton) findViewById(R.id.girl);
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
                try{
                    checkInput();
                    userController.register(getString(R.string.app_api)+ getString(R.string.app_api_register));
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

    private void genderListener(){
        genre = (RadioGroup) findViewById(R.id.genre);
        genre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = genre.findViewById(checkedId);
                profil_gender = genre.indexOfChild(radioButton);
            }
        });
    }

    private void checkInput(){
        String name = username.getText().toString();
        String mdp = password.getText().toString();
        String eml = email.getText().toString();
        int ag = 0;
        if(name.equals("") || mdp.equals("") || eml.equals("")){
            Toast.makeText(RegisterActivity.this, "Incorrect information", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            ag = Integer.parseInt(age.getText().toString());
        }catch (Exception e){
            Toast.makeText(RegisterActivity.this, "Incorrect information", Toast.LENGTH_SHORT).show();
        }
        userController.setForRegister(name, mdp, ag, eml,profil_gender);
    }

    public void toastInformation(){
        Toast.makeText(RegisterActivity.this, "An error occured during the registration", Toast.LENGTH_SHORT).show();
    }


}