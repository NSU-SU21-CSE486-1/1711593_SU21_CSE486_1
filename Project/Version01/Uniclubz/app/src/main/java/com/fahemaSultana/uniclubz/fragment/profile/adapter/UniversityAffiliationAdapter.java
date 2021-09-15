package com.fahemaSultana.uniclubz.fragment.profile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.Universities;

import java.util.List;

public class UniversityAffiliationAdapter extends RecyclerView.Adapter<UniversityAffiliationAdapter.ViewHolder> {

    private List<Universities> dataholder;

    public UniversityAffiliationAdapter(List<Universities> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_university, parent, false);
        ViewHolder newUniversity = new ViewHolder(view);
        return newUniversity;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.university.setText(dataholder.get(position).getUniversity());
        holder.studylevel.setText(dataholder.get(position).getStudyLevel());
        holder.department.setText(dataholder.get(position).getDepartment());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView university, studylevel, department;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            university = itemView.findViewById(R.id.show_university);
            studylevel = itemView.findViewById(R.id.show_study_level);
            department = itemView.findViewById(R.id.show_department);
        }
    }
}
