package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FestActivity extends AppCompatActivity {

    TextView yugaTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_fest);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        yugaTv = (TextView) findViewById(R.id.yugaTv);

        String yuga = "\tYUGA 2022 is the annual Techno-Cultural festival of the JNTUH College Of Engineering Sultanpur, Department of Computer Science and Engineering. Started in 2013 with the aim of providing a platform for the Indian student community to develop and showcase their technical prowess. A grand three-day event on the campus of JNTUHCES attracts people from all walks of life including students, academicians, professionals, and the general public.\n" +
                "\n\tYear after year, YUGA explores the various aspects of technology and the profound impacts it has on our lives. For the last 7 years, YUGA has constantly grown, evolved, and pushed the boundaries of what a college fest can be. With something to offer for everyone. Our 3-day festival gives any guest an exhilarating experience, ranging from challenging hackathons to sit-back-and-relax entertainment shows.\n" +
               "\n\tYUGA 2020 is the ideal destination for all techno-culturophiles: young or old, beginner or expert, student or professional to witness, learn and experience the wonders of technology.\n" +
                "\n\tThe fest is scheduled for the 25th, 26th, and 27th of April,2022 at the beautiful, green campus of JNTUH CES in Telangana. Boasting a huge roster of exciting and engaging events, this edition of YUGA promises to be grand, greater, and more glorious than ever before.\n" +
                "\n\tCome and be part of this exemplare fiesta, which is a coalescence of creativity, bliss, and amusement.";


        yugaTv.setText(yuga);
    }
}