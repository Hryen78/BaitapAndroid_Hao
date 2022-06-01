package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailCountry extends AppCompatActivity {

    private TextView countryname;
    private TextView countrycode;
    private TextView currencycode;
    private TextView capital;
    private TextView population;
    private TextView area;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);
        Country c = new Country();
        c = (Country) getIntent().getSerializableExtra("Detail");

        String km2 = " km\u00B2";
        int n =  Integer.parseInt(c.getPopulation());
        String temp = NumberFormat.getNumberInstance(Locale.getDefault()).format(n);

        countryname = findViewById(R.id.countryname);
        countrycode = findViewById(R.id.countrycode);
        currencycode = findViewById(R.id.currencycode);
        capital = findViewById(R.id.capital);
        population = findViewById(R.id.population);
        area = findViewById(R.id.area);
        imageView = findViewById(R.id.map);
        countryname.setText(c.getCountryName());
        countrycode.setText("Country Code :"+c.getCountryCode());
        currencycode.setText("Country Currency :"+c.getCurrencyCode());
        capital.setText("Country Cappital :"+c.getCapital());
        population.setText("Country Population: "+temp);
        area.setText("Country Acreage: "+c.getArea()+km2);
        String url = "http://img.geonames.org/img/country/250/"+c.getCountryCode()+".png";

        Picasso.get().load(url).into(imageView);
        //Picasso.with(url).load()
    }
}