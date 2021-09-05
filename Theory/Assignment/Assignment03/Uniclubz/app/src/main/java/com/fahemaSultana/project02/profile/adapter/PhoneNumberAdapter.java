package com.fahemaSultana.project02.profile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;

import java.util.List;

public class PhoneNumberAdapter extends RecyclerView.Adapter<PhoneNumberAdapter.PhoneNumberViewHolder> {
    private List<PhoneNumbers> mPhoneNumbersList;

    public PhoneNumberAdapter(List<PhoneNumbers> PhoneNumbersList) {
        mPhoneNumbersList = PhoneNumbersList;
    }

    @Override
    public PhoneNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View PhoneView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_phone_number, parent, false);
        PhoneNumberViewHolder newPhoneView = new PhoneNumberViewHolder(PhoneView);
        return newPhoneView;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneNumberViewHolder holder, int position) {
        PhoneNumbers CurrentPhoneNumbers = mPhoneNumbersList.get(position);
        holder.Tag.setText(CurrentPhoneNumbers.getTag());
        holder.PhoneNumbers.setText(CurrentPhoneNumbers.getPhonenumber());

    }

    @Override
    public int getItemCount() {
        return mPhoneNumbersList.size();
    }

    public static class PhoneNumberViewHolder extends RecyclerView.ViewHolder {
        public TextView Tag;
        public TextView PhoneNumbers;

        public PhoneNumberViewHolder(@NonNull View itemView) {
            super(itemView);
            Tag = itemView.findViewById(R.id.show_phone_tag);
            PhoneNumbers = itemView.findViewById(R.id.show_phone_number);

        }
    }
}
