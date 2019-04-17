package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    EditText userName,userPassword;
    TextView invalidTextView;
    Button userSubmitButton;
    Context context;

    //hardcoded username/password for verification purposes



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        context = this;
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);
        invalidTextView = findViewById(R.id.invalid_login);
        userSubmitButton = findViewById(R.id.button_user_submit);
        userSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameInput = userName.getText().toString();
                userNameInput = userNameInput.toLowerCase();
                String userPasswordInput = userPassword.getText().toString();
                if(userNameInput.equals(getResources().getString(R.string.hard_coded_username)) && userPasswordInput.equals(getResources().getString(R.string.hard_coded_password))){
                    //TODO: get info from database and send to profilePage to populate.
                    final Intent successfulLogin = new Intent(context, ProfilePage.class);
                    startActivity(successfulLogin);
                }else{
                    invalidTextView.setVisibility(View.VISIBLE);
                    //temp code to speed login

                }



            }
        });

    }
}
