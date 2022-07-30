package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class DevActivity extends AppCompatActivity {

    ImageView s, p, n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_dev);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);



        s = (ImageView) findViewById(R.id.vskIv);
        p = (ImageView) findViewById(R.id.pranayIv);
        n = (ImageView) findViewById(R.id.nithinIv);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/developers%2Fvsk.jpg?alt=media&token=97bd2d7e-155b-4814-881a-6f412d2c7ec9")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(s);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/developers%2Fpranay.jpeg?alt=media&token=cd7f2e38-b2e7-4ddb-a825-254bef0634c0")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(p);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/developers%2Fnithin.jpeg?alt=media&token=5a318e27-b8cd-4a3b-ad7d-c0af4ad72dd5")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(n);
    }
    public void btnClicked(View view){
        switch (view.getId()){
            case R.id.pranay:
                Intent viewIntent1 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/in/pranaykumark21"));
                startActivity(viewIntent1);
                break;
            case R.id.vsk:
                Intent viewIntent2 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/in/sreekar-vangara-328a851a5/"));
                startActivity(viewIntent2);
                break;
            case R.id.nithin:
                Intent viewIntent3 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/in/nithin-bakkuri-a516b222b"));
                startActivity(viewIntent3);
                break;
        }
    }
}