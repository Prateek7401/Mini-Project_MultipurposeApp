package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class OtpLogin extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_login);
        getWindow().setBackgroundDrawableResource(R.drawable.oq1);
        b1=(Button)findViewById(R.id.buttonOT);
        b2=(Button)findViewById(R.id.buttonOT3);
        e1=(EditText)findViewById(R.id.editTextOT);
        ccp=(CountryCodePicker)findViewById(R.id.cpp);
        ccp.registerCarrierNumberEditText(e1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(OtpLogin.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()) {
                    e1.setError("Please Enter Number");
                    Toast.makeText(OtpLogin.this, "Enter Number", Toast.LENGTH_SHORT).show();
                }
                else if(e1.getText().toString().length()!=10) {
                    e1.setError("Invalid Number");
                    Toast.makeText(OtpLogin.this, "Enter Valid Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(OtpLogin.this, Otp.class);
                    i.putExtra("Mobile", ccp.getFullNumberWithPlus().trim());
                    startActivity(i);
                }
            }
        });
    }
}