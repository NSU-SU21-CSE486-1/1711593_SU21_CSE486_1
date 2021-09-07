package com.fahemaSultana.project02.memberList;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.database.AppDatabase;
import com.fahemaSultana.project02.databinding.ActivityMemberListBinding;
import com.fahemaSultana.project02.profile.DataModel.UserEntity;

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