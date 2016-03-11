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

public class ProfileActivity extends AppCompatActivity {

    private TextView mUserPreferenceChildrenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserPreferenceChildrenTextView = (TextView) findViewById(R.id.user_pref_children_view);

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.userProfilePreferences), Context.MODE_PRIVATE);

        String childPrefValue =  sharedPref.getString("children", "test");

        mUserPreferenceChildrenTextView.setText(childPrefValue);

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
