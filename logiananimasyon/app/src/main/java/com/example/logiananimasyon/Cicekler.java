package com.example.logiananimasyon;

import android.graphics.Bitmap;

public class Cicekler {
    private String tur,aciklama;
    private Bitmap resim;

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }

    public Cicekler(String tur, String aciklama, Bitmap resim) {
        this.tur = tur;
        this.aciklama = aciklama;
        this.resim = resim;

    }
}


