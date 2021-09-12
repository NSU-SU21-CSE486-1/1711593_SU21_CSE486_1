package com.fahemaSultana.uniclubz.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.database.AppDatabase;
import com.fahemaSultana.uniclubz.databinding.ActivityUserProfileBinding;
import com.fahemaSultana.uniclubz.activity.memberList.MemberListActivity;
import com.fahemaSultana.uniclubz.activity.profile.adapter.UserProfileTabAdapter;
import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.UniversitiesTabFragment;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

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
            } else if (userEntity.getUniversities() == null || userEntity.getUniversities().size() == 0) {
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

        initFirebase();

    }

    private void initFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("universities");

        List<UniversityListModel> list = new ArrayList<>();
        list.add(new UniversityListModel(0, "North South University", "https://blogs.kent.ac.uk/internationalpartnerships-news/files/2020/12/nsu.jpg", "Bashundhara R/A, Dhaka"));
        list.add(new UniversityListModel(1, "BRAC University", "https://media-eng.dhakatribune.com/uploads/2017/08/BracU-Protest-08012017_Mahadi-Al-Hasnat-2_feature-edited.jpg", "Banani, Dhaka"));
        list.add(new UniversityListModel(2, "Independent University", "https://selectuni.com/resources/uploads/Independent%20University,%20Bangladesh.jpg", "Bashundhara R/A, Dhaka"));
        list.add(new UniversityListModel(3, "American Internation University", "https://www.aiub.edu/Files/Uploads/new_campus_pic_2.jpg", "Bashundhara R/A, Dhaka"));
        myRef.setValue(list);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                // String value = dataSnapshot.getValue(String.class);
                Log.e("firebase", "Value is: " + new Gson().toJson(dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });

    }


}
