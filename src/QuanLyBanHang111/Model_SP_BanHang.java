/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBanHang111;

import QuanLyBanHang.*;

/**
 *
 * @author admin
 */
public class Model_SP_BanHang {
    private String maSP;
    private String tenSP;
    private float donGia;
    private String trangThai;

    public Model_SP_BanHang() {
    }

    public Model_SP_BanHang(String maSP,String tenSP ,float donGia, String trangThai) {
        this.maSP = maSP;
        this.tenSP=tenSP;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDaTaRow(){
        return new Object[]{this.getMaSP(),this.getTenSP(),this.getDonGia(),this.getTrangThai()};
    }
            
    
    
}
