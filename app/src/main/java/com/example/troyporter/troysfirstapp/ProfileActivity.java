package com.example.troyporter.troysfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class ProfileActivity extends AppCompatActivity {

    private TextView mUserPreferenceChildrenTextView;
    private TextView mUserPreferenceEmployedTextView;
    private TextView mUserPreferenceDisabledTextView;
    private TextView mUserPreferenceCitizenshipTextView;

    //Array of Strings describing UserInterest Level, to display in the TextView
    private String[] interestString= new String[]{
            "Low", "Neutral", "High"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserPreferenceChildrenTextView = (TextView) findViewById(R.id.user_pref_children_view);
        mUserPreferenceEmployedTextView = (TextView) findViewById(R.id.user_pref_employed_view);
        mUserPreferenceDisabledTextView = (TextView) findViewById(R.id.user_pref_disabled_view);
        mUserPreferenceCitizenshipTextView = (TextView) findViewById(R.id.user_pref_citizenship_view);

        //----Get the User's Profile Preferences from SharedPreferences File and display on screen---//
        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.userProfilePreferences), Context.MODE_APPEND);
        int childPrefValue =  sharedPref.getInt("children", 1);
        int employedPrefValue =  sharedPref.getInt("employed", 1);
        int disabledPrefValue =  sharedPref.getInt("disabled", 1);
        int citizenshipPrefValue =  sharedPref.getInt("citizenship", 1);

        String childPrefString = interestString[childPrefValue];
        String employedPrefString = interestString[employedPrefValue];
        String disabledPrefString = interestString[disabledPrefValue];
        String citizenshipPrefString = interestString[citizenshipPrefValue];

        mUserPreferenceChildrenTextView.setText(childPrefString);
        mUserPreferenceEmployedTextView.setText(employedPrefString);
        mUserPreferenceDisabledTextView.setText(disabledPrefString);
        mUserPreferenceCitizenshipTextView.setText(citizenshipPrefString);


        //Set Text Color of ChildPreference
        if (childPrefString=="Low")
        {
            mUserPreferenceChildrenTextView.setTextColor(Color.RED);
        }
        if (childPrefString=="Neutral")
        {
            mUserPreferenceChildrenTextView.setTextColor(Color.BLUE);
        }
        if (childPrefString=="High")
        {
            mUserPreferenceChildrenTextView.setTextColor(Color.GREEN);
        }

        //Set Text Color of Employed Preference
        if (employedPrefString=="Low")
        {
            mUserPreferenceEmployedTextView.setTextColor(Color.RED);
        }
        if (employedPrefString=="Neutral")
        {
            mUserPreferenceEmployedTextView.setTextColor(Color.BLUE);
        }
        if (employedPrefString=="High")
        {
            mUserPreferenceEmployedTextView.setTextColor(Color.GREEN);
        }

        //Set Text Color of Disabled Preference
        if (disabledPrefString=="Low")
        {
            mUserPreferenceDisabledTextView.setTextColor(Color.RED);
        }
        if (disabledPrefString=="Neutral")
        {
            mUserPreferenceDisabledTextView.setTextColor(Color.BLUE);
        }
        if (disabledPrefString=="High")
        {
            mUserPreferenceDisabledTextView.setTextColor(Color.GREEN);
        }

        //Set Text Color of Citizenship Preference
        if (citizenshipPrefString=="Low")
        {
            mUserPreferenceCitizenshipTextView.setTextColor(Color.RED);
        }
        if (citizenshipPrefString=="Neutral")
        {
            mUserPreferenceCitizenshipTextView.setTextColor(Color.BLUE);
        }
        if (citizenshipPrefString=="High")
        {
            mUserPreferenceCitizenshipTextView.setTextColor(Color.GREEN);
        }

        //-------------------------------------------------------------------------------------//

        //Android put this here.  We can delete later if we don't want it.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
