package com.example.multipurposeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Music extends AppCompatActivity {
    Button b1,b2,b3;
    MediaPlayer m1;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        getWindow().setBackgroundDrawableResource(R.drawable.mp1);
        b1=(Button)findViewById(R.id.buttonM);
        b2=(Button)findViewById(R.id.buttonM2);
        b3=(Button)findViewById(R.id.buttonM3);
        i1=(ImageView)findViewById(R.id.imageViewM);
        m1=MediaPlayer.create(this,R.raw.a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.start();
                i1.setImageResource(R.drawable.a);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.pause();
                i1.setImageResource(R.drawable.mu);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.pause();
                Intent i= new Intent(Music.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}