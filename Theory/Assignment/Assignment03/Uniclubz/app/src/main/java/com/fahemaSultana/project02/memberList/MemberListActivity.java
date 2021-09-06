package com.fahemaSultana.project02.memberList;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.ActivityMemberListBinding;
import com.fahemaSultana.project02.profile.DataModel.PersonalInformation;
import com.fahemaSultana.project02.memberList.MemberListAdapter;
import com.fahemaSultana.project02.profile.UserProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class MemberListActivity extends AppCompatActivity {

    private List<PersonalInformation> personalInformationList;
    String Name, NID;
    RecyclerView recyclerView;
    private UserProfileViewModel userProfileViewModel;
    private MemberListAdapter adapter;
    private ActivityMemberListBinding binding;
    SharedPreferences sharedPreferences;
    private ArrayList<PersonalInformation> newPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewfor_memberlist);
        recyclerView.setHasFixedSize(true);
        adapter = new MemberListAdapter(newPerson);

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();


    }


}