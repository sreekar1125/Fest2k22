package com.example.fest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RegisterActivity extends AppCompatActivity {

    private ImageView regIv;
    private CardView regWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        regIv = (ImageView) findViewById(R.id.regImg);
        regWork = (CardView) findViewById(R.id.regWork);

        String imageUrl = "https://static.wixstatic.com/media/dde299_260a3cef08c54a6a89a460209c4bdfe0~mv2.jpg/v1/crop/x_41,y_0,w_1000,h_1072/fill/w_700,h_750,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/SurjeethPaul_JPG.jpg";

        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(regIv);

        regWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScFtLF9ugr4PbMe45-gFiEFHgCAILJQZhMPThvzLa4QBm9UQQ/formResponse"));
                startActivity(intent);
            }
        });

    }
}