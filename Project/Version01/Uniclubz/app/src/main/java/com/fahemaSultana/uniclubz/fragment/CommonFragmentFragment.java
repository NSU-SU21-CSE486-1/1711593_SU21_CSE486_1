package com.fahemaSultana.uniclubz.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.databinding.FragmentUniversitiesBinding;

public class CommonFragmentFragment extends Fragment {

    FragmentUniversitiesBinding binding;

    public CommonFragmentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_universities,  container, false);
        return binding.getRoot();
    }
}