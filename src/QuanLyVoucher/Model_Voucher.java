/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVoucher;


import QuanLyVoucher.*;

/**
 *
 * @author admin
 */
public class Model_Voucher {
    private String maVoucher;
    private String tenKM;
    private float soTienGiam;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String trangThai;

    public Model_Voucher() {
    }

    public Model_Voucher(String maVoucher, String tenKM, float soTienGiam, String ngayBatDau, String ngayKetThuc, String trangThai) {
        this.maVoucher = maVoucher;
        this.tenKM = tenKM;
        this.soTienGiam = soTienGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public float getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(float soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDaTaRow(){
        return new Object[]{this.getMaVoucher(),this.getTenKM(),this.getSoTienGiam(),this.getNgayBatDau(),this.getNgayKetThuc(),this.getTrangThai()};
    }
}
