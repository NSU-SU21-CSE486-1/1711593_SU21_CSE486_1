package com.fahemaSultana.project02.profile.tabsFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.project02.profile.UserProfileViewModel;
import com.fahemaSultana.project02.profile.editDialog.EditBasicInformationFragment;


public class PersonalInformationTabFragment extends Fragment {

    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_email = "Email_set";
    private static final String Key_nid = "Nid_set";
    private static final String Key_birthday = "Birthday_set";
    private static final String Key_blood = "Blood_group";
    private static final String Key_id = "ID_set";
    SharedPreferences sharedPreferences;
    private FragmentPersonalInformationTabBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public PersonalInformationTabFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_information_tab, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.floatingActionButtonforPersonalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditBasicInformationFragment fragment = new EditBasicInformationFragment();
                // fragment.setArguments(bundle);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                fragment.show(getParentFragmentManager(), "Editbasic");
            }
        });

        userProfileViewModel.editInfoUpdatedCallback.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    updateInputFields();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateInputFields();
    }

    private void updateInputFields() {
        sharedPreferences = getContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String sName = sharedPreferences.getString(Key_name, null);
        String sEmail = sharedPreferences.getString(Key_email, null);
        String sNID = sharedPreferences.getString(Key_nid, null);
        String sBirthday = sharedPreferences.getString(Key_birthday, null);
        String sBlood = sharedPreferences.getString(Key_blood, null);
        String sID = sharedPreferences.getString(Key_id, null);

        if (sName != null || sEmail != null || sNID != null || sBirthday != null || sBlood != null || sID != null) {
            binding.showProfileName.setText(sName);
            binding.showProfileEmail.setText(sEmail);
            binding.showNid.setText(sNID);
            binding.showBirthdateSet.setText(sBirthday);
            binding.showBloodGroup.setText(sBlood);
            binding.showYourId.setText(sID);
        }
    }


}