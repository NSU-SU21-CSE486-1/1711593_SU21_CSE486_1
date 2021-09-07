package com.fahemaSultana.project02.memberList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.profile.DataModel.UserEntity;

import java.util.List;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberListViewHolder> {

    private List<UserEntity> mPersonalInformation;
    private MemberListActivity activity;

    public MemberListAdapter(List<UserEntity> personalInformation, MemberListActivity activity) {
        this.mPersonalInformation = personalInformation;
        this.activity = activity;
    }

    @Override
    public MemberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View memberView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_memberlist, parent, false);
        MemberListViewHolder newMemberView = new MemberListViewHolder(memberView);
        return newMemberView;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListViewHolder holder, int position) {
        UserEntity entity = mPersonalInformation.get(position);
        holder.Name.setText(entity.getName());
        holder.NID.setText(entity.getNid());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Name: " + entity.getName() + ", NID: " + entity.getNid() + ", Date of Birth: " + entity.getBirthdate() + ", Blood Group: " + entity.getBloodGroup();
                if (entity.getUniversities() != null && entity.getUniversities().size() > 0)
                    text += "\nUniversity: " + entity.getUniversities().get(0).getUniversity();
                if (entity.getPhoneNumbers() != null && entity.getPhoneNumbers().size() > 0)
                    text += "\nPhone Number: " + entity.getPhoneNumbers().get(0).getPhonenumber();

                Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPersonalInformation.size();
    }


    public static class MemberListViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView NID;

        public MemberListViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.show_profile_name);
            NID = itemView.findViewById(R.id.show_nid);
        }
    }

}
