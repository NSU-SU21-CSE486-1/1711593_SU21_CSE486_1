package com.fahemaSultana.uniclubz.fragment.universities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.databinding.FragmentUniversitiesBinding;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.RecyclerViewClickListener;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.UniversitiesAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesFragment extends Fragment implements RecyclerViewClickListener {

    private FragmentUniversitiesBinding binding;
    private UniversitiesAdapter adapter;
    private List<UniversityListModel> itemList;
    private FirebaseDatabase database;
    private DatabaseReference universitiesRef;

    public UniversitiesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_universities, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup up recyclerview
        itemList = new ArrayList<>();
        adapter = new UniversitiesAdapter(itemList, this);
        binding.recyclerView.setAdapter(adapter);

        // get data from realtime database
        database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
        universitiesRef = database.getReference("universities");

        universitiesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    UniversityListModel university = postSnapshot.getValue(UniversityListModel.class);
                    itemList.add(university);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });
    }

//    private void addDemoDataToDatabase() {
//        List<UniversityListModel> list = new ArrayList<>();
//        list.add(new UniversityListModel(0, "North South University", "https://blogs.kent.ac.uk/internationalpartnerships-news/files/2020/12/nsu.jpg", "Bashundhara R/A, Dhaka"));
//        list.add(new UniversityListModel(1, "BRAC University", "https://media-eng.dhakatribune.com/uploads/2017/08/BracU-Protest-08012017_Mahadi-Al-Hasnat-2_feature-edited.jpg", "Banani, Dhaka"));
//        list.add(new UniversityListModel(2, "Independent University", "https://selectuni.com/resources/uploads/Independent%20University,%20Bangladesh.jpg", "Bashundhara R/A, Dhaka"));
//        list.add(new UniversityListModel(3, "American Internation University", "https://www.aiub.edu/Files/Uploads/new_campus_pic_2.jpg", "Bashundhara R/A, Dhaka"));
//        universitiesRef.setValue(list);
//    }

    @Override
    public void onClick(UniversityListModel model) {
        NavHostFragment.findNavController(this).navigate(R.id.clubsFragment);
    }
}