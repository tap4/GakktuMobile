package com.example.troyporter.troysfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class ProfileActivity extends AppCompatActivity {

    private TextView mUserPreferenceChildrenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserPreferenceChildrenTextView = (TextView) findViewById(R.id.user_pref_children_view);

        //----Get the User's Profile Preferences from SharedPreferences File and display on screen---//
        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.userProfilePreferences), Context.MODE_APPEND);
        int childPrefValue =  sharedPref.getInt("children", 1);
        mUserPreferenceChildrenTextView.setText(String.valueOf(childPrefValue));
        //-------------------------------------------------------------------------------------//

        //Android put this here.  We can delete later if we dont want it.
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
