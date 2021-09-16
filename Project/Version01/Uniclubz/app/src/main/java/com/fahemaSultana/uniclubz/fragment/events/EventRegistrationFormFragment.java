package com.fahemaSultana.uniclubz.fragment.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentEventRegistrationFormBinding;

public class EventRegistrationFormFragment extends Fragment {

    FragmentEventRegistrationFormBinding eventRegistrationFormBinding;



    public EventRegistrationFormFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       eventRegistrationFormBinding =  DataBindingUtil.inflate(inflater,R.layout.fragment_event_registration_form, container, false);
        return eventRegistrationFormBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}