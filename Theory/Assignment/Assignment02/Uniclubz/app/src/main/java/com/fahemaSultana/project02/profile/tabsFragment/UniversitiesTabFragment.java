package com.fahemaSultana.project02.profile.tabsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentUniversitiesTabBinding;
import com.fahemaSultana.project02.profile.DataModel.Universities;
import com.fahemaSultana.project02.profile.adapter.RecyclerViewUniversityAffliationAdapter;
import com.fahemaSultana.project02.profile.editDialog.EditUniversityAffliationFragment;


import java.util.ArrayList;


public class UniversitiesTabFragment extends Fragment {
    RecyclerViewUniversityAffliationAdapter adapter;
    private RecyclerView recyclerView ;
    ArrayList<Universities> universities;

    private FragmentUniversitiesTabBinding binding;

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

        //recyclerView = binding.recyclerViewforUniversity.findViewById(R.id.recyclerViewfor_university);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //universities = new ArrayList<>();

        //enter_university_name_settings = (Spinner) getView().findViewById(R.id.enter_your_universityname_set);
        //enter_department_name_settings = (Spinner) getView().findViewById(R.id.departement_settings);
        //enter_study_level_settings = (Spinner) getView().findViewById(R.id.study_level_settings);


        //String university_settings = enter_university_name_settings.getSelectedItem().toString().trim();
        //String department_settings = enter_department_name_settings.getSelectedItem().toString().trim();
        //String study_level_settings = enter_study_level_settings.getSelectedItem().toString().trim();


        //Universities universiti_obj = new Universities(university_settings,department_settings,study_level_settings);
        //universities.add(universiti_obj);


        binding.floatingActionButtonforUniversities.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditUniversityAffliationFragment fragment = new EditUniversityAffliationFragment();
                fragment.show(getParentFragmentManager(), "EditUniversity");
            }
        });
    }



}
