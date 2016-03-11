package com.example.troyporter.troysfirstapp;

import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class SurveyActivity extends AppCompatActivity {

    private TextView mSurveyQuestionTextView;
    private Button mYesButton;
    private Button mNoButton;
    private Button mSkipButton;


    //SharedPreferences sharedPref = getSharedPreferences(
      //      getString(R.string.userProfilePreferences), Context.MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedPref.edit();

    //Array of the questions we will ask the User
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.survey_question_children),
            new Question(R.string.survey_question_employed),
            new Question(R.string.survey_question_disabled),
            new Question(R.string.survey_question_citizenship)
    };

    //Array of keys for our Shared Preferences
    private String[] preferenceNames= new String[]{
        "children", "employed", "disabled", "citizenship"
    };

    //Function to update User's SharedPref, based on their answers
    private void recordSurveyAnswer(int questionNumber, int answer)
    {
        String key = preferenceNames[questionNumber];
       // editor.putInt(key, answer);
       // editor.apply();

    }

    private int mCurrentIndex = 0; //Variable to track which question User is currently viewing

    //Iterate to the next question
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestionTextResID();
        mSurveyQuestionTextView.setText(question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //This button was programmed automatically by Android Studio. Feel free to delete/modify. -Troy
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mSurveyQuestionTextView = (TextView) findViewById(R.id.survey_question_text_view);

        // ---------------------- YES BUTTON ------------------------------------------//
        mYesButton = (Button) findViewById(R.id.survey_yes_button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordSurveyAnswer(mCurrentIndex,2);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        // -----------------------------------------------------------------------------//

        // ---------------------- NO BUTTON ------------------------------------------//
        mNoButton = (Button) findViewById(R.id.survey_no_button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordSurveyAnswer(mCurrentIndex,0);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        // -----------------------------------------------------------------------------//

        // ---------------------- SKIP BUTTON ------------------------------------------//
        mSkipButton = (Button) findViewById(R.id.survey_skip_button);
        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordSurveyAnswer(mCurrentIndex,1);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        // -----------------------------------------------------------------------------//


        //After setup, display the first question
        updateQuestion();
    }
}

