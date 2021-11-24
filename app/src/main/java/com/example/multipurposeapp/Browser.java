package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Browser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1,b2;
        WebView wb;
        EditText e1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        getWindow().setBackgroundDrawableResource(R.drawable.google_search);
        b1=(Button)findViewById(R.id.buttonBR);
        b2=(Button)findViewById(R.id.buttonBR2);
        e1=(EditText)findViewById(R.id.editTextBR);
        wb=(WebView)findViewById(R.id.webViewBR);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                wb.loadUrl(s1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Browser.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}