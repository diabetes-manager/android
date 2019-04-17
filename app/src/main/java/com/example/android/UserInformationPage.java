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
    EditText userInformationWeight, userInformationHeight,userInformationTop,userInformationBottom;
    TextView userInformationAge,userInformationUsername,userInformationName;
    Context context;
    Button userInformationSaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_page);
        Intent prefillIntent = getIntent();
        String name = prefillIntent.getStringExtra("name");
//Handles made
        userInformationAge = findViewById(R.id.age_textview);
        userInformationWeight = findViewById(R.id.user_information_user_weight);
        userInformationHeight = findViewById(R.id.user_information_user_height);
        userInformationUsername = findViewById(R.id.user_information_page_username);
        userInformationName = findViewById(R.id.user_information_page_name);
        userInformationSaveButton = findViewById(R.id.user_information_save_button);
        userInformationTop = findViewById(R.id.target_high_edit_text);
        userInformationBottom = findViewById(R.id.target_low_edit_text);
//prefill data from other classes
        context = this;
        userInformationWeight.setText(String.valueOf(User.DEFAULT_USER_WEIGHT));
        userInformationHeight.setText(String.valueOf(User.DEFAULT_USER_HEIGHT));
        userInformationTop.setText(String.valueOf(ProfilePage.TARGET_HIGH));
        userInformationBottom.setText(String.valueOf(ProfilePage.TARGET_LOW));
        userInformationName.setText(name);
//using save button to pull any edits and apply where needed
        userInformationSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.DEFAULT_USER_WEIGHT = Integer.parseInt(userInformationWeight.getText().toString());
                User.DEFAULT_USER_HEIGHT = Integer.parseInt(userInformationHeight.getText().toString());
                ProfilePage.TARGET_HIGH = Integer.parseInt(userInformationTop.getText().toString());
                ProfilePage.TARGET_LOW = Integer.parseInt(userInformationBottom.getText().toString());
                Intent profilePage = new Intent(context,ProfilePage.class);
                startActivity(profilePage);

            }
        });



    }
}
