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
        String Name = sharedPreferences.getString(Key_name, null);
        String Email = sharedPreferences.getString(Key_email, null);
        String NID = sharedPreferences.getString(Key_nid, null);
        String Birthday = sharedPreferences.getString(Key_birthday, null);
        String Blood = sharedPreferences.getString(Key_blood, null);
        String ID = sharedPreferences.getString(Key_id, null);

        if (Name != null || Email != null || NID != null || Birthday != null || Blood != null || ID != null) {

            Bundle GetBasicData = getArguments();

            binding.showProfileName.setText(Name);
            binding.showProfileEmail.setText(Email);
            binding.showNid.setText(NID);
            binding.showBirthdateSet.setText(Birthday);
            binding.showBloodGroup.setText(Blood);
            binding.showYourId.setText(ID);
        }


        binding.floatingActionButtonforPersonalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditBasicInformationFragment fragment = new EditBasicInformationFragment();
                // fragment.setArguments(bundle);
                fragment.show(getParentFragmentManager(), "Editbasic");
            }
        });


    }
}