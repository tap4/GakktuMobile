package com.example.troyporter.troysfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;
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
        //We are leaving this activity, to remove our record
        parentActivityContext = null;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_bar_fragment, container, false);

        final Button homeButton = (Button) view.findViewById(R.id.navBarButton_home);
        homeButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              startActivity(new Intent(parentActivityContext, MainActivity.class));
                                          }
                                      }
        );

        return view;


    }
}
