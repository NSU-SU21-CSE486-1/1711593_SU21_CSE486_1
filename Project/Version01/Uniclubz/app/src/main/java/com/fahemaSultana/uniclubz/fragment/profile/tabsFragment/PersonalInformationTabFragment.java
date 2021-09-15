package com.fahemaSultana.uniclubz.fragment.profile.tabsFragment;

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
import com.fahemaSultana.uniclubz.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.fragment.profile.UserProfileViewModel;
import com.fahemaSultana.uniclubz.fragment.profile.editDialog.EditBasicInformationFragment;


public class PersonalInformationTabFragment extends Fragment {

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
                fragment.show(getParentFragmentManager(), "Editbasic");
            }
        });


        userProfileViewModel.userEntityLiveData.observe(getViewLifecycleOwner(), new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                if (userEntity != null && userEntity.getName() != null) {
                    binding.showProfileName.setText(userEntity.getName());
                    binding.showNid.setText(userEntity.getNid());
                    binding.showBirthdateSet.setText(userEntity.getBirthdate());
                    binding.showBloodGroup.setText(userEntity.getBloodGroup());
                }
            }
        });
    }


}