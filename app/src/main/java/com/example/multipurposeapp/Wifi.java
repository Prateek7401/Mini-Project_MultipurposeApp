package com.example.multipurposeapp;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Wifi extends AppCompatActivity {
    Button b1,b2,b3;
    ImageView i1;
    WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        getWindow().setBackgroundDrawableResource(R.drawable.wifi);
        b1=(Button)findViewById(R.id.buttonW);
        b2=(Button)findViewById(R.id.buttonW2);
        b3=(Button)findViewById(R.id.buttonW3);
        i1=(ImageView)findViewById(R.id.imageViewW);
        wm=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(false);
                i1.setImageResource(R.drawable.woff);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(true);
                i1.setImageResource(R.drawable.wo);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Wifi.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}