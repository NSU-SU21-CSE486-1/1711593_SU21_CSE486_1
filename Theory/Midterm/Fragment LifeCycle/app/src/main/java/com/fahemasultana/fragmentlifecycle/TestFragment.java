package com.fahemasultana.fragmentlifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = TestFragment.class.getSimpleName();

    private static final String TAG = COMMON_TAG;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, FRAGMENT_NAME +" on Attach Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, FRAGMENT_NAME +" on Create Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" on Create View Fragment");
        return inflater.inflate(R.layout.fragment_test,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" on Activity Created Fragment");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, FRAGMENT_NAME +" on Start Fragment");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, FRAGMENT_NAME +" on Resume Fragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, FRAGMENT_NAME +" on Pause Fragment");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, FRAGMENT_NAME +" on Stop Fragment");
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        Log.i(TAG, FRAGMENT_NAME +" on Destroy View Fragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, FRAGMENT_NAME +" on Destroy Fragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, FRAGMENT_NAME +" on Detach Fragment");
        super.onDetach();
    }



}
