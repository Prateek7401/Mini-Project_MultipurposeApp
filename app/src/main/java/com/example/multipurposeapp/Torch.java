package com.example.multipurposeapp;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Torch extends AppCompatActivity {
    ToggleButton t1;
    Button b1;
    CameraManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        getWindow().setBackgroundDrawableResource(R.drawable.flash);
        t1=(ToggleButton)findViewById(R.id.toggleButtonT);
        b1=(Button)findViewById(R.id.buttonT);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Torch.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try{
                    if(isChecked) {
                        String s1 = cm.getCameraIdList()[0];
                        cm.setTorchMode(s1, true);
                    }
                    else{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                    }
                }catch (CameraAccessException e){

                }
            }
        });
    }
}