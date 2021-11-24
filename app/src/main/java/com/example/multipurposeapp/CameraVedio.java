package com.example.multipurposeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CameraVedio extends AppCompatActivity {
    Button b1,b2;
    Uri u1;
    MediaController m1;
    VideoView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_vedio);
        getWindow().setBackgroundDrawableResource(R.drawable.videocamerabackground);
        b1=(Button)findViewById(R.id.buttonCV);
        b2=(Button)findViewById(R.id.buttonCV2);
        v1=(VideoView)findViewById(R.id.videoViewCV);
        m1=new MediaController(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.pause();
                Intent i= new Intent(CameraVedio.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(j,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            u1=data.getData();
            v1.setVideoURI(u1);
            m1.setAnchorView(v1);
            v1.setMediaController(m1);
            v1.start();
        }else {
            Toast.makeText(this, "Please Capture Vedio", Toast.LENGTH_SHORT).show();
        }
    }
}