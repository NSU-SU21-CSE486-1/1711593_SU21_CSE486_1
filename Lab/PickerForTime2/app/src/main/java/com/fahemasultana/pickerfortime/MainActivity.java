package com.fahemasultana.pickerfortime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;

import java.text.Format;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     private Button datepickerbtn;
     private Button timepickerbtn;
     private TextView selected_date;
     private TextView selected_time;
     int hour , setminute, sec ;
    String tag = "Date_picker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datepickerbtn = findViewById(R.id.date_picker_btn);
        timepickerbtn = findViewById(R.id.time_picker_btn);
        selected_date = findViewById(R.id.selected_date);
        selected_time = findViewById(R.id.selected_time);

        timepickerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour =hourOfDay;
                                setminute =minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,hour,setminute);
                                selected_time.setText("Selected Time :" + DateFormat.format("hh:mm aa", calendar));


                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(hour,setminute);
                timePickerDialog.show();
            }
        });









        MaterialDatePicker.Builder date = MaterialDatePicker.Builder.datePicker();
        date.setTitleText("Select A Date");
        MaterialDatePicker materialDatePicker = date.build();

        datepickerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                materialDatePicker.show(getSupportFragmentManager(), tag);

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                selected_date.setText("Selected Date : "+materialDatePicker.getHeaderText());

            }
        });

    }


}