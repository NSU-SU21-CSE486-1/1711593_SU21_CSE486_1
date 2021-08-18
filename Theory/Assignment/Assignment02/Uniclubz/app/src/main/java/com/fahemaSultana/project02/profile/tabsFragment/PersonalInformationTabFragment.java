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

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.project02.profile.editDialog.EditBasicInformationFragment;


public class PersonalInformationTabFragment extends Fragment {

    private FragmentPersonalInformationTabBinding binding;

    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_email = "Email_set";
    private static final String Key_nid = "Nid_set";
    private static final String Key_birthday = "Birthday_set";
    private static final String Key_blood = "Blood_group";
    private static final String Key_id = "ID_set";

    public PersonalInformationTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_information_tab, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String sName = sharedPreferences.getString(Key_name, null);
        String sEmail = sharedPreferences.getString(Key_email, null);
        String sNID = sharedPreferences.getString(Key_nid, null);
        String sBirthday = sharedPreferences.getString(Key_birthday, null);
        String sBlood = sharedPreferences.getString(Key_blood, null);
        String sID = sharedPreferences.getString(Key_id, null);

        if (sName != null || sEmail != null || sNID != null || sBirthday != null || sBlood != null || sID != null) {

            Bundle GetBasicData = this.getArguments();
           // String  Name = GetBasicData.getString("Name_set");
            //String Email= GetBasicData.getString("Email_set");
            //String NID = GetBasicData.getString("Nid_set");
            //String Birthday =GetBasicData.getString("Birthday_set");
            //String ID =GetBasicData.getString("ID_set");
            //String Blood=GetBasicData.getString("Blood_group");


            binding.showProfileName.setText(sName);
            binding.showProfileEmail.setText(sEmail);
            binding.showNid.setText(sNID);
            binding.showBirthdateSet.setText(sBirthday);
            binding.showBloodGroup.setText(sBlood);
            binding.showYourId.setText(sID);
        }


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


    }
}