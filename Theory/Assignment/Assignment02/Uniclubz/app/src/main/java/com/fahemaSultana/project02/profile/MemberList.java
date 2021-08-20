package com.fahemaSultana.project02.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityMemberListBinding;
import com.fahemaSultana.project02.profile.DataModel.PersonalInformation;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.adapter.MemberListAdapter;
import com.fahemaSultana.project02.profile.adapter.PhoneNumberAdapter;
import com.fahemaSultana.project02.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MemberList extends AppCompatActivity {

    private List<PersonalInformation> personalInformationList;
    String Name, NID;
    RecyclerView recyclerView;
    private UserProfileViewModel userProfileViewModel;
    private MemberListAdapter adapter;
    private ActivityMemberListBinding binding;
    SharedPreferences sharedPreferences;
    private List<PersonalInformation> newPerson;


    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_nid = "Nid_set";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        Bundle backBundle = getIntent().getExtras();
        //if (backBundle != null) {
          //  Name = backBundle.getString("Key_name");
            //NID = backBundle.getString("Key_nid");

            //TextView showName = findViewById(R.id.show_profile_name);
            //TextView showNID = findViewById(R.id.show_nid);
       // }

        userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        loadRecycler();

        userProfileViewModel.editMemberListUpdatedCallback.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    loadRecycler();
            }
        });





        //userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        //newPerson = new ArrayList<>();
        //newPerson.add(new PersonalInformation(Name, NID));
        //newPerson.add(new PersonalInformation(Name, NID));
        //newPerson.add(new PersonalInformation(Name, NID));

        //recyclerView = (RecyclerView) findViewById(R.id.recyclerviewfor_memberlist);
        //recyclerView.setHasFixedSize(true);
        //adapter = new MemberListAdapter(newPerson);

        //recyclerView.setAdapter(adapter);

        //adapter.notifyDataSetChanged();


    }


    public void loadRecycler() {

        sharedPreferences = getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);

        if (newPerson != null)
            newPerson.clear();

        newPerson = Utils.jsonToObjectList(sharedPreferences.getString("phone_number_list", null), PersonalInformation[].class);

        //binding.recyclerviewforMemberlist.setHasFixedSize(true);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerviewfor_memberlist) ;
        recyclerView.setHasFixedSize(true);
        adapter = new MemberListAdapter(newPerson);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }








}