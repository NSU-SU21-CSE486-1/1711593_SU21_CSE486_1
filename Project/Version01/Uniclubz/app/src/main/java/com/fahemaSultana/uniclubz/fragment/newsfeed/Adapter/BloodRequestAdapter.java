package com.fahemaSultana.uniclubz.fragment.newsfeed.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.BloodRequestListModel;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.databinding.RecycleBloodListBinding;
import com.fahemaSultana.uniclubz.databinding.RecycleUniversityListBinding;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.UniversitiesAdapter;

import java.util.List;

public class BloodRequestAdapter extends RecyclerView.Adapter<BloodRequestAdapter.ViewHolder> {

    private List<BloodRequestListModel> itemList;

    public BloodRequestAdapter(List<BloodRequestListModel> itemList) {
        this.itemList = itemList;
    }


    @Override
    public BloodRequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleBloodListBinding bloodListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recycle_blood_list, parent, false);
        return  new BloodRequestAdapter.ViewHolder(bloodListBinding);
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
        public RecycleBloodListBinding bloodListBinding;

        public ViewHolder(RecycleBloodListBinding bloodListBinding) {
            super(bloodListBinding.getRoot());
            this.bloodListBinding=bloodListBinding;
        }
    }
}
