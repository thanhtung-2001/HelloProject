package com.fpt.edu.model;

public class Book {
    private int id;
    private String ten,tacgia;
    private int theloai_id, nxb_id;
    private float giaban;
    private NhaXuatBan nhaXuatBan;

    public Book() {
    }

    public Book(int id, String ten, String tacgia, int theloai_id, int nxb_id, float giaban) {
        this.id = id;
        this.ten = ten;
        this.tacgia = tacgia;
        this.theloai_id = theloai_id;
        this.nxb_id = nxb_id;
        this.giaban = giaban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getTheloai_id() {
        return theloai_id;
    }

    public void setTheloai_id(int theloai_id) {
        this.theloai_id = theloai_id;
    }

    public int getNxb_id() {
        return nxb_id;
    }

    public void setNxb_id(int nxb_id) {
        this.nxb_id = nxb_id;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
}
