package com.fahemaSultana.project02.profile.tabsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPhoneNumberTabBinding;
import com.fahemaSultana.project02.profile.editDialog.EditPhoneNumberFragment;


public class PhoneNumberTabFragment extends Fragment {

    private FragmentPhoneNumberTabBinding binding;;

    public PhoneNumberTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_number_tab, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.floatingActionButtonforPhonenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditPhoneNumberFragment fragment = new EditPhoneNumberFragment();
                fragment.show(getParentFragmentManager(),"EditPhoneNum");
            }
        });


    }
}