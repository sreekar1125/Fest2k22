package com.example.fest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BrochureActivity extends AppCompatActivity {

    ImageView b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_brochure);

        b1 = (ImageView) findViewById(R.id.brochure1);
        b2 = (ImageView) findViewById(R.id.brochure2);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/Brouchers%2Fcse%2Fbrochure1.png?alt=media&token=97ff8568-4d38-4be5-889a-07b9fcdeca31")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(b1);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/fest-3a1de.appspot.com/o/Brouchers%2Fcse%2Fbrochure2.png?alt=media&token=8da065a6-2368-4074-a3a3-8192a31181ae")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(b2);
    }
}