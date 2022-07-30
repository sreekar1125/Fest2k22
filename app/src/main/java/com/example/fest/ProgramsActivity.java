package com.example.fest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

public class ProgramsActivity extends AppCompatActivity {

    private ImageView sports, cultural, technical, stall, flash, athletics, live, awards;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_programs);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        sports = (ImageView) findViewById(R.id.sports);
        cultural = (ImageView) findViewById(R.id.cultural);
        technical = (ImageView) findViewById(R.id.technical);
        stall = (ImageView) findViewById(R.id.stall);
        flash = (ImageView) findViewById(R.id.flash);
        athletics = (ImageView) findViewById(R.id.athletics);
        live = (ImageView) findViewById(R.id.livestream);
        awards = (ImageView) findViewById(R.id.awards);

        Picasso.get()
                .load("https://archive.org/download/all_sports_2016-2017-01-10-15-59-40-cache/all_sports_2016-2017-01-10-15-59-40-cache.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(sports);


        Picasso.get()
                .load("https://mesacountylibraries.org/wp-content/uploads/2018/08/Culture-Fest-Logo-square-png.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(cultural);

        Picasso.get()
                .load("https://pluspng.com/img-png/technology-png-tech-icon-1030.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(technical);

        Picasso.get()
                .load("https://cdn1.iconfinder.com/data/icons/farm-flat/64/stall-store-market-512.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(stall);

        Picasso.get()
                .load("https://www.romecentral.com/wp-content/uploads/2014/09/flashmob_logo.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(flash);

        Picasso.get()
                .load("https://www.pngarts.com/files/4/Athlete-PNG-Download-Image.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(athletics);

        Picasso.get()
                .load("https://healthcaremsoconference.com/wp-content/uploads/2019/09/livestream-icon_v2_700-white-450x341.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(live);

        Picasso.get()
                .load("https://www.pngall.com/wp-content/uploads/5/Ribbon-Award-PNG.png")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(awards);

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SportsActivity.class);
                intent.putExtra("title" , "Sports");
                startActivity(intent);
            }
        });

    }

}