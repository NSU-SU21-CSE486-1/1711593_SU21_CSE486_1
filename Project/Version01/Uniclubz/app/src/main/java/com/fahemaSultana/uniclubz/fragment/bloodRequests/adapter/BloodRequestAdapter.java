package com.fahemaSultana.uniclubz.fragment.bloodRequests.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.binding.title.setText("Blood Needed For " + model.getContactName());
        holder.binding.info.setText(model.getBloodBag() + " Bags " + model.getBloodGroup() + " Blood");
        holder.binding.date.setText(model.getDate());
        holder.binding.hospital.setText(model.getHospitalName());
        holder.binding.address.setText(model.getHospitalLocation());
        holder.binding.call.setText(model.getPhoneNumber());

        holder.binding.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = model.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                holder.binding.getRoot().getContext().startActivity(intent);
            }
        });


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
