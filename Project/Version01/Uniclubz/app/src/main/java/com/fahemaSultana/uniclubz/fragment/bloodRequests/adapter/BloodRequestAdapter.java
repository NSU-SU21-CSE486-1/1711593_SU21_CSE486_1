package com.fahemaSultana.uniclubz.fragment.bloodRequests.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.BloodRequestListModel;
import com.fahemaSultana.uniclubz.databinding.RecycleBloodListBinding;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.RecyclerViewClickListener;

import java.util.List;

public class BloodRequestAdapter extends RecyclerView.Adapter<BloodRequestAdapter.ViewHolder> {

    private List<BloodRequestListModel> itemList;
    private RecyclerViewClickListener recyclerViewClickListener;

    public BloodRequestAdapter(List<BloodRequestListModel> itemList) {
        this.itemList = itemList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public BloodRequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleBloodListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recycle_blood_list, parent, false);

        return new BloodRequestAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodRequestAdapter.ViewHolder holder, int position) {

        BloodRequestListModel model = itemList.get(position);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RecycleBloodListBinding binding;

        public ViewHolder(RecycleBloodListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
