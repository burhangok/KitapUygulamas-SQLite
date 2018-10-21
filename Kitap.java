package com.teknodate.smekyayinlari;

import java.io.Serializable;

public class Kitap implements Serializable {

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarkod_no() {
        return barkod_no;
    }

    public void setBarkod_no(String barkod_no) {
        this.barkod_no = barkod_no;
    }

    public String getKitap_ismi() {
        return kitap_ismi;
    }

    public void setKitap_ismi(String kitap_ismi) {
        this.kitap_ismi = kitap_ismi;
    }

    public String barkod_no;

    public Kitap(String barkod_no, String kitap_ismi) {

        this.barkod_no = barkod_no;
        this.kitap_ismi = kitap_ismi;
    }

    public Kitap() {

    }

    public String kitap_ismi;

}
