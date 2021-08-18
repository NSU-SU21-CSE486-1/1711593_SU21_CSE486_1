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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentUniversitiesTabBinding;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.DataModel.Universities;
import com.fahemaSultana.project02.profile.adapter.RecyclerViewUniversityAffliationAdapter;
import com.fahemaSultana.project02.profile.editDialog.EditUniversityAffliationFragment;


import java.util.ArrayList;


public class UniversitiesTabFragment extends Fragment {

    ArrayList<Universities> universities;

    private RecyclerView UniversityRecycler;
    private RecyclerView.Adapter UniversityAdapter;
    private RecyclerView.LayoutManager UniversityLayoutmanager;

    private FragmentUniversitiesTabBinding binding;

    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "Universities";
    private static final String Key_universityname = "university_name";
    private static final String Key_departmentname = "department_name";
    private static final String Key_studylevel = "study_level";

    public UniversitiesTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_universities_tab, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String SUniversity = sharedPreferences.getString(Key_universityname, null);
        String SDepartment = sharedPreferences.getString(Key_departmentname, null);
        String SLevel = sharedPreferences.getString(Key_studylevel, null);

        ArrayList<Universities> NewUniversity = new ArrayList<>();
        NewUniversity.add(new Universities(SUniversity,SDepartment,SLevel));

        UniversityRecycler = binding.recyclerviewforUniversity.findViewById(R.id.recyclerviewfor_university);
        UniversityRecycler.setHasFixedSize(true);
       // UniversityLayoutmanager = new LinearLayoutManager();

        UniversityAdapter = new RecyclerViewUniversityAffliationAdapter(NewUniversity);
        //UniversityRecycler.setLayoutManager(UniversityLayoutmanager);

        UniversityRecycler.setAdapter(UniversityAdapter);




        binding.floatingActionButtonforUniversities.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditUniversityAffliationFragment fragment = new EditUniversityAffliationFragment();
                fragment.show(getParentFragmentManager(), "EditUniversity");
            }
        });
    }



}
