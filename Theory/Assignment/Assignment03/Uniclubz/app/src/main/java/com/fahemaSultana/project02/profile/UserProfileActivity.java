package com.fahemaSultana.project02.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.database.AppDatabase;
import com.fahemaSultana.project02.databinding.ActivityUserProfileBinding;
import com.fahemaSultana.project02.memberList.MemberListActivity;
import com.fahemaSultana.project02.profile.DataModel.UserEntity;
import com.fahemaSultana.project02.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.project02.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.UniversitiesTabFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityUserProfileBinding binding;
    private UserProfileTabAdapter myAdapter;
    private AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        appDatabase = AppDatabase.getInstance(this);
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

        binding.submitButton.setOnClickListener(v -> {
            UserEntity userEntity = userProfileViewModel.userEntityLiveData.getValue();

            if (userEntity == null || userEntity.getName() == null || userEntity.getName().isEmpty()) {
                Toast.makeText(this, "Please enter personal information", Toast.LENGTH_SHORT).show();
                return;

            }else if (userEntity.getUniversities() == null || userEntity.getUniversities().size() == 0) {
                Toast.makeText(this, "Please enter university", Toast.LENGTH_SHORT).show();
                return;
            } else if (userEntity.getPhoneNumbers() == null || userEntity.getPhoneNumbers().size() == 0) {
                Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                return;
            }

            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    appDatabase.userDao().insert(userEntity);
                }
            });


            Intent memberList = new Intent(UserProfileActivity.this, MemberListActivity.class);
            startActivity(memberList);
        });

        binding.viewBtn.setOnClickListener(v -> {

            Intent memberList = new Intent(UserProfileActivity.this, MemberListActivity.class);
            startActivity(memberList);
        });

    }


}
