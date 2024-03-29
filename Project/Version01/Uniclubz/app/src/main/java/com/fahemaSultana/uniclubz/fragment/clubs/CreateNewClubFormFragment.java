package com.fahemaSultana.uniclubz.fragment.clubs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentCreateNewClubFormBinding;


public class CreateNewClubFormFragment extends Fragment {

    FragmentCreateNewClubFormBinding newClubFormBinding ;

    public CreateNewClubFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       newClubFormBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_new_club_form, container, false);

        return newClubFormBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}