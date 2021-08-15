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
import com.fahemaSultana.project02.databinding.FragmentUniversitiesTabBinding;
import com.fahemaSultana.project02.profile.editDialog.EditUniversityAffliationFragment;


public class UniversitiesTabFragment extends Fragment {

    private FragmentUniversitiesTabBinding binding;

    public UniversitiesTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_universities_tab, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     binding.floatingActionButtonforUniversities.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   EditUniversityAffliationFragment fragment = new EditUniversityAffliationFragment();
                   fragment.show(getParentFragmentManager(),"EditUniversity");
               }
           });
         }


    }
