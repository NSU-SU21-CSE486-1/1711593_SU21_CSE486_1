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
import android.widget.Toast;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityUserProfileBinding;
import com.fahemaSultana.project02.databinding.FragmentPersonalInformationTabBinding;
import com.fahemaSultana.project02.profile.DataModel.PersonalInformation;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.project02.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.project02.profile.tabsFragment.UniversitiesTabFragment;
import com.fahemaSultana.project02.utils.Utils;
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

    String Name ;
    String NID;

    private UserProfileViewModel userProfileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);
        UserProfileViewModel userProfileViewModel = new UserProfileViewModel();


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

        sharedPreferences = getSharedPreferences("personalInformation", Context.MODE_PRIVATE);




        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Name = sharedPreferences.getString(Key_name, null);
               NID =   sharedPreferences.getString(Key_nid, null);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                PersonalInformation object = new PersonalInformation();
                object.setName(Name.trim());
                object.setNID(NID.trim());

                List<PersonalInformation> list = Utils.jsonToObjectList(sharedPreferences.getString("MemberList", null), PersonalInformation[].class);

                if (!list.contains(object)) {
                    list.add(object);
                    editor.putString("MemberList", Utils.objectToJson(list));
                    editor.apply();

                    userProfileViewModel.editMemberListUpdatedCallback.setValue(true);
                    //dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "This member already exits", Toast.LENGTH_SHORT).show();
                }


                Bundle sendbundle = new Bundle();
                //sendbundle.putString("Key_name",sharedPreferences.getString(Key_name, null));
                //sendbundle.putString("Key_nid",sharedPreferences.getString(Key_nid, null));

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
        sharedPreferences = getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String sName = sharedPreferences.getString(Key_name, null);
        String sNID = sharedPreferences.getString(Key_nid, null);

    }




}
