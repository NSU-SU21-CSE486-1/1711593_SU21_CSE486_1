package com.fahemaSultana.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Student_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name_sign = bundle.getString("Name");
            String email_sign = bundle.getString("Email");
            String Password = bundle.getString("Password");

            TextView showName =  findViewById(R.id.show_profile_name);
            TextView showEmail = findViewById(R.id.show_profile_email);
            TextView showPassword =findViewById(R.id.show_password);

            showName.setText(name_sign);
            showEmail.setText(email_sign);
            showPassword.setText(Password);
        }
    }


}