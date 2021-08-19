package com.fahemaSultana.project02.profile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.profile.DataModel.PersonalInformation;

import java.util.List;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberListViewHolder> {
    private List<PersonalInformation> mPersonalInformation;

    public MemberListAdapter(List<PersonalInformation> PersonalInformation) {
        mPersonalInformation = PersonalInformation;
    }

    @Override
    public MemberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View memberView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_memberlist, parent, false);
        MemberListViewHolder newMemberView = new MemberListViewHolder(memberView);
        return newMemberView;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListViewHolder holder, int position) {
        PersonalInformation CurrentPhoneNumbers = mPersonalInformation.get(position);
        holder.Name.setText(CurrentPhoneNumbers.getName());
        holder.ID.setText(CurrentPhoneNumbers.getID());

    }

    @Override
    public int getItemCount() {
        return mPersonalInformation.size();
    }

    public static class MemberListViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView ID;

        public MemberListViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.show_profile_name);
            ID = itemView.findViewById(R.id.show_your_id);

        }
    }
}
