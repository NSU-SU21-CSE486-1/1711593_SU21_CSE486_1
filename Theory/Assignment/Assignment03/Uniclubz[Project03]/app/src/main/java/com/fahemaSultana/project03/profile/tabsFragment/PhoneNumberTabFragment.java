package com.fahemaSultana.project03.profile.tabsFragment;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project03.R;
import com.fahemaSultana.project03.databinding.FragmentPhoneNumberTabBinding;
import com.fahemaSultana.project03.profile.DataModel.UserEntity;
import com.fahemaSultana.project03.profile.UserProfileViewModel;
import com.fahemaSultana.project03.profile.adapter.PhoneNumberAdapter;
import com.fahemaSultana.project03.profile.editDialog.EditPhoneNumberFragment;


public class PhoneNumberTabFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private FragmentPhoneNumberTabBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public PhoneNumberTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_number_tab, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.floatingActionButtonforPhonenum.setOnClickListener(v -> {
            EditPhoneNumberFragment fragment = new EditPhoneNumberFragment();
            fragment.show(getParentFragmentManager(), "EditPhoneNum");
        });

        userProfileViewModel.userEntityLiveData.observe(getViewLifecycleOwner(), new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                if (userEntity != null && userEntity.getPhoneNumbers() != null) {
                    binding.recyclerviewforPhonenum.setHasFixedSize(true);
                    adapter = new PhoneNumberAdapter(userEntity.getPhoneNumbers());
                    binding.recyclerviewforPhonenum.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


}