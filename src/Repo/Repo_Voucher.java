/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import Repo.*;
import DB.DBConnect;
import Model.Model_Voucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Repo_Voucher {
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Model_Voucher> getAll(){
        ArrayList<Model_Voucher> listV = new ArrayList<>();
        sql = "Select MaVoucher,TenV,SoTienGiamVND,NgayBatDau,NgayKetThuc,TrangThai from Voucher";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                String maVoucher,tenKM,ngayBatDau,ngayKetThuc,trangThai;
                float soTienGiam;
                maVoucher = rs.getString(1);
                tenKM = rs.getString(2);
                soTienGiam = rs.getFloat(3);
                ngayBatDau = rs.getString(4);
                ngayKetThuc = rs.getString(5);
                trangThai = rs.getString(6);
                Model_Voucher mv = new Model_Voucher(maVoucher, tenKM, soTienGiam, ngayBatDau, ngayKetThuc, trangThai);
                listV.add(mv);
            }
            return listV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_Voucher m2){
        sql ="Insert into Voucher (MaVoucher,TenV,SoTienGiamVND,NgayBatDau,NgayKetThuc,TrangThai) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, m2.getMaVoucher());
            pr.setObject(2, m2.getTenKM());
            pr.setObject(3, m2.getSoTienGiam());
            pr.setObject(4, m2.getNgayBatDau());
            pr.setObject(5, m2.getNgayKetThuc());
            pr.setObject(6, m2.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean exitByMa(String maVoucher){
        sql = "Select count(*) from Voucher where MaVoucher =? ";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, maVoucher);
            rs = pr.executeQuery();
            if(rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public int sua(Model_Voucher m2,String maVouchercs){
        sql ="Update Voucher set TenV =?,SoTienGiamVND =?, NgayBatDau=?,NgayKetThuc =?,TrangThai=? where MaVoucher=?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(6, maVouchercs);
            pr.setObject(1, m2.getTenKM());
            pr.setObject(2, m2.getSoTienGiam());
            pr.setObject(3, m2.getNgayBatDau());
            pr.setObject(4, m2.getNgayKetThuc());
            pr.setObject(5, m2.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(String maVouchercx){
        sql = "Delete from Voucher where MaVoucher =?";
        try {
           con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, maVouchercx);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     public ArrayList<Model_Voucher> timkiem(String maVocherct){
        ArrayList<Model_Voucher> listV = new ArrayList<>();
        sql = "Select MaVoucher,TenV,SoTienGiamVND,NgayBatDau,NgayKetThuc,TrangThai from Voucher where TenV like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+maVocherct+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maVoucher,tenKM,ngayBatDau,ngayKetThuc,trangThai;
                float soTienGiam;
                maVoucher = rs.getString(1);
                tenKM = rs.getString(2);
                soTienGiam = rs.getFloat(3);
                ngayBatDau = rs.getString(4);
                ngayKetThuc = rs.getString(5);
                trangThai = rs.getString(6);
                Model_Voucher mv = new Model_Voucher(maVoucher, tenKM, soTienGiam, ngayBatDau, ngayKetThuc, trangThai);
                listV.add(mv);
            }
            return listV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
