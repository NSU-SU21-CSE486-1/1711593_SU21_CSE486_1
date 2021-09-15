package com.fahemaSultana.uniclubz.fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.activity.memberList.MemberListActivity;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.databinding.FragmentUserProfileBinding;
import com.fahemaSultana.uniclubz.fragment.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.uniclubz.fragment.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.uniclubz.fragment.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.uniclubz.fragment.profile.tabsFragment.UniversitiesTabFragment;
import com.fahemaSultana.uniclubz.sharedPreference.CredentialPreference;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserProfileFragment extends Fragment {

    private FragmentUserProfileBinding binding;
    private UserProfileTabAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserProfileViewModel userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PersonalInformationTabFragment());
        fragmentList.add(new UniversitiesTabFragment());
        fragmentList.add(new PhoneNumberTabFragment());

        myAdapter = new UserProfileTabAdapter(getParentFragmentManager(), getLifecycle());
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.setAdapter(myAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Personal Information");
                    break;
                case 1:
                    tab.setText("Universities");
                    break;
                case 2:
                    tab.setText("Phone Numbers");
                    break;
            }
        }).attach();

        binding.submitButton.setOnClickListener(v -> {
            UserEntity userEntity = userProfileViewModel.userEntityLiveData.getValue();

            if (userEntity == null || userEntity.getName() == null || userEntity.getName().isEmpty()) {
                Toast.makeText(getContext(), "Please enter personal information", Toast.LENGTH_SHORT).show();
                return;
            } else if (userEntity.getUniversities() == null || userEntity.getUniversities().size() == 0) {
                Toast.makeText(getContext(), "Please enter university", Toast.LENGTH_SHORT).show();
                return;
            } else if (userEntity.getPhoneNumbers() == null || userEntity.getPhoneNumbers().size() == 0) {
                Toast.makeText(getContext(), "Please enter phone number", Toast.LENGTH_SHORT).show();
                return;
            }

            userEntity.setUserId(CredentialPreference.getInstance().getUserId());

            FirebaseDatabase database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
            DatabaseReference myRef = database.getReference("users");

            myRef.child(CredentialPreference.getInstance().getUserId()).setValue(userEntity);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    CredentialPreference.getInstance().setUserDetails(userEntity);
                    // navigate to homepage
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });

        binding.viewBtn.setOnClickListener(v -> {

            Intent memberList = new Intent(getActivity(), MemberListActivity.class);
            startActivity(memberList);
        });

    }


}
