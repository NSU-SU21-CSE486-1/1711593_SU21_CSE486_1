package com.fahemaSultana.project02.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityUserProfileBinding;
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
    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_nid = "Nid_set";

    private UserProfileViewModel userProfileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PersonalInformationTabFragment());
        fragmentList.add(new UniversitiesTabFragment());
        fragmentList.add(new PhoneNumberTabFragment());

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




        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle sendbundle = new Bundle();
                sendbundle.putString("Key_name",sharedPreferences.getString(Key_name, null));
                sendbundle.putString("Key_nid",sharedPreferences.getString(Key_nid, null));

                Intent memberList = new Intent(UserProfileActivity.this, MemberList.class);
                memberList.putExtras(sendbundle);
                startActivity(memberList);

            }
        });



    }




    @Override
    public void onResume() {
        super.onResume();
        updateInputFields();
    }

    private void updateInputFields() {
        sharedPreferences = getBaseContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String sName = sharedPreferences.getString(Key_name, null);
        String sNID = sharedPreferences.getString(Key_nid, null);

    }




}
