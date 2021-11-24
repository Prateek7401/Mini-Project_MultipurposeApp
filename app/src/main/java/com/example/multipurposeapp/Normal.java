package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

public class Normal extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        getWindow().setBackgroundDrawableResource(R.drawable.menu1);
        b1=(Button)findViewById(R.id.buttonN3);
        b2=(Button)findViewById(R.id.buttonN4);
        e1=(EditText)findViewById(R.id.editTextN3);
        e2=(EditText)findViewById(R.id.editTextN4);
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        p1=(ProgressBar)findViewById(R.id.progressBarN2);
        firebaseAuth=FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Normal.this,NormalLogin.class);
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
                                          if(s2.isEmpty()) {
                                              e2.setError("Please Fill Password");
                                              return;
                                          }
                                      }
                firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Normal.this, "Data Updated", Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.VISIBLE);
                            Intent j=new Intent(Normal.this,NormalLogin.class);
                            startActivity(j);
                            finish();
                        }else{
                            Toast.makeText(Normal.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}