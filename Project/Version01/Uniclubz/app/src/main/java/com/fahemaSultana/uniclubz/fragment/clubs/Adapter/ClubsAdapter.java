package com.fahemaSultana.uniclubz.fragment.clubs.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.ClubListModel;
import com.fahemaSultana.uniclubz.databinding.RecycleClubListBinding;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.RecyclerViewClickListener;

import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ViewHolder> {

    private List<ClubListModel> itemList;
    private RecyclerViewClickListener recyclerViewClickListener;

    public ClubsAdapter(List<ClubListModel> itemList, RecyclerViewClickListener recyclerViewClickListener) {
        this.itemList = itemList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public ClubsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleClubListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycle_club_list, parent, false);

        return new ClubsAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsAdapter.ViewHolder holder, int position) {

        ClubListModel model = itemList.get(position);
        holder.binding.title.setText(model.getTitle());
        holder.binding.university.setText(model.getUniversity());
        holder.binding.location.setText(model.getLocation());



        Glide.with(holder.binding.image)
                .load(model.getImage())
                .into(holder.binding.image);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickListener.onClick(model);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RecycleClubListBinding binding;
        public ViewHolder(RecycleClubListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
