package com.example.multipurposeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GmailLogin extends AppCompatActivity {
    ImageButton b1;
    Button i1;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_login);
        getWindow().setBackgroundDrawableResource(R.drawable.gmloginjpg);
        i1=(Button)findViewById(R.id.buttonGmail);
        b1 = (ImageButton)findViewById(R.id.imageButtonG);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GmailLogin.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("87318365535-f7rb27lj8bi586gti101agffprloa2d8.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(GmailLogin.this, googleSignInOptions);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = googleSignInClient.getSignInIntent();
                startActivityForResult(i, 100);
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            Intent j = new Intent(GmailLogin.this, Menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(j);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100)
        {
            Task<GoogleSignInAccount>signInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful())
            {
                Toast.makeText(this,"SignIn Successfully",Toast.LENGTH_SHORT).show();

                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount != null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (signInAccountTask.isSuccessful()) {
                                    Toast.makeText(GmailLogin.this, "Data Updated", Toast.LENGTH_SHORT).show();
                                    Intent j = new Intent(GmailLogin.this, Menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(j);
                                }
                            }
                        });
                    }
                }catch (ApiException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}