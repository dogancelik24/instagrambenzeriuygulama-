package com.example.logiananimasyon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Personfrag extends Fragment {
    TextView Txt1, Txt2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personfrag, container, false);
        Txt1=view.findViewById(R.id.txttext1);
        Txt2=view.findViewById(R.id.txttext2);
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference ref= database .getReference("Kullanıcılar");
        FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null){
            String uid=currentUser.getUid();
            ref.child(uid).child("isim").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) { String username=snapshot.getValue(String.class);
                    Txt1.setText(uid);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {



                }
            });
            String email= currentUser.getEmail();
            Txt2.setText(email);

        }

        return view;











    }


    
    
}