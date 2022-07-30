package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CollegeActivity extends AppCompatActivity {

    ImageView clg;
    TextView clgTv, contactTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_college);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        clg = (ImageView) findViewById(R.id.clgIv);
        clgTv = (TextView) findViewById(R.id.clgTv);
        contactTv = (TextView) findViewById(R.id.clgCTv) ;

        Picasso.get()
                .load("https://jntuhcesfdp.in/slider_files/images/bc1/5.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(clg);

        String text = "\tJNTUH University College of Engineering Sultanpur (JNTUH UCES or JNTS) is a university, focusing on engineering, located in Sultanpur(V), Pulkal(M), Sangareddy (D), Telangana, India. Founded in 2012.\n A new milestone in the history of Jawaharlal Nehru Technological University Hyderabad is the beginning of another Constituent Engineering College situated at Sultanpur in Medak District from the Academic Year 2012-13." +
                "\n\n Branches : "+
                "CSE \t ECE \t ME \t CE";

        String contact = "\t Sultanpur(Vill), Pulkal(Mdl),\n" +
                "Sangareddy(Dist),\n" +
                "Telangana-502273\n" +
                "Principal Office Ph:- 9492073840, 8332994977\n" +
                "Email:- principaljntuhces@gmail.com";


        clgTv.setText(text);
        contactTv.setText(contact);
    }
}