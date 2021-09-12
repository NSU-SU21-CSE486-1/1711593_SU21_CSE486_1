package com.fahemaSultana.uniclubz.activity.profile.tabsFragment;

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

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentUniversitiesTabBinding;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.activity.profile.UserProfileViewModel;
import com.fahemaSultana.uniclubz.activity.profile.adapter.UniversityAffiliationAdapter;
import com.fahemaSultana.uniclubz.activity.profile.editDialog.EditUniversityAffliationFragment;


public class UniversitiesTabFragment extends Fragment {

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

        binding.floatingActionButtonforUniversities.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditUniversityAffliationFragment fragment = new EditUniversityAffliationFragment();
                fragment.show(getParentFragmentManager(), "EditUniversity");
            }
        });

        userProfileViewModel.userEntityLiveData.observe(getViewLifecycleOwner(), new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                if (userEntity != null && userEntity.getUniversities() != null) {
                    binding.recyclerviewforUniversity.setHasFixedSize(true);
                    universityAdapter = new UniversityAffiliationAdapter(userEntity.getUniversities());
                    binding.recyclerviewforUniversity.setAdapter(universityAdapter);
                    universityAdapter.notifyDataSetChanged();
                }
            }
        });

    }


}
