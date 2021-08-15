package com.fahemaSultana.project02.profile.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.profile.DataModel.Universities;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewForProfileinfo extends RecyclerView.Adapter<RecyclerViewForProfileinfo.ViewHolder>  {

    ArrayList<Universities> dataholder ;

    public RecyclerViewForProfileinfo(ArrayList<Universities> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_university,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.university.setText(dataholder.get(position).getUniversity());
        holder.studylevel.setText(dataholder.get(position).getStudylevel());
        holder.department.setText(dataholder.get(position).getDepartment());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {    TextView university , studylevel , department;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            university=itemView.findViewById(R.id.show_university);
            studylevel=itemView.findViewById(R.id.show_study_level);
            department = itemView.findViewById(R.id.show_department);


        }
    }



}
