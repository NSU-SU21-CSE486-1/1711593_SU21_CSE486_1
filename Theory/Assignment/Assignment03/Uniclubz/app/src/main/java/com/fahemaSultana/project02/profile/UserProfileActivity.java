package com.fahemaSultana.project02.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityUserProfileBinding;
import com.fahemaSultana.project02.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.project02.memberList.MemberListActivity;
import com.fahemaSultana.project02.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.project02.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.UniversitiesTabFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityUserProfileBinding binding;
    private UserProfileTabAdapter myAdapter;

    SharedPreferences sharedPreferences;
    private FragmentPersonalInformationTabBinding personalInformationTabBinding;
    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_nid = "Nid_set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);
        UserProfileViewModel userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);


        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PersonalInformationTabFragment());
        fragmentList.add(new UniversitiesTabFragment());
        fragmentList.add(new PhoneNumberTabFragment());

        myAdapter = new UserProfileTabAdapter(getSupportFragmentManager(), getLifecycle());
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

       sharedPreferences = getSharedPreferences("basicinfo", Context.MODE_PRIVATE);


        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle sendbundle = new Bundle();
                sendbundle.putString("Key_name",sharedPreferences.getString(Key_name, null));
                sendbundle.putString("Key_nid",sharedPreferences.getString(Key_nid, null));

                Intent memberList = new Intent(UserProfileActivity.this, MemberListActivity.class);
                memberList.putExtras(sendbundle);
                startActivity(memberList);

            }
        });

    }




}
