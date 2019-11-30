package com.ithb.jeffry.tourdestinationcatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView rvLocation;
    private ArrayList<Location> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("Location List");

        rvLocation = findViewById(R.id.rv_locations);
        rvLocation.setHasFixedSize(true);

        list.addAll(LocationData.getLocationData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvLocation.setLayoutManager(new LinearLayoutManager(this));
        ListLocationAdapter listLocationAdapter = new ListLocationAdapter(list);
        rvLocation.setAdapter(listLocationAdapter);

        listLocationAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Location data) {
                showLocationDetail(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent aboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(aboutIntent);
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showLocationDetail(Location location){
        Intent locationDetailIntent = new Intent(MainActivity.this, Detail.class);
        locationDetailIntent.putExtra(Detail.EXTRA_POSITION, location.getPosition());
        locationDetailIntent.putExtra(Detail.EXTRA_PHOTO, location.getPhoto());
        locationDetailIntent.putExtra(Detail.EXTRA_NAME, location.getName());
        locationDetailIntent.putExtra(Detail.EXTRA_SHORTDESC, location.getShortDesc());
        locationDetailIntent.putExtra(Detail.EXTRA_CURRENCY, location.getCurrency());
        locationDetailIntent.putExtra(Detail.EXTRA_LANGUAGE, location.getLanguage());
        locationDetailIntent.putExtra(Detail.EXTRA_HOTEL, location.getHotelPriceRange());
        locationDetailIntent.putExtra(Detail.EXTRA_FLIGHT, location.getFlightDurationPrice());
        locationDetailIntent.putExtra(Detail.EXTRA_FACTS, location.getFunFact());
        locationDetailIntent.putExtra(Detail.EXTRA_DETAIL, location.getDetail());
        startActivity(locationDetailIntent);
    }
}
