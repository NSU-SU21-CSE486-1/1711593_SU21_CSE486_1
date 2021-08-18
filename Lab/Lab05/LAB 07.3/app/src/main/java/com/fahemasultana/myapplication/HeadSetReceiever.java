package com.fahemasultana.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.widget.Toast.*;

public class HeadSetReceiever extends BroadcastReceiver {
    String toastmsg = "conected";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        throw new UnsupportedOperationException("Not yet implemented");


        if (intentAction != null) {
            Toast.makeText(context, toastmsg, LENGTH_SHORT).show();
        }
    }
}