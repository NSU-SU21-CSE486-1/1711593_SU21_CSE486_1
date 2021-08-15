package com.fahemaSultana.project02.profile.editDialog;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetBasicinformationBinding;

public class EditBasicInformationFragment extends DialogFragment {

    private FragmentSetBasicinformationBinding binding;

    public EditBasicInformationFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_basicinformation, container, false);
        return binding.getRoot();
    }

    public void saveProfile(View view) {
        String Name_settings = binding.enterYourNameSet.getText().toString().trim();
        String Nid_settings = binding.enterYourNidSet.getText().toString().trim();
        String birthday_settings = binding.enterYourBirthdateSet.getText().toString().trim();
        String ID_settings = binding.enterYourIdSet.getText().toString().trim();
        String blood_group_settings = binding.bloodgroupSetting.getSelectedItem().toString().trim();

        //Bundle bundleforsettings = new Bundle();
        //bundleforsettings.putString("Name_set", Name_settings);
        //bundleforsettings.putString("Nid_set", Nid_settings);
        //bundleforsettings.putString("Birthday_set", birthday_settings);
        //bundleforsettings.putString("ID_set", ID_settings);
        //bundleforsettings.putString("Blood_group", blood_group_settings);
    }
}