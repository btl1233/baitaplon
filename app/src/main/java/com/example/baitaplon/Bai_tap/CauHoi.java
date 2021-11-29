package com.example.baitaplon.Bai_tap;

public class CauHoi {
    private String cauhoi;
    private String dapandung, tendapan, dapansai1, ten1, dapansai2, ten2, dapansai3, ten3;

    public CauHoi(String cauhoi, String dapandung, String tendapan, String dapansai1, String ten1, String dapansai2, String ten2, String dapansai3, String ten3) {
        this.cauhoi = cauhoi;
        this.dapandung = dapandung;
        this.tendapan = tendapan;
        this.dapansai1 = dapansai1;
        this.ten1 = ten1;
        this.dapansai2 = dapansai2;
        this.ten2 = ten2;
        this.dapansai3 = dapansai3;
        this.ten3 = ten3;
    }

    public CauHoi() {

    }

    public String getTendapan() {
        return tendapan;
    }

    public void setTendapan(String tendapan) {
        this.tendapan = tendapan;
    }

    public String getTen1() {
        return ten1;
    }

    public void setTen1(String ten1) {
        this.ten1 = ten1;
    }

    public String getTen2() {
        return ten2;
    }

    public void setTen2(String ten2) {
        this.ten2 = ten2;
    }
    
    public String getTen3() {
        return ten3;
    }

    public void setTen3(String ten3) {
        this.ten3 = ten3;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapandung() {
        return dapandung;
    }

    public void setDapandung(String dapandung) {
        this.dapandung = dapandung;
    }

    public String getDapansai1() {
        return dapansai1;
    }

    public void setDapansai1(String dapansai1) {
        this.dapansai1 = dapansai1;
    }

    public String getDapansai2() {
        return dapansai2;
    }

    public void setDapansai2(String dapansai2) {
        this.dapansai2 = dapansai2;
    }

    public String getDapansai3() {
        return dapansai3;
    }

    public void setDapansai3(String dapansai3) {
        this.dapansai3 = dapansai3;
    }
}