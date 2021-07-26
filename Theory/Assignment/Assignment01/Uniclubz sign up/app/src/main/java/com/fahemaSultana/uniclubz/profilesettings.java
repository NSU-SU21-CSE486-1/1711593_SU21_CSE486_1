package com.fahemaSultana.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}