package com.fahemaSultana.uniclubz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.fahemaSultana.uniclubz";
    private EditText enter_name_Sign;
    private EditText enter_email_Sign;
    private EditText enter_password_Sign;
    private EditText enter_confirm_password_Sign;
    private EditText Sign_up_button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_name_Sign =(EditText) findViewById(R.id.enter_name_signup);
        enter_email_Sign = (EditText) findViewById(R.id.enter_email_signup);
        enter_password_Sign = (EditText) findViewById(R.id.enter_password_signup);
        enter_confirm_password_Sign = (EditText) findViewById(R.id.enter_confirm_pass_signup);

    }


    public void profile(View view) {
        Intent profileinfo = new Intent(MainActivity.this, Student_Profile.class);
        String Name = enter_name_Sign.getText().toString().trim();
        String Email = enter_email_Sign.getText().toString().trim();
        String Password = enter_password_Sign.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("Name", Name);
        bundle.putString("Email", Email);
        bundle.putString("Password", Password);

        profileinfo.putExtras(bundle);

        startActivity(profileinfo);
    }
}