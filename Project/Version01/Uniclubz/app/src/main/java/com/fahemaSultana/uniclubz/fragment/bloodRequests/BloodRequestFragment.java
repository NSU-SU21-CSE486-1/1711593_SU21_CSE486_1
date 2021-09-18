package com.fahemaSultana.uniclubz.fragment.bloodRequests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.BloodRequestListModel;
import com.fahemaSultana.uniclubz.databinding.FragmentBloodRequestBinding;
import com.fahemaSultana.uniclubz.fragment.bloodRequests.adapter.BloodRequestAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BloodRequestFragment extends Fragment {

    private FragmentBloodRequestBinding binding;
    private BloodRequestAdapter adapter;
    private List<BloodRequestListModel> itemList = new ArrayList<>();

    public BloodRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blood_request, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // recyclerview implementation
        adapter = new BloodRequestAdapter(itemList);
        binding.recyclerView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
        database.getReference("blood")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        itemList.clear();
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            BloodRequestListModel clubs = postSnapshot.getValue(BloodRequestListModel.class);
                            itemList.add(clubs);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.createBloodRequestDialogueFragment);
        });

    }
}