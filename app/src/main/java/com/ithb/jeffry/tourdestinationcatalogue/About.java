package com.ithb.jeffry.tourdestinationcatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setActionBarTitle("About");
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
