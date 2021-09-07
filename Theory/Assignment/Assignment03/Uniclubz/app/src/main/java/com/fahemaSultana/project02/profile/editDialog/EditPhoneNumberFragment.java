package com.fahemaSultana.project02.profile.editDialog;

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
import com.fahemaSultana.project02.databinding.FragmentSetPhoneNumberBinding;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.DataModel.UserEntity;
import com.fahemaSultana.project02.profile.UserProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class EditPhoneNumberFragment extends DialogFragment {

    private FragmentSetPhoneNumberBinding binding;
    private UserProfileViewModel userProfileViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonForSetPhonenumber.setOnClickListener(v -> {

            UserEntity userEntity = userProfileViewModel.userEntityLiveData.getValue();
            if (userEntity == null)
                userEntity = new UserEntity();

            PhoneNumbers object = new PhoneNumbers();
            object.setTag(binding.labelSpinner.getSelectedItem().toString().trim());
            object.setPhonenumber(binding.phoneNumber.getText().toString().trim());

            List<PhoneNumbers> list;
            if (userEntity.getPhoneNumbers() != null)
                list = userEntity.getPhoneNumbers();
            else
                list = new ArrayList<>();

            if (!list.contains(object)) {
                list.add(object);

                userEntity.setPhoneNumbers(list);

                userProfileViewModel.userEntityLiveData.setValue(userEntity);
                dismiss();
            } else {
                Toast.makeText(getContext(), "This phone number already exits", Toast.LENGTH_SHORT).show();
            }

        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_phone_number, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }


}