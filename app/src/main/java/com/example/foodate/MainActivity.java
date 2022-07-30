package com.example.foodate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //req to no title option
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hide title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        //access video from resources
        Uri video = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.splash);
        videoView.setVideoURI(video);

        videoView.start();
        //goes to next activity
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                StartNextActivity();
            }
        });

    }
    // method to call next activity
    private  void  StartNextActivity()
    {
        if (isFinishing())
        return;
        startActivity(new Intent(MainActivity.this, GetStarted.class));
        //will exit app when user press back in  GetStarted screen
        finish();

    }

    }
