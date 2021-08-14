package com.fahemaSultana.Project02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Set_basicinformation extends Fragment {

    Button next_university;
    View view;
    private EditText enter_name_Setting;
    private EditText enter_nid_setting;
    private EditText enter_id_setting;
    private EditText enter_birthday_setting;
    private Spinner enter_blood_group_settings;


    public Set_basicinformation() {
        // Required empty public constructor

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enter_name_Setting = (EditText) findViewById(R.id.enter_your_name_set);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       view= inflater.inflate(R.layout.fragment_set_basicinformation, container, false);
        next_university=view.findViewById(R.id.next_button_foe_university);
        next_university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_set_basicinformation_to_set_university_Affiliation);

            }
        });
        return view;
    }
}