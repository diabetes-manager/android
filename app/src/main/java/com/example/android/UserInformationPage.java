package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserInformationPage extends AppCompatActivity {
    EditText userInformationWeight, userInformationHeight;
    TextView userInformationAge,userInformationUsername,userInformationName;
    Context context;
    Button userInformationSaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_page);
        userInformationAge = findViewById(R.id.age_textview);
        userInformationWeight = findViewById(R.id.user_information_user_weight);
        userInformationHeight = findViewById(R.id.user_information_user_height);
        userInformationUsername = findViewById(R.id.user_information_page_username);
        userInformationName = findViewById(R.id.user_information_page_name);
        userInformationSaveButton = findViewById(R.id.user_information_save_button);
        context = this;
        userInformationWeight.setText(User.DEFAULT_USER_WEIGHT);
        userInformationHeight.setText(User.DEFAULT_USER_HEIGHT);


    }
}
