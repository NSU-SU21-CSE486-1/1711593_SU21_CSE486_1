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
import com.fahemaSultana.project02.databinding.FragmentSetPhoneNumberBinding;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.UserProfileViewModel;
import com.fahemaSultana.project02.utils.Utils;

import java.util.List;

public class EditPhoneNumberFragment extends DialogFragment {

    SharedPreferences sharedPreferences;
    private FragmentSetPhoneNumberBinding binding;
    private UserProfileViewModel userProfileViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences("phoneNumber", Context.MODE_PRIVATE);

        binding.buttonForSetPhonenumber.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            PhoneNumbers object = new PhoneNumbers();
            object.setTag(binding.labelSpinner.getSelectedItem().toString().trim());
            object.setPhonenumber(binding.phoneNumber.getText().toString().trim());

            List<PhoneNumbers> list = Utils.jsonToObjectList(sharedPreferences.getString("phone_number_list", null), PhoneNumbers[].class);

            if (!list.contains(object)) {
                list.add(object);
                editor.putString("phone_number_list", Utils.objectToJson(list));
                editor.apply();

                userProfileViewModel.editPhoneNumberUpdatedCallback.setValue(true);
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