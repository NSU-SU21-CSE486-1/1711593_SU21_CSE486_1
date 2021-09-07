package com.fahemaSultana.project02.profile.editDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetBasicinformationBinding;
import com.fahemaSultana.project02.profile.DataModel.UserEntity;
import com.fahemaSultana.project02.profile.UserProfileViewModel;

public class EditBasicInformationFragment extends DialogFragment {

    private FragmentSetBasicinformationBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public EditBasicInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonForSaveBasicInfo.setOnClickListener(v -> {
            UserEntity userEntity = userProfileViewModel.userEntityLiveData.getValue();
            if (userEntity == null)
                userEntity = new UserEntity();
            userEntity.setName(binding.enterYourNameSet.getText().toString().trim());
            userEntity.setBirthdate(binding.enterYourBirthdateSet.getText().toString().trim());
            userEntity.setBloodGroup(binding.bloodgroupSetting.getSelectedItem().toString().trim());
            userEntity.setNid(binding.enterYourNidSet.getText().toString().trim());
            userProfileViewModel.userEntityLiveData.setValue(userEntity);
            dismiss();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_basicinformation, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

}