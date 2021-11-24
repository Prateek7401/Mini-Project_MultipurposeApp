package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
    Button b1;
    EditText e1;
    FirebaseAuth firebaseAuth;
    String phone;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        getWindow().setBackgroundDrawableResource(R.drawable.otp);
        b1=(Button)findViewById(R.id.buttonOT2);
        e1=(EditText)findViewById(R.id.editTextOT2);
        phone=getIntent().getStringExtra("Mobile").toString();
        firebaseAuth= FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    e1.setError("Enter OTP");
                }else{
                    if(e1.getText().toString().length()!=6){
                        e1.setError("Invalid OTP");
                        Toast.makeText(Otp.this, "Fill Valid OTP", Toast.LENGTH_SHORT).show();
                    }else{
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                        SignWithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }private void genotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                        SignWithPhoneAuthCredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                        Toast.makeText(Otp.this, "NOT MAtch", Toast.LENGTH_SHORT).show();

                    }
                }

        );
    }private void SignWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Otp.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(Otp.this,Menu.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Otp.this, "Not VAlid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}