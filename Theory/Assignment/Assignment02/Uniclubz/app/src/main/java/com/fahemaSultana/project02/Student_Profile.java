package com.fahemaSultana.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Student_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);
        Bundle bundleforsignup = getIntent().getExtras();
        if (bundleforsignup != null) {
            String name_sign = bundleforsignup.getString("Name");
            String email_sign = bundleforsignup.getString("Email");
            // String Password = bundleforsignup.getString("Password");

            TextView showName = findViewById(R.id.show_profile_name);
            TextView showEmail = findViewById(R.id.show_profile_email);
            //TextView showPassword =findViewById(R.id.show_password);

            showName.setText(name_sign);
            showEmail.setText(email_sign);
            //showPassword.setText(Password);
        }
        Bundle bundleforsettings = getIntent().getExtras();
        if (bundleforsettings != null) {
            String name_setting = bundleforsettings.getString("Name_set");
            String phone_number_setting = bundleforsettings.getString("phone_set");
            String Nid_setting = bundleforsettings.getString("Nid_set");
            String birthday_setting = bundleforsettings.getString("Birthday_set");
            String Id_settings = bundleforsettings.getString("ID_set");
            String blood_group_setting = bundleforsettings.getString("Blood_group");
            String university_setting = bundleforsettings.getString("University_set");
            String department_setting = bundleforsettings.getString("Department_set");
            String Study_level_setting = bundleforsettings.getString("Study_level");

            TextView show_name_settings = findViewById(R.id.show_profile_name);
            TextView show_number = findViewById(R.id.show_phone_number);
            TextView show_Nid = findViewById(R.id.show_nid);
            TextView show_birthday = findViewById(R.id.show_birthdate_set);
            TextView show_ID = findViewById(R.id.show_studentid);
            TextView show_bloodgroup = findViewById(R.id.show_blood_group);
            TextView show_University = findViewById(R.id.show_university);
            TextView show_Department = findViewById(R.id.show_department);
            TextView show_studylevel = findViewById(R.id.show_study_level);

            show_name_settings.setText(name_setting);
            show_number.setText(phone_number_setting);
            show_Nid.setText(Nid_setting);
            show_birthday.setText(birthday_setting);
            show_ID.setText(Id_settings);
            show_bloodgroup.setText(blood_group_setting);
            show_University.setText(university_setting);
            show_Department.setText(department_setting);
            show_studylevel.setText(Study_level_setting);

        }
    }


    public void settingProfile(View view) {
        Intent profilesettings = new Intent(Student_Profile.this, profilesettings.class);
        Bundle bundleforsignup = getIntent().getExtras();
        bundleforsignup.getString("Email");
        ;
        profilesettings.putExtras(bundleforsignup);
        startActivity(profilesettings);
    }
}