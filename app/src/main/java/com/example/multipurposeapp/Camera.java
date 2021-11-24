package com.example.multipurposeapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Camera extends AppCompatActivity {

    Button b1,b2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getWindow().setBackgroundDrawableResource(R.drawable.cp);
        b1=(Button)findViewById(R.id.buttonCA);
        b2=(Button)findViewById(R.id.buttonCA2);
        i1=(ImageView)findViewById(R.id.imageViewCA);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(Camera.this,Menu.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10){
            Bitmap bp=(Bitmap)data.getExtras().get("data");
            i1.setImageBitmap(bp);
        }else {
            Toast.makeText(Camera.this, "Not Capture Photo", Toast.LENGTH_SHORT).show();
        }
    }
}