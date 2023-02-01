package org.example;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class Kisi {
    public int id;
    public String isim;
    public String soyisim;
    public String dogumTarihi;
    public String esi;
    public String anneAdi;
    public String babaAdi;
    public String kanGrubu;
    public String meslek;
    public String medeniHal;
    public String kizlikSoyismi;
    public String cinsiyet;

    public Kisi(int id, String isim, String soyisim, String dogumTarihi, String esi, String anneAdi, String babaAdi, String kanGrubu, String meslek, String medeniHal, String kizlikSoyismi, String cinsiyet) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.dogumTarihi = dogumTarihi;
        this.esi = esi;
        this.anneAdi = anneAdi;
        this.babaAdi = babaAdi;
        this.kanGrubu = kanGrubu;
        this.meslek = meslek;
        this.medeniHal = medeniHal;
        this.kizlikSoyismi = kizlikSoyismi;
        this.cinsiyet = cinsiyet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getEsi() {
        return esi;
    }

    public void setEsi(String esi) {
        this.esi = esi;
    }

    public String getAnneAdi() {
        return anneAdi;
    }

    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public String getMedeniHal() {
        return medeniHal;
    }

    public void setMedeniHal(String medeniHal) {
        this.medeniHal = medeniHal;
    }

    public String getKizlikSoyismi() {
        return kizlikSoyismi;
    }

    public void setKizlikSoyismi(String kizlikSoyismi) {
        this.kizlikSoyismi = kizlikSoyismi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

}

