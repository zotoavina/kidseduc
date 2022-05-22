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

import com.example.kidseduc.NavbarActivity;
import com.example.kidseduc.R;
import com.example.kidseduc.controllers.UserController;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;
    private UserController userController;
    private TextView registerRedirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        loginListener();
        registerListener();
    }

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        registerRedirection = (TextView) findViewById(R.id.register_redirection);
        userController = UserController.getUserController();
        userController.setContext(this);
    }

    /**
     * Ecoute évènement sur le boutton login
     */
    private void loginListener(){
        loginButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                // récupération des données saisies
                String user = "";
                String mdp = "";
                try{
                    user = username.getText().toString();
                    mdp = password.getText().toString();
                    System.out.println("******************************"+user);
                    if(user.equals("") || mdp.equals("")){
                        Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    userController.withCredentials(user, mdp);
                    userController.login();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    Toast.makeText(LoginActivity.this, "**************"+ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void moveToMenu(){
        startActivity(new Intent(LoginActivity.this, NavbarActivity.class));
    }

    private void registerListener(){
        registerRedirection.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void toastInformation(){
        Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
    }

}