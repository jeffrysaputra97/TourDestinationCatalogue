package com.ithb.jeffry.tourdestinationcatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_SHORTDESC = "extra_shortdesc";
    public static final String EXTRA_CURRENCY = "extra_currency";
    public static final String EXTRA_LANGUAGE = "extra_language";
    public static final String EXTRA_HOTEL = "extra_hotel";
    public static final String EXTRA_FLIGHT = "extra_flight";
    public static final String EXTRA_FACTS = "extra_facts";
    public static final String EXTRA_DETAIL = "extra_detail";

    private RecyclerView rvLocation;
    private ArrayList<Location> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle("Details");

        ImageView imgLocationPhoto = findViewById(R.id.detail_img_item_photo);
        TextView tvLocationName = findViewById(R.id.detail_tv_location_name);
        TextView tvLocationShortDesc = findViewById(R.id.detail_tv_location_shortdesc);
        TextView tvLocationCurrency = findViewById(R.id.detail_tv_currency_content);
        TextView tvLocationLanguage = findViewById(R.id.detail_tv_language_content);
        TextView tvLocationHotelPrice = findViewById(R.id.detail_tv_hotel_pricerange);
        TextView tvLocationFlight = findViewById(R.id.detail_tv_flight_durationprice);
        TextView tvLocationFact = findViewById(R.id.detail_tv_location_fact);
        TextView tvLocationDetail = findViewById(R.id.detail_tv_location_detail);

        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);
        String imgUrl = getIntent().getStringExtra(EXTRA_PHOTO);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String shortDesc = getIntent().getStringExtra(EXTRA_SHORTDESC);
        String currency = getIntent().getStringExtra(EXTRA_CURRENCY);
        String language = getIntent().getStringExtra(EXTRA_LANGUAGE);
        String hotel = getIntent().getStringExtra(EXTRA_HOTEL);
        String flight = getIntent().getStringExtra(EXTRA_FLIGHT);
        String fact = getIntent().getStringExtra(EXTRA_FACTS);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);

        Glide.with(getApplicationContext())
                .load(imgUrl)
                .apply(new RequestOptions().override(640,480))
                .into(imgLocationPhoto);

        tvLocationName.setText(name);
        tvLocationShortDesc.setText(shortDesc);
        tvLocationCurrency.setText(currency);
        tvLocationLanguage.setText(language);
        tvLocationHotelPrice.setText(hotel);
        tvLocationFlight.setText(flight);
        tvLocationFact.setText(fact);
        tvLocationDetail.setText(detail);

        rvLocation = findViewById(R.id.cardview_locations);
        rvLocation.setHasFixedSize(true);

        list.addAll(LocationData.getSelectedLocationData(position));
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvLocation.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CardViewLocationAdapter cardViewLocationAdapter= new CardViewLocationAdapter(list);
        rvLocation.setAdapter(cardViewLocationAdapter);

        cardViewLocationAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Location data) {
                showLocationDetail(data);
            }
        });
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showLocationDetail(Location location){
        Intent locationDetailIntent = new Intent(Detail.this, Detail.class);
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
