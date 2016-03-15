package com.example.troyporter.troysfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.content.Context;


public class NavigationBarFragment extends Fragment{

    private Context parentActivityContext;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //Keep a record of which activity we are nested inside of
        parentActivityContext = context;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        //We are leaving this activity, so we can remove our record of this activity
        parentActivityContext = null;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_bar_fragment, container, false);

        //Declare all buttons
        final Button homeButton = (Button) view.findViewById(R.id.navBarButton_home);
        final Button forumButton = (Button) view.findViewById(R.id.navBarButton_forum);
        final Button mentorButton = (Button) view.findViewById(R.id.navBarButton_mentors);
        final Button articlesButton= (Button) view.findViewById(R.id.navBarButton_articles);
        final Button profileButton= (Button) view.findViewById(R.id.navBarButton_userProfile);

        //Set all Listeners for the buttons using our saved context of current activity
        homeButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              startActivity(new Intent(parentActivityContext, MainActivity.class));
                                          }
                                      }
        );

        forumButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              //We don't have Forum Activity yet, so this links back to home for now.
                                              //This should be corrected when we have Forum ready.
                                              startActivity(new Intent(parentActivityContext, MainActivity.class));
                                          }
                                      }
        );

        mentorButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              startActivity(new Intent(parentActivityContext, MentorActivity.class));
                                          }
                                      }
        );

        articlesButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              startActivity(new Intent(parentActivityContext, ArticlesActivity.class));
                                          }
                                      }
        );

        profileButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              startActivity(new Intent(parentActivityContext, ProfileActivity.class));
                                          }
                                      }
        );

        return view;

    }
}
