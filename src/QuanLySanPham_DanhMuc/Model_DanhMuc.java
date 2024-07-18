/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLySanPham_DanhMuc;


import QuanLySanPham_DanhMuc.*;

/**
 *
 * @author admin
 */
public class Model_DanhMuc {
    private String maDanhMuc;
    private String tenDanhMuc;
    private String moTa;

    public Model_DanhMuc() {
    }

    public Model_DanhMuc(String maDanhMuc, String tenDanhMuc, String moTa) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.moTa = moTa;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public Object[] toDaTaRow1(){
        return new Object[]{this.getMaDanhMuc(),this.getTenDanhMuc(),this.getMoTa()};
    }
}
