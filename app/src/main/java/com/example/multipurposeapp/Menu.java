package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {
    ImageButton i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i33;
    Button b1;
    Vibrator v1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setBackgroundDrawableResource(R.drawable.fr);
        firebaseAuth=FirebaseAuth.getInstance();
        i1=(ImageButton)findViewById(R.id.imageButtonM);
        i2=(ImageButton)findViewById(R.id.imageButtonM2);
        i3=(ImageButton)findViewById(R.id.imageButtonM3);
        i4=(ImageButton)findViewById(R.id.imageButtonM4);
        i5=(ImageButton)findViewById(R.id.imageButtonM5);
        i6=(ImageButton)findViewById(R.id.imageButtonM6);
        i7=(ImageButton)findViewById(R.id.imageButtonM7);
        i8=(ImageButton)findViewById(R.id.imageButtonM8);
        i9=(ImageButton)findViewById(R.id.imageButtonM9);
        i10=(ImageButton)findViewById(R.id.imageButtonM10);
        i11=(ImageButton)findViewById(R.id.imageButtonM11);
        i12=(ImageButton)findViewById(R.id.imageButtonM12);
        i13=(ImageButton)findViewById(R.id.imageButtonM13);
        i33=(ImageButton) findViewById(R.id.imageButtontic);
        b1=(Button)findViewById(R.id.buttonLogout);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Menu.this,Calci.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(Menu.this,Torch.class);
                startActivity(j);
                finish();
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k= new Intent(Menu.this,Bluetooth.class);
                startActivity(k);
                finish();
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(Menu.this,Camera.class);
                startActivity(l);
                finish();
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m= new Intent(Menu.this,Music.class);
                startActivity(m);
                finish();
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT > 26) {
                    v1.vibrate(500);
                } else {
                    v1.vibrate(50);
                }
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o= new Intent(Menu.this,Browser.class);
                startActivity(o);
                finish();
            }
        });
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(Menu.this,Vedio.class);
                startActivity(p);
                finish();
            }
        });
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q= new Intent(Menu.this,Wifi.class);
                startActivity(q);
                finish();
            }
        });
        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Menu.this,CameraVedio.class);
                startActivity(r);
                finish();
            }
        });
        i11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(Menu.this,Call.class);
                startActivity(s);
                finish();
            }
        });
        i12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(Menu.this,Message.class);
                startActivity(t);
                finish();
            }
        });

        i13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(Menu.this,Feedback.class);
                startActivity(u);
                finish();
            }
        });
        i33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qz= new Intent(Menu.this,Tic_Tac1.class);
                startActivity(qz);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(Menu.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Menu.this, "Logout", Toast.LENGTH_SHORT).show();
                            firebaseAuth.signOut();
                            finish();
                        }
                        Intent i= new Intent(Menu.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });
    }
}