package com.fahemaSultana.project02.profile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityMemberListBinding;
import com.fahemaSultana.project02.profile.DataModel.PersonalInformation;
import com.fahemaSultana.project02.profile.adapter.MemberListAdapter;

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
    private ArrayList<PersonalInformation> newPerson;


    private static final String shared_pref_name = "basicinfo";
    private static final String Key_name = "Name_set";
    private static final String Key_nid = "Nid_set";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        Bundle backBundle = getIntent().getExtras();
        if (backBundle != null) {
            Name = backBundle.getString("Key_name");
            NID = backBundle.getString("Key_nid");

            //TextView showName = findViewById(R.id.show_profile_name);
            //TextView showNID = findViewById(R.id.show_nid);
        }

        userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        newPerson = new ArrayList<>();
        newPerson.add(new PersonalInformation(Name, NID));
        newPerson.add(new PersonalInformation("Sumaiya Sadia", "17325467"));
        newPerson.add(new PersonalInformation("Asfiwar Raihan", "153901088"));
        newPerson.add(new PersonalInformation("Afroza Alam", "1356701088"));
        newPerson.add(new PersonalInformation("Kanij Sultana", "186345278"));
        newPerson.add(new PersonalInformation("Masbah Tanjil", "198643268"));
        newPerson.add(new PersonalInformation("Fiona Moumi", "1235678907"));
        newPerson.add(new PersonalInformation("HM Tamim", "187654098"));
        newPerson.add(new PersonalInformation("Sahana Akter", "10987548"));
        newPerson.add(new PersonalInformation(Name, NID));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewfor_memberlist);
        recyclerView.setHasFixedSize(true);
        adapter = new MemberListAdapter(newPerson);

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();


    }


}