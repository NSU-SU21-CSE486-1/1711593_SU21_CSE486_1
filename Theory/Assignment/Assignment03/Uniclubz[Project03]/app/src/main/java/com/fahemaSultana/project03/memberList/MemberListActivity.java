package com.fahemaSultana.project03.memberList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fahemaSultana.project03.R;
import com.fahemaSultana.project03.database.AppDatabase;
import com.fahemaSultana.project03.databinding.ActivityMemberListBinding;

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