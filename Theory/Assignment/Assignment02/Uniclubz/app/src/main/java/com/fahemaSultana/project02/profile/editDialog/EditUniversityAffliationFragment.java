package com.fahemaSultana.project02.profile.editDialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetUniversityAffiliationBinding;
import com.fahemaSultana.project02.profile.tabsFragment.UniversitiesTabFragment;


public class EditUniversityAffliationFragment extends DialogFragment {



    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }
    private ViewDataBinding binding ;
    private FragmentSetUniversityAffiliationBinding bindingforsetuniversity;
    private Spinner enter_university_name_settings;
    private Spinner enter_department_name_settings;
    private Spinner enter_study_level_settings;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        bindingforsetuniversity.buttonShowallUniversitiesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // String university_settings = bindingforsetuniversity.enterYourUniversitynameSet.getSelectedItem().toString().trim();
                //String department_settings = bindingforsetuniversity.departementSettings.getSelectedItem().toString().trim();
                //String study_level_settings = bindingforsetuniversity.studyLevelSettings.getSelectedItem().toString().trim();

                //UniversitiesTabFragment EditDataUniver = new UniversitiesTabFragment();
                //Bundle ForUniversityBundle = new Bundle();
                //ForUniversityBundle.putString("University_set", university_settings);
                //ForUniversityBundle.putString("Department_set", department_settings);
                //ForUniversityBundle.putString("Study_level", study_level_settings);

            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_university__affiliation , container , false);
        return binding.getRoot();
    }




}