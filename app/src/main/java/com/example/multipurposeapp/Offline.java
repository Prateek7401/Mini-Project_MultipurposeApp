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

public class Offline extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        getWindow().setBackgroundDrawableResource(R.drawable.op1);
        b1=(Button)findViewById(R.id.buttonO3);
        b2=(Button)findViewById(R.id.buttonO4);
        e1=(EditText)findViewById(R.id.editTextO3);
        e2=(EditText)findViewById(R.id.editTextO4);
        e3=(EditText)findViewById(R.id.editTextO5);
        e4=(EditText)findViewById(R.id.editTextO6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Offline.this,LoginOffline.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if(s1.isEmpty()) {
                    e1.setError("Please Enter Name");
                }else if(s2.isEmpty()){
                    e2.setError("Please Enter Username");
                }else if(s3.isEmpty()){
                    e3.setError("Please Enter Email ID");
                }else if(s4.isEmpty()){
                    e4.setError("Please Enter Password");
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("rohit",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student(name varchar,username varchar,email varchar,password varchar)");
                    String s5="select * from student where username='"+s2+"' and password='"+s4+"'";
                    Cursor c1= sql.rawQuery(s5,null);
                    if(c1.getCount()>0){
                        Toast.makeText(Offline.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                    }else{
                        sql.execSQL("insert into student values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                        Toast.makeText(Offline.this, "Registration Done!!", Toast.LENGTH_SHORT).show();
                        Intent j= new Intent(Offline.this,LoginOffline.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });

    }
}