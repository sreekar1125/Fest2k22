package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CoordActivity extends AppCompatActivity {

    ImageView s, p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_coord2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        s = (ImageView) findViewById(R.id.vskIv);
        p = (ImageView) findViewById(R.id.pranayIv);
        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/coordinators%2Fcse%2Fvineel.jpeg?alt=media&token=6106e13c-7f98-4cc3-813a-d66fc3a96e33")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(s);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/coordinators%2Fcse%2Fsushma.png?alt=media&token=455bb467-bc6a-4b6f-ba24-ccfa86a33f62")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(p);

    }
    public void btnClicked(View view){
        switch (view.getId()){
            case R.id.vsk:
                Intent viewIntent1 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/in/vineel-dhinakar-jeldi-5ba861236"));
                startActivity(viewIntent1);
                break;
            case R.id.pranay:
                Intent viewIntent2 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/in/sushma-dandeboyina-ba0860236"));
                startActivity(viewIntent2);
                break;
        }
    }
}