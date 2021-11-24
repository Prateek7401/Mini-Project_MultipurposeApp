package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class NormalLogin extends AppCompatActivity {

    Button b1, b2,b3;
    EditText e1, e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_login);
        getWindow().setBackgroundDrawableResource(R.drawable.si);
        b1 = (Button) findViewById(R.id.buttonN);
        b2 = (Button) findViewById(R.id.buttonN2);
        b3=(Button)findViewById(R.id.buttonN5);
        e1 = (EditText) findViewById(R.id.editTextN);
        e2 = (EditText) findViewById(R.id.editTextN2);
        p1 = (ProgressBar) findViewById(R.id.progressBarN);
        firebaseAuth = FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NormalLogin.this, Normal.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormalLogin.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if (s1.isEmpty()) {
                    e1.setError("Please Fill Email Id");
                    return;
                } else {
                    if (s2.isEmpty()) {
                        e2.setError("Please Fill Password");
                        return;
                    }
                }
                p1.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(NormalLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent j = new Intent(NormalLogin.this, Menu.class);
                            startActivity(j);
                            finish();
                            p1.setVisibility(View.INVISIBLE);

                        } else {
                            Toast.makeText(NormalLogin.this, "Invalid Email ID or Password", Toast.LENGTH_SHORT).show();
                            Intent k = new Intent(NormalLogin.this, Normal.class);
                            startActivity(k);
                            finish();
                            p1.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });
    }
}