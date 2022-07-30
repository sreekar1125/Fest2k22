package com.example.fest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

//import im.delight.android.webview.AdvancedWebView;

public class MainActivity extends AppCompatActivity {

    private ImageButton programsIb, scheduleIb, galleryIb, registerIb;

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Intent intent;
    private VideoView videoView;
    private String videoUri, programsUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_main);


        programsIb = (ImageButton) findViewById(R.id.programs);
        scheduleIb = (ImageButton) findViewById(R.id.schedule);
        galleryIb = (ImageButton) findViewById(R.id.gallery);
        registerIb = (ImageButton) findViewById(R.id.register);
        videoView = (VideoView) findViewById(R.id.video);



        //Video
        videoUri = "https://drive.google.com/uc?id=1sQgMqpVGCqKhwcsEttrS9fLtzrXv85P8";
        Uri uri = Uri.parse(videoUri);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@androidx.annotation.NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.brochure:
                        intent = new Intent(getApplicationContext(),BrochureActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.fest:
                        intent = new Intent(getApplicationContext(),FestActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.collage:
                        intent = new Intent(getApplicationContext(),CollegeActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.coordinators:
                        intent = new Intent(getApplicationContext(),CoordActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.dev:
                        intent = new Intent(getApplicationContext(),DevActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.login:
                        intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        return true;
                }

                return true;
            }
        });

        Picasso.get()
                .load("https://trak.in/wp-content/uploads/2016/03/Registering-Business-company.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(registerIb);

        Picasso.get()
                .load("https://crimesolutions.ojp.gov/sites/g/files/xyckuh246/files/styles/card/public/images/2020-07/NIJ_Generic%20Card_960x640_Programs.jpg?itok=AZtd6CRr")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(programsIb);

        Picasso.get()
                .load("https://blog-assets.freshworks.com/freshdesk/wp-content/uploads/2020/03/05162316/Shift-schedules-1024x410.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(scheduleIb);

        Picasso.get()
                .load("https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/fe458127812043.5636b276d6b43.jpg")
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_loading_img)
                .into(galleryIb);

        programsIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ProgramsActivity.class);
                startActivity(intent);
            }
        });

        registerIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}