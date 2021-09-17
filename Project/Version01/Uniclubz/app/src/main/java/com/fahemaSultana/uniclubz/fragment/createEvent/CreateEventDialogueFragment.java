package com.fahemaSultana.uniclubz.fragment.createEvent;

import android.os.Bundle;
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
import com.fahemaSultana.uniclubz.dataModel.EventListModel;
import com.fahemaSultana.uniclubz.databinding.FragmentCreateEventDialogueBinding;
import com.google.firebase.database.FirebaseDatabase;


public class CreateEventDialogueFragment extends Fragment {

    FragmentCreateEventDialogueBinding binding;


    public CreateEventDialogueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_event_dialogue, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submit.setOnClickListener(v -> {

            String name = binding.eventName.getText().toString();
            String university = binding.universityName.getSelectedItem().toString();
            String date = binding.date.getText().toString();
            String details = binding.details.getText().toString();
            String bannerLink = binding.imageLink.getText().toString();

            EventListModel model = new EventListModel(name, university, date, details, bannerLink);

            FirebaseDatabase database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
            database.getReference("events").push().setValue(model).addOnCompleteListener(task -> {
                Toast.makeText(getContext(), "Event created", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(this).popBackStack();
            });

        });

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }
}