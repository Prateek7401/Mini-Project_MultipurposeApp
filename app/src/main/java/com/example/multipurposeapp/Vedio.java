package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Vedio extends AppCompatActivity {
    Button b1;
    VideoView v1;
    MediaController m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        getWindow().setBackgroundDrawableResource(R.drawable.si1);
        b1=(Button)findViewById(R.id.buttonVE3);
        v1=(VideoView)findViewById(R.id.videoViewVE);
        m1=new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.p);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.pause();
                Intent i = new Intent(Vedio.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}