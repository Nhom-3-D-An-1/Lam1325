/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyDoanhThu;


import java.util.Date;

/**
 *
 * @author Hoàng Quân
 */
public class HoaDon {
    private String MaHD;
    private String MaNV;
    private int SDT;
    private Date NgayTao;
    private float TongTien;
    private String MaKH;
    private String MaVoucher;
    private int MaBan;
    private String DiaChi;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, int SDT, Date NgayTao, float TongTien, String MaKH, String MaVoucher, int MaBan, String DiaChi) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.SDT = SDT;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.MaKH = MaKH;
        this.MaVoucher = MaVoucher;
        this.MaBan = MaBan;
        this.DiaChi = DiaChi;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaVoucher() {
        return MaVoucher;
    }

    public void setMaVoucher(String MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
    
}
