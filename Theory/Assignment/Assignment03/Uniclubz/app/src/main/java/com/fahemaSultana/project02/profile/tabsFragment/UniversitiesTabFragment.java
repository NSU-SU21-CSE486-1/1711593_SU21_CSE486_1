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
import com.fahemaSultana.project02.databinding.FragmentUniversitiesTabBinding;
import com.fahemaSultana.project02.profile.DataModel.Universities;
import com.fahemaSultana.project02.profile.UserProfileViewModel;
import com.fahemaSultana.project02.profile.adapter.UniversityAffiliationAdapter;
import com.fahemaSultana.project02.profile.editDialog.EditUniversityAffliationFragment;
import com.fahemaSultana.project02.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class UniversitiesTabFragment extends Fragment {

    private static final String shared_pref_name = "Universities";
    List<Universities> universities;
    SharedPreferences sharedPreferences;
    private UniversityAffiliationAdapter universityAdapter;
    private FragmentUniversitiesTabBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public UniversitiesTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_universities_tab, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadRecyclerView();

        binding.floatingActionButtonforUniversities.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditUniversityAffliationFragment fragment = new EditUniversityAffliationFragment();
                fragment.show(getParentFragmentManager(), "EditUniversity");
            }
        });

        userProfileViewModel.editUniversityUpdatedCallback.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    loadRecyclerView();
                }
            }
        });

    }

    private void loadRecyclerView() {

        sharedPreferences = getContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);

        if (universities != null)
            universities.clear();

        universities = Utils.jsonToObjectList(sharedPreferences.getString("university_list", null), Universities[].class);

        if (universities == null)
            universities = new ArrayList<>();

        binding.recyclerviewforUniversity.setHasFixedSize(true);
        universityAdapter = new UniversityAffiliationAdapter(universities);
        binding.recyclerviewforUniversity.setAdapter(universityAdapter);

        universityAdapter.notifyDataSetChanged();
    }

}
