package com.example.logiananimasyon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Homefrag extends Fragment {

    ListView listem;
    ImageView cicres ;
    private ArrayAdapter adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);
    private static String[] cicekler = {"gül", "menekşe", "lale", "karanfil"};
    private String[] cicekAciklama = {"Ana vatanı Asyadır.Daha az sayıda türler arasında Avrupa, Kuzey Amerika ve Kuzey Afrikada yetişir. Güller yaygın olarak güzellikleri ve kokuları için yetiştirilir ve birçok toplumda kültürel öneme sahiptir.", "Menekşegiller familyasına bağlı viola cinsini oluşturan çoğunukla saksılarda yetiştirilen bitki türlerinin ortak adıdır. 400-500 türü bulunmaktadır.Dünyanın birçok yerinde yetişebilmek ile beraber en çok Kuzey Yarımkürede yetişir.", "Zambakgiller familyasının Tulipa cinsini oluşturan güzel çiçekleri ile süs bitkisi olarak yetiştirilen, soğanlı, çok yıllık otsu bitki türlerinin ortak adıdır.", "Karanfilgiller familyasının Dianthus cinsinden karşılıklı, ensiz, sivri yapraklara sahip otsu çiçekli bitkilerin ortak adıdır. Kuzey Afrika ve Kuzey Afrikada da türleri olmak üzere esasen Asya ve Avrupa ya özgü yerel bitkidir."};
    private int[] bitres = {R.drawable.gul, R.drawable.menekse, R.drawable.lale, R.drawable.karanfil};
    private Bitmap seccicek;
    static public Cicekler cicek;


    @SuppressLint("MissingInflatedId")
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homefrag, container, false);

        listem = listem.findViewById(R.id.listem);
        adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);
        listem.setAdapter(adapter);
        listem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(getActivity(),MainActivity3.class);
                seccicek = BitmapFactory.decodeResource(getApplicationContext().getResources(),bitres[i]);
                cicek = new Cicekler(cicekler[i], cicekAciklama[i], seccicek);
                startActivity(intent);


            }

            private View getApplicationContext() {
                return null;
            }

        })
    ; return view;
    }
    }






