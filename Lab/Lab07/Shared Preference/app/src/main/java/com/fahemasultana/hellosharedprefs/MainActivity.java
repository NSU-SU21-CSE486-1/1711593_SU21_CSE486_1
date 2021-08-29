package com.fahemasultana.hellosharedprefs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Current count
    private int mCount = 0;
    // Current background color
    private int mColor;
    // Text view to display both count and color
    private TextView mShowCountTextView;

    // Key for current count
    private final String COUNT_KEY = "count";
    // Key for current color
    private final String COLOR_KEY = "color";

    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";
    private int SETTINGS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color, preferences
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mCount = mPreferences.getInt(COUNT_KEY, 0);
        mShowCountTextView.setText(String.format("%s", mCount));
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        mShowCountTextView.setBackgroundColor(mColor);
    }

    /**
     * Handles the onClick for the background color buttons.  Gets background
     * color of the button that was clicked, and sets the TextView background
     * to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    /**
     * Handles the onClick for the Count button.  Increments the value of the
     * mCount global and updates the TextView.
     *
     * @param view The view (Button) that was clicked.
     */
    public void countUp(View view) {
        mCount++;
        mShowCountTextView.setText(String.format("%s", mCount));
    }

    /**
     * Handles the onClick for the Reset button.  Resets the global count and
     * background variables to the defaults and resets the views to those
     * default values.
     *
     * @param view The view (Button) that was clicked.
     */
    public void reset(View view) {
        // Reset count
        mCount = 0;
        mShowCountTextView.setText(String.format("%s", mCount));

        // Reset color
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);

        // Clear preferences
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivityForResult(intent, SETTINGS);
    }

    /**
     * Callback for activity pause.  Shared preferences are saved here.
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SETTINGS){
            if (resultCode == RESULT_OK){
                SharedPreferences.Editor preferenceEditor = mPreferences.edit();
                switch (data.getStringExtra(SettingActivity.COLOR_KEY)){
                    case "default":
                        preferenceEditor.putInt(COLOR_KEY, getResources().getColor(R.color.default_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.default_background));
                        break;
                    case "Red":
                        preferenceEditor.putInt(COLOR_KEY, getResources().getColor(R.color.red_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.red_background));
                        break;
                    case "Blue":
                        preferenceEditor.putInt(COLOR_KEY, getResources().getColor(R.color.blue_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.blue_background));
                        break;
                    case "Green":
                        preferenceEditor.putInt(COLOR_KEY, getResources().getColor(R.color.green_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.green_background));
                        break;
                    default:
                        break;
                }
                if (data.getBooleanExtra(SettingActivity.CORRECT_COUNT, false)){
                    mCount = data.getIntExtra(SettingActivity.COUNT_KEY, 0);
                    preferenceEditor.putInt(COUNT_KEY, mCount);
                    mShowCountTextView.setText(String.format("%s", mCount));
                }
                preferenceEditor.apply();
            }
            else if (resultCode == SettingActivity.RESULT_RESET){
                SharedPreferences.Editor preferenceEditor = mPreferences.edit();
                mCount = 0;
                mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.default_background));
                preferenceEditor.putInt(COLOR_KEY, getResources().getColor(R.color.default_background));
                preferenceEditor.putInt(COUNT_KEY, mCount);
                preferenceEditor.apply();
            }
        }
    }
}