package com.fahemaSultana.project02.profile.editDialog;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetUniversityAffiliationBinding;


public class EditUniversityAffliationFragment extends DialogFragment {



    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }
    private ViewDataBinding binding ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_university__affiliation , container , false);
        return binding.getRoot();
    }
}