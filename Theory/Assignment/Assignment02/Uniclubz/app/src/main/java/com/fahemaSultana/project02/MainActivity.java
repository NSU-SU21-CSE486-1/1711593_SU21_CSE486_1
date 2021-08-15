package com.fahemaSultana.project02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.fahemaSultana.uniclubz";
    private EditText enter_name_Sign;
    private EditText enter_email_Sign;
    private EditText enter_password_Sign;
    private EditText enter_confirm_password_Sign;
    private EditText Sign_up_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_name_Sign = (EditText) findViewById(R.id.enter_your_name_sign);
        enter_email_Sign = (EditText) findViewById(R.id.enter_your_email_sign);
        enter_password_Sign = (EditText) findViewById(R.id.enter_password_signup);
        enter_confirm_password_Sign = (EditText) findViewById(R.id.enter_confirm_pass_signup);

    }


    public void profile(View view) {
        Intent profileinfo = new Intent(MainActivity.this, profilesettings.class);
        String Name = enter_name_Sign.getText().toString().trim();
        String Email = enter_email_Sign.getText().toString().trim();
        //String Password = enter_password_Sign.getText().toString();

        Bundle bundleforsignup = new Bundle();
        bundleforsignup.putString("Name", Name);
        bundleforsignup.putString("Email", Email);
        // bundleforsignup.putString("Password", Password);

        profileinfo.putExtras(bundleforsignup);

        startActivity(profileinfo);
    }
}