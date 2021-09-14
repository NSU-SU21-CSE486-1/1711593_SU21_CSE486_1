package com.fahemaSultana.uniclubz.fragment.clubs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.ClubListModel;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.databinding.FragmentClubsBinding;
import com.fahemaSultana.uniclubz.fragment.clubs.Adapter.ClubsAdapter;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.RecyclerViewClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClubsFragment extends Fragment implements RecyclerViewClickListener {

    private FragmentClubsBinding binding;
    private ClubsAdapter adapter;
    private List<ClubListModel> itemList;
    private FirebaseDatabase database;
    private DatabaseReference clubsRef;

    public ClubsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_clubs, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemList = new ArrayList<>();
        adapter = new ClubsAdapter(itemList, this);
        binding.recyclerView.setAdapter(adapter);

        // get data from realtime database
        database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
        clubsRef = database.getReference("clubs");

         //List<ClubListModel> list = new ArrayList<>();
         //  list.add(new ClubListModel(0, "ACM", "https://www.facebook.com/nsuacmc/photos/a.761324994018536/816623281822040/", "North South University", "Bashundhara R/A, Dhaka"));
          // list.add(new ClubListModel(1, "Computer & Engineering Club", "http://www.northsouth.edu/newassets/images/sa/nsucec-logo.png", "North South University", "Bashundhara R/A, Dhaka"));
         //clubsRef.setValue(list);



        clubsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    ClubListModel clubs = postSnapshot.getValue(ClubListModel.class);
                    itemList.add(clubs);
                }

                adapter.notifyDataSetChanged();
            }


        @Override
        public void onCancelled(DatabaseError error) {
            Log.w("firebase", "Failed to read value.", error.toException());
        }
    });

    }

    @Override
    public void onClick(UniversityListModel model) {

    }

    @Override
    public void onClick(ClubListModel model) {

    }
}