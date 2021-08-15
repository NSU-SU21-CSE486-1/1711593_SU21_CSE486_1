package com.fahemaSultana.project02.profile.editDialog;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.Student_Profile;
import com.fahemaSultana.project02.databinding.FragmentSetUniversityAffiliationBinding;
import com.fahemaSultana.project02.profilesettings;


public class EditUniversityAffliationFragment extends DialogFragment {



    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }
    private ViewDataBinding binding ;
    private FragmentSetUniversityAffiliationBinding bindingforsetuniversity;
    private Spinner enter_university_name_settings;
    private Spinner enter_department_name_settings;
    private Spinner enter_study_level_settings;


    //enter_university_name_settings =(Spinner)  (R.id.enter_your_universityname_set);
    //enter_department_name_settings = (Spinner) getView().findViewById(R.id.departement_settings);
    //enter_study_level_settings = (Spinner) getView().findViewById(R.id.study_level_settings);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_university__affiliation , container , false);
        return binding.getRoot();
    }

    public void Submituniversitylist (View view){

        String university_settings = bindingforsetuniversity.enterYourUniversitynameSet.getSelectedItem().toString().trim();
        String department_settings = bindingforsetuniversity.departementSettings.getSelectedItem().toString().trim();
        String study_level_settings = bindingforsetuniversity.studyLevelSettings.getSelectedItem().toString().trim();

        Bundle foruniversitybundle = new Bundle();
        foruniversitybundle.putString("University_set", university_settings);
        foruniversitybundle.putString("Department_set", department_settings);
        foruniversitybundle.putString("Study_level", study_level_settings);




    }


}