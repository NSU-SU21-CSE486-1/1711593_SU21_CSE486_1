package com.fahemaSultana.project02.profile.tabsFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPhoneNumberTabBinding;
import com.fahemaSultana.project02.databinding.FragmentSetPhoneNumberBinding;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.adapter.RecyclerViewPhoneNumberAdapter;
import com.fahemaSultana.project02.profile.editDialog.EditPhoneNumberFragment;

import java.util.ArrayList;


public class PhoneNumberTabFragment extends Fragment {

    private RecyclerView PhoneRecyclerview;
    private RecyclerView.Adapter PhoneAdapter;
    private RecyclerView.LayoutManager PhoneLayoutmanager;


    private FragmentPhoneNumberTabBinding binding;;
    private  PhoneNumberTabFragment phoneNumberTabFragment;

    public PhoneNumberTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_number_tab, container, false);
        return binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<PhoneNumbers> NewPhoneNumbers = new ArrayList<>();
        NewPhoneNumbers.add(new PhoneNumbers("Tag","PhoneNumbers"));

        PhoneRecyclerview = binding.recyclerviewforPhonenum.findViewById(R.id.recyclerviewfor_phonenum);
        PhoneRecyclerview.setHasFixedSize(true);
       // PhoneLayoutmanager = new LinearLayoutManager(getParentFragment().getContext(),RecyclerView.VERTICAL,true);

        PhoneAdapter = new RecyclerViewPhoneNumberAdapter(NewPhoneNumbers);

       // PhoneRecyclerview.setLayoutManager(PhoneLayoutmanager);
        PhoneRecyclerview.setAdapter(PhoneAdapter);


        binding.floatingActionButtonforPhonenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditPhoneNumberFragment fragment = new EditPhoneNumberFragment();
                fragment.show(getParentFragmentManager(),"EditPhoneNum");




            }
        });


    }
}