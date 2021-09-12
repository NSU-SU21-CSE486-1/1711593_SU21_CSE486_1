package com.fahemaSultana.uniclubz.fragment.universities.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.databinding.RecycleUniversityListBinding;

import java.util.List;

public class UniversitiesAdapter extends RecyclerView.Adapter<UniversitiesAdapter.ViewHolder> {

    private List<UniversityListModel> itemList;
    private RecyclerViewClickListener recyclerViewClickListener;

    public UniversitiesAdapter(List<UniversityListModel> itemList, RecyclerViewClickListener recyclerViewClickListener) {
        this.itemList = itemList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public UniversitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        RecycleUniversityListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycle_university_list, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UniversityListModel model = itemList.get(position);
        holder.binding.title.setText(model.getTitle());

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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RecycleUniversityListBinding binding;

        public ViewHolder(RecycleUniversityListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}