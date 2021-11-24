package com.example.multipurposeapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Message extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    String phoneNo;
    String message;
    private static final int PERMISSION_RQST_SEND = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getWindow().setBackgroundDrawableResource(R.drawable.sms);
        b1=(Button)findViewById(R.id.buttonME);
        b2=(Button)findViewById(R.id.buttonME2);
        e1=(EditText)findViewById(R.id.editTextME);
        e2=(EditText)findViewById(R.id.editTextME2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Message.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendSMSMessage();
                }
            });
        }
        protected void sendSMSMessage() {
            phoneNo = e1.getText().toString();
            message = e2.getText().toString();

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(Message.this, Manifest.permission.SEND_SMS)) {
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_RQST_SEND);
                }
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_RQST_SEND);
            }
        }
        @Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case PERMISSION_RQST_SEND: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        SmsManager sm = SmsManager.getDefault();
                        sm.sendTextMessage(phoneNo, null, message, null, null);
                        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "SMS failed, you may try again later.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        }
    }