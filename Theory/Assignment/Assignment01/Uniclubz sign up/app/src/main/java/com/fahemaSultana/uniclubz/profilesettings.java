package com.fahemaSultana.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class profilesettings extends AppCompatActivity {
    private EditText enter_name_Setting;
    private EditText enter_phonrnumber_setting;
    private EditText enter_nid_setting;
    private EditText enter_id_setting;
    private EditText enter_birthday_setting;
    private Spinner enter_blood_group_settings;
    private Spinner enter_university_name_settings;
    private Spinner enter_department_name_settings;
    private Spinner enter_study_level_settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilesettings);
        enter_name_Setting =(EditText) findViewById(R.id.enter_your_name_set);
        enter_phonrnumber_setting = (EditText) findViewById(R.id.enter_your_phonenumber_set);
        enter_nid_setting = (EditText) findViewById(R.id.enter_your_nid_set);
        enter_birthday_setting = (EditText) findViewById(R.id.enter_your_birthdate_set);
        enter_id_setting = (EditText) findViewById(R.id.enter_your_id_set);
        enter_blood_group_settings = (Spinner) findViewById(R.id.bloodgroup_setting);
        enter_university_name_settings = (Spinner) findViewById(R.id.enter_your_universityname_set);
        enter_department_name_settings = (Spinner) findViewById(R.id.departement_settings);
        enter_study_level_settings = (Spinner) findViewById(R.id.study_level_settings);

    }

    public void saveProfile(View view) {
        String Name_settings = enter_name_Setting.getText().toString().trim();
        String Phone_number_setting = enter_phonrnumber_setting.getText().toString().trim();
        String Nid_settings = enter_nid_setting.getText().toString().trim();
        String birthday_settings = enter_birthday_setting.getText().toString().trim();
        String ID_settings = enter_id_setting.getText().toString().trim();
        String blood_group_settings = enter_blood_group_settings.getSelectedItem().toString().trim();
        String university_settings = enter_university_name_settings.getSelectedItem().toString().trim();
        String department_settings = enter_department_name_settings.getSelectedItem().toString().trim();
        String study_level_settings = enter_study_level_settings.getSelectedItem().toString().trim();

        Bundle bundleforsettings = new Bundle();
        bundleforsettings.putString("Name_set", Name_settings);
        bundleforsettings.putString("phone_set", Phone_number_setting);
        bundleforsettings.putString("Nid_set", Nid_settings);
        bundleforsettings.putString("Birthday_set", birthday_settings);
        bundleforsettings.putString("ID_set", ID_settings);
        bundleforsettings.putString("Blood_group", blood_group_settings);
        bundleforsettings.putString("University_set", university_settings);
        bundleforsettings.putString("Department_set", department_settings);
        bundleforsettings.putString("Study_level", study_level_settings);



        Intent profilesettingssave = new Intent(profilesettings.this, Student_Profile.class);
        profilesettingssave.putExtras(bundleforsettings);
        startActivity(profilesettingssave);
    }
}