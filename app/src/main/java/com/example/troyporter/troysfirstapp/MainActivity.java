package com.example.troyporter.troysfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "messageToDebug: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "onCreate");

        //User Navigation to other Activities
        Button mentorButton = (Button)findViewById(R.id.mentorButton);
        mentorButton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                startActivity(new Intent(MainActivity.this, MentorActivity.class));
                                            }
                                        }
        );

        Button surveyButton = (Button)findViewById(R.id.surveyButton);
        surveyButton.setOnClickListener(new View.OnClickListener(){
                                            public void onClick(View v){
                                                startActivity(new Intent(MainActivity.this, SurveyActivity.class));
                                            }
                                        }
        );

        Button articlesButton = (Button)findViewById(R.id.articlesButton);
        articlesButton.setOnClickListener(new View.OnClickListener(){
                                            public void onClick(View v){
                                                startActivity(new Intent(MainActivity.this, ArticlesActivity.class));
                                            }
                                        }
        );

        Button logInButton = (Button)findViewById(R.id.logInButton);
        logInButton.setOnClickListener(new View.OnClickListener(){
                                              public void onClick(View v){
                                                  startActivity(new Intent(MainActivity.this, LogInActivity.class));
                                              }
                                          }
        );

        //Android put this in by default.  Anybody, remove it if you want.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //These overrides are just helping us understand when each stage of the activity lifecycle occurs.
    //Eventually, we should delete these, before we submit project.  But, probably o.k. to leave here for now.
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
        }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
        }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
