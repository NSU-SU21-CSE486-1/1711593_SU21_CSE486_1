package com.fahemaSultana.project02.profile.editDialog;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetPhoneNumberBinding;

public class EditPhoneNumberFragment extends DialogFragment {

     private ViewDataBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_phone_number, container, false);
      return binding.getRoot();
    }
}