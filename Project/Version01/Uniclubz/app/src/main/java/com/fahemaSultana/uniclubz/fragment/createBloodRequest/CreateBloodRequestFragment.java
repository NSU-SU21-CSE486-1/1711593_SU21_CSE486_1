package com.fahemaSultana.uniclubz.fragment.createBloodRequest;

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
import com.fahemaSultana.uniclubz.dataModel.BloodRequestListModel;
import com.fahemaSultana.uniclubz.databinding.FragmentCreateBloodRequestBinding;
import com.google.firebase.database.FirebaseDatabase;


public class CreateBloodRequestFragment extends Fragment {

    FragmentCreateBloodRequestBinding binding;


    public CreateBloodRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_blood_request, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submitBlood.setOnClickListener(v -> {
            String contactName = binding.patientName.getText().toString();
            String date = binding.date.getText().toString();
            String bloodGroup = binding.bloodGroup.getSelectedItem().toString();
            String bags = binding.bloodBag.getSelectedItem().toString();
            String hospitalName = binding.hospitalName.getText().toString();
            String address = binding.hospitalLocation.getText().toString();
            String phoneNumber = binding.phoneNumber.getText().toString();

            BloodRequestListModel model = new BloodRequestListModel(contactName, date, bloodGroup, bags, hospitalName, address, phoneNumber);

            FirebaseDatabase database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
            database.getReference("blood").push().setValue(model).addOnCompleteListener(task -> {
                Toast.makeText(getContext(), "Blood request created", Toast.LENGTH_SHORT).show();
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