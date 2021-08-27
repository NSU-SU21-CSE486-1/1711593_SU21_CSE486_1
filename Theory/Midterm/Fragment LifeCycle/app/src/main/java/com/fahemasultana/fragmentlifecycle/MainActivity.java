package com.fahemasultana.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    private static final String TAG = COMMON_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment();

        Log.e(TAG, ACTIVITY_NAME+" on Create Activity");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, ACTIVITY_NAME+" on Start Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, ACTIVITY_NAME+" on Resume Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, ACTIVITY_NAME+" on Pause Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, ACTIVITY_NAME+" on Stop Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, ACTIVITY_NAME+" on Destroy Activity");
    }

    private void addFragment(){
        Fragment fragment=new TestFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_test,fragment,"testFragment");
        fragmentTransaction.addToBackStack("fragmentStack1");
        fragmentTransaction.commit();
    }

}