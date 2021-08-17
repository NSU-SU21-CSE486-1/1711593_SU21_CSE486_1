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

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetBasicinformationBinding;
import com.fahemaSultana.project02.profile.tabsFragment.PersonalInformationTabFragment;

public class EditBasicInformationFragment extends DialogFragment {

    private FragmentSetBasicinformationBinding binding;

    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_email = "Email_set";
    private static final String Key_nid = "Nid_set";
    private static final String Key_birthday = "Birthday_set";
    private static final String Key_blood = "Blood_group";
    private static final String Key_id = "ID_set";


    public EditBasicInformationFragment() {
        // Required empty public constructor

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences("basicinfo", Context.MODE_PRIVATE);

        String Name_settings = binding.enterYourNameSet.getText().toString().trim();
        String Email_setting = binding.enterYourEmailSet.getText().toString().trim();
        String Nid_settings = binding.enterYourNidSet.getText().toString().trim();
        String birthday_settings = binding.enterYourBirthdateSet.getText().toString().trim();
        String ID_settings = binding.enterYourIdSet.getText().toString().trim();
        String blood_group_settings = binding.bloodgroupSetting.getSelectedItem().toString().trim();


        binding.buttonForSaveBasicInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Key_name, binding.enterYourNameSet.getText().toString().trim());
                editor.putString(Key_email, binding.enterYourEmailSet.getText().toString().trim());
                editor.putString(Key_nid, binding.enterYourNidSet.getText().toString().trim());
                editor.putString(Key_birthday, binding.enterYourBirthdateSet.getText().toString().trim());
                editor.putString(Key_id, binding.enterYourIdSet.getText().toString().trim());
                editor.putString(Key_blood, binding.bloodgroupSetting.getSelectedItem().toString().trim());
                editor.apply();


                PersonalInformationTabFragment SendBasicInfo = new PersonalInformationTabFragment();
                Bundle BundleForBasicInfo = new Bundle();
                BundleForBasicInfo.putString("Name_set", Name_settings);
                BundleForBasicInfo.putString("Email_set", Email_setting);
                BundleForBasicInfo.putString("Nid_set", Nid_settings);
                BundleForBasicInfo.putString("Birthday_set", birthday_settings);
                BundleForBasicInfo.putString("ID_set", ID_settings);
                BundleForBasicInfo.putString("Blood_group", blood_group_settings);

                SendBasicInfo.setArguments(BundleForBasicInfo);

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_basicinformation, container, false);

        return binding.getRoot();
    }


}