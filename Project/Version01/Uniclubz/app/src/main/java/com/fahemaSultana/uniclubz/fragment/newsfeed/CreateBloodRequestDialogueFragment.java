package com.fahemaSultana.uniclubz.fragment.newsfeed;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentCreateBloodRequestBinding;


public class CreateBloodRequestDialogueFragment extends Fragment {

    FragmentCreateBloodRequestBinding createBloodRequestBinding;



    public CreateBloodRequestDialogueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       createBloodRequestBinding =  DataBindingUtil.inflate(inflater,R.layout.fragment_create_blood_request, container, false);
        return createBloodRequestBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}