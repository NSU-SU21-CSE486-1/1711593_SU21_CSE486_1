package com.fahemaSultana.project02.profile.editDialog;

import android.content.Context;
import android.content.SharedPreferences;
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

    private ViewDataBinding binding ;
    private Spinner enter_university_name_settings;
    private Spinner enter_department_name_settings;
    private Spinner enter_study_level_settings;

    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "Universities";
    private static final String Key_universityname = "university_name";
    private static final String Key_departmentname = "department_name";
    private static final String Key_studylevel = "study_level";



    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentSetUniversityAffiliationBinding bindingforsetuniversity = FragmentSetUniversityAffiliationBinding.inflate(getLayoutInflater());


        sharedPreferences = getContext().getSharedPreferences("Universities", Context.MODE_PRIVATE);

        String university_settings = bindingforsetuniversity.enterYourUniversitynameSet.getSelectedItem().toString().trim();
        String department_settings = bindingforsetuniversity.departementSettings.getSelectedItem().toString().trim();
        String study_level_settings = bindingforsetuniversity.studyLevelSettings.getSelectedItem().toString().trim();


        bindingforsetuniversity.buttonShowallUniversitiesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Key_universityname,bindingforsetuniversity.enterYourUniversitynameSet.getSelectedItem().toString().trim());
                editor.putString(Key_departmentname,bindingforsetuniversity.departementSettings.getSelectedItem().toString().trim());
                editor.putString(Key_studylevel,bindingforsetuniversity.studyLevelSettings.getSelectedItem().toString().trim());
                editor.apply();

                UniversitiesTabFragment SendDataUniversity = new UniversitiesTabFragment();
                Bundle ForUniversityBundle = new Bundle();
                ForUniversityBundle.putString("Key_universityname", university_settings);
                ForUniversityBundle.putString("Key_departmentname", department_settings);
                ForUniversityBundle.putString("Key_studylevel", study_level_settings);

                SendDataUniversity.setArguments(ForUniversityBundle);

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