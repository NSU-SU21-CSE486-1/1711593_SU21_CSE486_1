package com.example.fahema_twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.fahema_twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        Intent secondintent = getIntent();
        String message2 = secondintent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView2 = findViewById(R.id.text_message2);
        textView.setText(message2);

        Intent thirdintent = getIntent();
        String message3 = thirdintent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView3 = findViewById(R.id.text_message3);
        textView.setText(message3);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();

    }
}