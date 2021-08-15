package com.fahemaSultana.project02.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityUserProfileBinding;
import com.fahemaSultana.project02.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.project02.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.UniversitiesTabFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityUserProfileBinding binding;
    private UserProfileTabAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PersonalInformationTabFragment());
        fragmentList.add(new UniversitiesTabFragment());

        myAdapter = new UserProfileTabAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.setAdapter(myAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
            switch (position){
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
                }
        ).attach();
    }
}