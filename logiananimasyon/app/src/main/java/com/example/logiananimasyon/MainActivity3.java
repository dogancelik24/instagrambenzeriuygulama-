package com.example.logiananimasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
     TextView txtcicadi,txtcicacik;
     ImageView cicres;
     private String scicadi,scicacikla;
     private Bitmap scicresim;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtcicadi=findViewById(R.id.cicekadi);
        txtcicacik=findViewById(R.id.cicaciklama);
        cicres=findViewById(R.id.cicres);
        scicadi=Homefrag.cicek.getTur();
        scicacikla=Homefrag.cicek.getAciklama();
        scicresim=Homefrag.cicek.getResim();
        if(!TextUtils.isEmpty(scicadi)&& !TextUtils.isEmpty(scicacikla)){
            txtcicadi.setText(scicadi);
            txtcicacik.setText(scicacikla);
            cicres.setImageBitmap(scicresim);

        }

    }
}