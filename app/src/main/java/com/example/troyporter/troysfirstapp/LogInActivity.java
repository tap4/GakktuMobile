package com.example.troyporter.troysfirstapp;
//package com.example.testSingleton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


//import org.apache.http.client.methods.HttpGet;


/*ATTN: Code Reviewers.  This is a work in progress. We are troubleshooting an API connection
to our Server.  Please ignore any large chunks of commented-out code.  Sorry for the mess!
 */

public class LogInActivity extends AppCompatActivity {

    //final TextView mTextView = (TextView) findViewById(R.id.textView4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                "http://127.0.0.1:8000/categories/",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText("Response is: " + response.substring(0,500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                mTextView.setText("That didnt work!");
            }
        });
        //Add the request to the RequestQueue
        queue.add(stringRequest);
        */

        final TextView mTxtDisplay;
        //ImageView mImageView;
        mTxtDisplay = (TextView) findViewById(R.id.textView4);
        String url = "http://127.0.0.1:8000/categories/";
/*
        protected void initSingletons()
    {
        MySingleton.initInstance();
    }
    */
/*
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>(){

                    @Override
                public void onResponse(JSONObject response){
                        mTxtDisplay.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener(){
                    @Override
                public void onErrorResponse (VolleyError error){
                        mTxtDisplay.setText("Error: " + error.toString());
                    }
                });

        //Access the REquestGueue thru singleton class
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
*/

        //This button was programmed automatically by Android Studio. Feel free to delete/modify.
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
