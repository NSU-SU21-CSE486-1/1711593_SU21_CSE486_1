package com.fahemaSultana.uniclubz.activity.memberList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.database.AppDatabase;
import com.fahemaSultana.uniclubz.databinding.ActivityMemberListBinding;

public class MemberListActivity extends AppCompatActivity {

    private MemberListAdapter adapter;
    private ActivityMemberListBinding binding;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_member_list);

        appDatabase = AppDatabase.getInstance(this);

        appDatabase.userDao().getAllLiveData().observe(this, userEntities -> {
            adapter = new MemberListAdapter(userEntities, this);
            binding.recyclerviewforMemberlist.setAdapter(adapter);
        });
    }

}