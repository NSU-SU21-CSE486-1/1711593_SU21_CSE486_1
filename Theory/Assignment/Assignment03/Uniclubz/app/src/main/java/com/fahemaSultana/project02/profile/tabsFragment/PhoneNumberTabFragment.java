package com.fahemaSultana.project02.profile.tabsFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentPhoneNumberTabBinding;
import com.fahemaSultana.project02.profile.DataModel.PhoneNumbers;
import com.fahemaSultana.project02.profile.UserProfileViewModel;
import com.fahemaSultana.project02.profile.adapter.PhoneNumberAdapter;
import com.fahemaSultana.project02.profile.editDialog.EditPhoneNumberFragment;
import com.fahemaSultana.project02.utils.Utils;

import java.util.List;


public class PhoneNumberTabFragment extends Fragment {
    private static final String shared_pref_name = "phoneNumber";
    SharedPreferences sharedPreferences;
    private List<PhoneNumbers> phoneNumberList;
    private RecyclerView.Adapter adapter;
    private FragmentPhoneNumberTabBinding binding;
    private UserProfileViewModel userProfileViewModel;

    public PhoneNumberTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_number_tab, container, false);
        userProfileViewModel = new ViewModelProvider(getActivity()).get(UserProfileViewModel.class);
        return binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadRecycler();
        binding.floatingActionButtonforPhonenum.setOnClickListener(v -> {
            EditPhoneNumberFragment fragment = new EditPhoneNumberFragment();
            fragment.show(getParentFragmentManager(), "EditPhoneNum");
        });

        userProfileViewModel.editPhoneNumberUpdatedCallback.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    loadRecycler();
            }
        });
    }

    public void loadRecycler() {

        sharedPreferences = getContext().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);

        if (phoneNumberList != null)
            phoneNumberList.clear();

        phoneNumberList = Utils.jsonToObjectList(sharedPreferences.getString("phone_number_list", null), PhoneNumbers[].class);

        binding.recyclerviewforPhonenum.setHasFixedSize(true);
        adapter = new PhoneNumberAdapter(phoneNumberList);
        binding.recyclerviewforPhonenum.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}