package com.example.multipurposeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginOffline extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_offline);
        getWindow().setBackgroundDrawableResource(R.drawable.offlinelogin);
        b1=(Button)findViewById(R.id.buttonO);
        b2=(Button)findViewById(R.id.buttonO2);
        b3=(Button)findViewById(R.id.buttonO5);
        e1=(EditText)findViewById(R.id.editTextO);
        e2=(EditText)findViewById(R.id.editTextO2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginOffline.this,Offline.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k= new Intent(LoginOffline.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.isEmpty()) {
                    e1.setError("Please Enter Username");
                }else if(s2.isEmpty()) {
                    e2.setError("Please Enter Password");
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("rohit",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar,username varchar,email varchar,password varchar)");
                    String s3="select * from student where username='"+s1+"' and password='"+s2+"'";
                    Cursor c1=sql.rawQuery(s3,null);
                    if(c1.getCount()>0){
                        Intent j= new Intent(LoginOffline.this,Menu.class);
                        startActivity(j);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginOffline.this, "Invalid name or Email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}