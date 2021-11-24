package com.example.multipurposeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Call extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        getWindow().setBackgroundDrawableResource(R.drawable.call_now_background);
        e1=(EditText)findViewById(R.id.editTextP);
        b1=(Button)findViewById(R.id.buttonP);
        b2=(Button)findViewById(R.id.buttonP2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Call.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    Toast.makeText(Call.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + s1));
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}