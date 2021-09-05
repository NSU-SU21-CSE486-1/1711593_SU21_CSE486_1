package com.fahemaSultana.project02.profile.editDialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetUniversityAffiliationBinding;
import com.fahemaSultana.project02.profile.DataModel.Universities;
import com.fahemaSultana.project02.profile.UserProfileViewModel;
import com.fahemaSultana.project02.utils.Utils;

import java.util.List;


public class EditUniversityAffliationFragment extends DialogFragment {

    SharedPreferences sharedPreferences;
    private UserProfileViewModel userProfileViewModel;
    private FragmentSetUniversityAffiliationBinding binding;

    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences("Universities", Context.MODE_PRIVATE);

        binding.submit.setOnClickListener(v -> {

            Toast.makeText(getContext(), "University added", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = sharedPreferences.edit();

            Universities object = new Universities();

            object.setUniversity(binding.enterYourUniversitynameSet.getSelectedItem().toString().trim());
            object.setDepartment(binding.departementSettings.getSelectedItem().toString().trim());
            object.setStudyLevel(binding.studyLevelSettings.getSelectedItem().toString().trim());

            List<Universities> universities = Utils.jsonToObjectList(sharedPreferences.getString("university_list", null), Universities[].class);

            if (!universities.contains(object)) {
                universities.add(object);
                editor.putString("university_list", Utils.objectToJson(universities));
                editor.apply();

                userProfileViewModel.editUniversityUpdatedCallback.setValue(true);
                dismiss();
            } else {
                Toast.makeText(getContext(), "This university already exits", Toast.LENGTH_SHORT).show();
            }

        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_university_affiliation, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

}