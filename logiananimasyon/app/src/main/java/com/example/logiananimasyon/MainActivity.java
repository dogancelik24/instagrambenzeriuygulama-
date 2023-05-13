package com.example.logiananimasyon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    RelativeLayout r1;
    Button btn1, btn2;
    EditText kAdi, kSifre, eEmail;

    private EditText txtadi, txtsifre, txtemail;
    private Button btnkayit, btngiris;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;


    private HashMap<String, Object> mData;


    Intent intent;
    private String adi, email, sifre;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        r1 = findViewById(R.id.panelim);
        kAdi = findViewById(R.id.editTextTextPersonName);
        kSifre = findViewById(R.id.editTextTextPassword);
        eEmail = findViewById(R.id.editTextTextEmailaddress);
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.panelanim);
        img1.startAnimation(anim1);
        r1.startAnimation(anim2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txtadi = findViewById(R.id.editTextTextPersonName);
        txtemail = findViewById(R.id.editTextTextEmailaddress);
        txtsifre = findViewById(R.id.editTextTextPassword);
        btnkayit = findViewById(R.id.btn2);
        btngiris = findViewById(R.id.btn1);
        mAuth = FirebaseAuth.getInstance();


        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adi = txtadi.getText().toString();
                email = txtemail.getText().toString();
                sifre = txtsifre.getText().toString();
                if (!TextUtils.isEmpty(adi) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre)) {
                    mAuth.createUserWithEmailAndPassword(email, sifre)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(MainActivity.this, "Firebase giriş yapıldı", Toast.LENGTH_SHORT).show();
                                }
                            });
                }


            }
        });
        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adi = txtadi.getText().toString();
                email = txtemail.getText().toString();
                sifre = txtsifre.getText().toString();
                if (!TextUtils.isEmpty(adi) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre)) {
                    mAuth.signInWithEmailAndPassword(email, sifre)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(MainActivity.this, "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                                    intent=new Intent(MainActivity.this,MainActivity2.class);
                                    startActivity(intent);

                                }
                            });
                }
            }
        });
    }
}




