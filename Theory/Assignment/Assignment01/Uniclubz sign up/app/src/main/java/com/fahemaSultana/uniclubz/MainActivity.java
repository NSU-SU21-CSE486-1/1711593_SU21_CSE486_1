package com.fahemaSultana.uniclubz;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.fahemaSultana.uniclubz";
    private EditText enter_name_Sign;
    private EditText enter_email_Sign;
    private EditText enter_password_Sign;
    private EditText enter_confirm_password_Sign;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_name_Sign = findViewById(R.id.enter_name_signup);
        enter_email_Sign = findViewById(R.id.enter_email_signup);
        enter_password_Sign = findViewById(R.id.enter_password_signup);
        enter_confirm_password_Sign = findViewById(R.id.enter_confirm_pass_signup);
    }

    public void profileinfo(View view) {
        Intent profile = new Intent(this, Student_Profile.class);
        String Name = enter_name_Sign.getText().toString();
        profile.putExtra(EXTRA_MESSAGE, Name);
        startActivity(profile);
    }
}