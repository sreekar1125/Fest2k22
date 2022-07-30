package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class SportsActivity extends AppCompatActivity {
    private ImageButton cricket, kabaddi, khokho, vollyBall, footBall, throwBall, running, relay, shotput, highjump, longjump, discusThrow, jalven, carrom, chess, tt, badminton, tenniKoit;
    private String title;
    private FirebaseFirestore db;
    private ImageView img;
    private String imgUrl;
    private TextView titleTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_sports);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        img = (ImageView) findViewById(R.id.imageView);
        cricket = (ImageButton) findViewById(R.id.cricket);
        kabaddi = (ImageButton) findViewById(R.id.kabaddi);
        khokho = (ImageButton) findViewById(R.id.khokho);
        vollyBall = (ImageButton) findViewById(R.id.vollyball);
        footBall = (ImageButton) findViewById(R.id.football);
        running = (ImageButton) findViewById(R.id.running);
        relay = (ImageButton) findViewById(R.id.relay);
        shotput = (ImageButton) findViewById(R.id.shortput);
        highjump = (ImageButton) findViewById(R.id.highjump);
        longjump = (ImageButton) findViewById(R.id.longjump);
        discusThrow = (ImageButton) findViewById(R.id.discusthrow);
        jalven = (ImageButton) findViewById(R.id.javelin);
        carrom = (ImageButton) findViewById(R.id.carrom);
        chess = (ImageButton) findViewById(R.id.chess);
        tt = (ImageButton) findViewById(R.id.tt);
        badminton = (ImageButton) findViewById(R.id.badminton);
        tenniKoit = (ImageButton) findViewById(R.id.tenni);

        imgUrl = "https://archive.org/download/all_sports_2016-2017-01-10-15-59-40-cache/all_sports_2016-2017-01-10-15-59-40-cache.png";

        Glide.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(img);

        //Indoor
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Findoor%2Fcarroms.png?alt=media&token=5e72fbc0-b49f-4f4d-b17f-c20adcb2ae4f")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(carrom);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Findoor%2Fchess.png?alt=media&token=496da5f5-1880-4d06-9442-cfc56344c400")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(chess);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Findoor%2Ftable%20tennis.png?alt=media&token=308f3197-ba28-4df3-a7ea-b22c19981589")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(tt);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Findoor%2Fbatmintion.png?alt=media&token=b1e5c6bc-db66-440c-b1e4-86b3c62f4323")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(badminton);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Findoor%2Ftennis%20koti.png?alt=media&token=bad3cb05-2ce2-45dc-8fbf-9a73ff29eab7")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(tenniKoit);


        //Atheletics
        Glide.with(this)
                .load("https://png.pngtree.com/png-clipart/20190604/original/pngtree-people-running-png-image_1220317.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(running);

        Glide.with(this)
                .load("https://png.pngtree.com/png-clipart/20190614/original/pngtree-relay-race-run-race-break-out-png-image_3795259.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(relay);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Fathlatics%2Fshortput.png?alt=media&token=5201e8eb-a18e-40d2-99ed-4445434fc53c")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(shotput);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Fathlatics%2Fhigh%20jump.png?alt=media&token=1c7d4ae4-0ef2-45cf-9fad-3dbbb4def79e")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(highjump);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Fathlatics%2Flong%20jump.png?alt=media&token=16d93c40-a14c-4847-b8a8-4cce8373977c")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(longjump);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Fathlatics%2Fdiscus.png?alt=media&token=becb764e-473b-4156-919b-61ad5fba18d5")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(discusThrow);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Fathlatics%2Fjavelin1.png?alt=media&token=d5cde42b-48b1-4e95-bb49-02de7f24ecca")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(jalven);


        //OutDoor

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Foutdoor%2Fcricket.png?alt=media&token=07b09119-b79e-4831-b1e2-c864fd31d635")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(cricket);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Foutdoor%2Fkabaddi%201.png?alt=media&token=abb880c5-9119-47ae-a084-6538936fb2a5")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(kabaddi);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Foutdoor%2Fkho%20kho.png?alt=media&token=b679ac0b-ab49-472a-aaea-3c79231e64b8")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(khokho);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Foutdoor%2Fvolleyball.png?alt=media&token=7313db49-d7be-4714-b552-fc77acb67a02")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(vollyBall);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/sports%2Foutdoor%2Ffootball2.png?alt=media&token=acd44126-03dc-41fb-9c29-c60d736d6b7d")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(footBall);

    }
}