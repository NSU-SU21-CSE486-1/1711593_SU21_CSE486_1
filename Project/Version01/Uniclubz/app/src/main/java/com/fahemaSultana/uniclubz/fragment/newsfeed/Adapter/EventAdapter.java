package com.fahemaSultana.uniclubz.fragment.newsfeed.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.EventListModel;
import com.fahemaSultana.uniclubz.databinding.RecycleEventListBinding;

import java.util.List;

public class EventAdapter extends  RecyclerView.Adapter<EventAdapter.ViewHolder>{
    private List<EventListModel> itemList;

    public EventAdapter(List<EventListModel> itemList) {
        this.itemList = itemList;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleEventListBinding eventListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recycle_event_list, parent, false);
        return  new EventAdapter.ViewHolder(eventListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        EventListModel model = itemList.get(position);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RecycleEventListBinding eventListBinding;
        public ViewHolder(RecycleEventListBinding eventListBinding) {
            super(eventListBinding.getRoot());
            this.eventListBinding=eventListBinding;
        }
    }
}
