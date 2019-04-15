package com.example.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class UserInformationPage extends AppCompatActivity {
    EditText userInformationWeight, userInformationAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_page);
        userInformationAge = findViewById(R.id.user_information_user_age);
        userInformationWeight = findViewById(R.id.user_information_user_weight);
    }
}
