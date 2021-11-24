package com.example.multipurposeapp;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Bluetooth extends AppCompatActivity {

    ImageButton i1;
    Button b1;
    BluetoothAdapter ba;
    private boolean blue=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        getWindow().setBackgroundDrawableResource(R.drawable.blu1);
        b1=(Button)findViewById(R.id.buttonB);
        i1=(ImageButton)findViewById(R.id.imageButtonB);
        ba=BluetoothAdapter.getDefaultAdapter();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Bluetooth.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blue==false){
                    ba.enable();
                    blue=true;
                    i1.setImageResource(R.drawable.o);
                }else{
                    ba.disable();
                    blue=false;
                    i1.setImageResource(R.drawable.r);

                }
            }
        });
    }
}