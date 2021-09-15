package com.fahemaSultana.uniclubz.fragment.profile.editDialog;

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

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentSetUniversityAffiliationBinding;
import com.fahemaSultana.uniclubz.dataModel.Universities;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.fragment.profile.UserProfileViewModel;

import java.util.ArrayList;
import java.util.List;


public class EditUniversityAffliationFragment extends DialogFragment {

    private UserProfileViewModel userProfileViewModel;
    private FragmentSetUniversityAffiliationBinding binding;

    public EditUniversityAffliationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.submit.setOnClickListener(v -> {

            UserEntity userEntity = userProfileViewModel.userEntityLiveData.getValue();
            if (userEntity == null)
                userEntity = new UserEntity();

            Universities object = new Universities();

            object.setUniversity(binding.enterYourUniversitynameSet.getSelectedItem().toString().trim());
            object.setDepartment(binding.departementSettings.getSelectedItem().toString().trim());
            object.setStudyLevel(binding.studyLevelSettings.getSelectedItem().toString().trim());

            List<Universities> list;
            if (userEntity.getUniversities() != null)
                list = userEntity.getUniversities();
            else
                list = new ArrayList<>();

            if (!list.contains(object)) {
                list.add(object);

                userEntity.setUniversities(list);

                userProfileViewModel.userEntityLiveData.setValue(userEntity);

                Toast.makeText(getContext(), "University added", Toast.LENGTH_SHORT).show();
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