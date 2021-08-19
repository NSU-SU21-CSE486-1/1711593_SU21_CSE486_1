package com.fahemasultana.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import javax.security.auth.Destroyable;

public class HeadSetReceiever extends BroadcastReceiver {
    String toastmsg = "conected";
    private Object Tag;
    private String TAG = "HeadSet";
    private String toastMessage;

    public HeadSetReceiever() {
        Log.d(TAG, "Created");

    }


    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {

            switch (intentAction) {
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage = "HeadSet connected!";
                    break;
                default:
                    toastMessage = "HeadSet not Connected";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }



}

