package com.fahemaSultana.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);
        Intent profileinfo = getIntent();
        String name_sign = profileinfo.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String email_sign = profileinfo.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String Password = profileinfo.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView showName = findViewById(R.id.show_profile_name);
        TextView showEmail = findViewById(R.id.show_profile_email);
        TextView showPassword = findViewById(R.id.show_password);
        showName.setText(name_sign);
        showEmail.setText(email_sign);
        showPassword.setText(Password);
    }


}