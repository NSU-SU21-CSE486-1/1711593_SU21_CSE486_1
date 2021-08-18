package com.fahemaSultana.project02.profile.editDialog;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.fahemaSultana.project02.profile.UserProfileViewModel;

public class EditBasicInformationFragment extends DialogFragment {

    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_email = "Email_set";
    private static final String Key_nid = "Nid_set";
    private static final String Key_birthday = "Birthday_set";
    private static final String Key_blood = "Blood_group";
    private static final String Key_id = "ID_set";
    SharedPreferences sharedPreferences;
    private FragmentSetBasicinformationBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public EditBasicInformationFragment() {
        // Required empty public constructor

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences("basicinfo", Context.MODE_PRIVATE);

        binding.buttonForSaveBasicInfo.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Key_name, binding.enterYourNameSet.getText().toString().trim());
            editor.putString(Key_email, binding.enterYourEmailSet.getText().toString().trim());
            editor.putString(Key_nid, binding.enterYourNidSet.getText().toString().trim());
            editor.putString(Key_birthday, binding.enterYourBirthdateSet.getText().toString().trim());
            editor.putString(Key_id, binding.enterYourIdSet.getText().toString().trim());
            editor.putString(Key_blood, binding.bloodgroupSetting.getSelectedItem().toString().trim());
            editor.apply();
            userProfileViewModel.editInfoUpdatedCallback.setValue(true);
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