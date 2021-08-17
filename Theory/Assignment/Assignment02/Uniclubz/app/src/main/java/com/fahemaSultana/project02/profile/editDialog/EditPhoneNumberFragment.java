package com.fahemaSultana.project02.profile.editDialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahemaSultana.project02.R;
import com.fahemaSultana.project02.databinding.FragmentSetPhoneNumberBinding;
import com.fahemaSultana.project02.profile.tabsFragment.PhoneNumberTabFragment;

public class EditPhoneNumberFragment extends DialogFragment {

     private ViewDataBinding binding;
    private FragmentSetPhoneNumberBinding databinding;
    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "phoneNumber";
    private static final String Key_tag = "Tag_set";
    private static final String Key_PhoneNumber = "PhoneNumber_set";



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getContext().getSharedPreferences("phoneNumber", Context.MODE_PRIVATE);

        String Tag_settings = databinding.labelSpinner.getSelectedItem().toString().trim();
        String Phone_number_setting = databinding.buttonForSetPhonenumber.getText().toString().trim();

       databinding.buttonForSetPhonenumber.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();

               editor.putString(Key_tag,databinding.labelSpinner.getSelectedItem().toString().trim());
               editor.putString(Key_PhoneNumber, databinding.buttonForSetPhonenumber.getText().toString().trim());
               editor.apply();

               PhoneNumberTabFragment newPhoneNumber = new PhoneNumberTabFragment();
               Bundle nPhone = new Bundle();

               //nPhone.putString("Key_tag", Tag_settings);
              // nPhone.putString("Key_PhoneNumber", Phone_number_setting);

               newPhoneNumber.setArguments(nPhone);

           }
       });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_phone_number, container, false);
      return binding.getRoot();
    }


}