package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    FirebaseDatabase fd;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getWindow().setBackgroundDrawableResource(R.drawable.feedback1);
        e1=(EditText)findViewById(R.id.editTextF);
        e2=(EditText)findViewById(R.id.editTextF2);
        e3=(EditText)findViewById(R.id.editTextF3);
        e4=(EditText)findViewById(R.id.editTextF4);
        e5=(EditText)findViewById(R.id.editTextF5);
        b1=(Button)findViewById(R.id.buttonF);
        b2=(Button)findViewById(R.id.buttonF2);
        fd=FirebaseDatabase.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr= fd.getReference("users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                if(s4.length()!=10){
                    Toast.makeText(Feedback.this, "Invalid Number", Toast.LENGTH_SHORT).show();
                }else{
                    users users=new users(s1,s2,s3,s4,s5);
                    dr.child(s4).setValue(users);
                    Toast.makeText(Feedback.this, "Database Save", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Feedback.this,Menu.class);
                startActivity(i);
                finish();
            }
        });


    }
}
