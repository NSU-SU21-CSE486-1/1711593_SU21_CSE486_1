package com.fahemaSultana.project02.profile.tabsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.project02.profile.editDialog.EditBasicInformationFragment;


public class PersonalInformationTabFragment extends Fragment {

    private FragmentPersonalInformationTabBinding binding;

    public PersonalInformationTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_personal_information_tab, container, false);
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
                fragment.show(getParentFragmentManager(), "Editbasic");
            }
        });

    }
}