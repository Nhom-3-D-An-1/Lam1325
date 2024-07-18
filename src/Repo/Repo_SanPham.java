/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import View.*;
import DB.DBConnect;
import Model.Model_SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
public class Repo_SanPham {
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Model_SanPham> getAll(){
        ArrayList<Model_SanPham> listSP = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,MoTa,TrangThai,MaDanhMuc from SanPham ";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai,maDanhMuc;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                moTa = rs.getString(4);
                trangThai = rs.getString(5);
                maDanhMuc = rs.getString(6);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDanhMuc);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_SanPham m2){
        sql = "Insert into SanPham(MaSP,TenSP,GiaTien,MoTa,TrangThai,MaDanhMuc) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, m2.getMaSP());
            pr.setObject(2, m2.getTenSP());
            pr.setObject(3, m2.getGiaTien());
            pr.setObject(4, m2.getMoTa());
            pr.setObject(5, m2.getTrangThai());
            pr.setObject(6, m2.getMaDanhMuc());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean  exitByma(String maSP){
        sql = "select count (*) from SanPham where MaSP =?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, maSP);
            rs = pr.executeQuery();
            if(rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return false;
    }
    public int sua(Model_SanPham m2 ,String maSPcs){
        sql = "Update SanPham set TenSP =?,GiaTien=?,MoTa=?,TrangThai=?,MaDanhMuc=? where MaSP =?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(6, maSPcs);
            pr.setObject(1, m2.getTenSP());
            pr.setObject(2, m2.getGiaTien());
            pr.setObject(3, m2.getMoTa());
            pr.setObject(4, m2.getTrangThai());
            pr.setObject(5, m2.getMaDanhMuc());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(String maSPcx){
        sql = "Delete from SanPham where MaSP=?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,maSPcx);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ArrayList<Model_SanPham> timKiem(String tenSPct){
        ArrayList<Model_SanPham> listSP = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,MoTa,TrangThai,MaDanhMuc from SanPham where TenSP like ? ";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+tenSPct+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai,maDanhMuc;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                moTa = rs.getString(4);
                trangThai = rs.getString(5);
                maDanhMuc = rs.getString(6);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDanhMuc);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model_SanPham> filterByName(String name){
         ArrayList<Model_SanPham> list = new ArrayList<>();
         sql = "SELECT * FROM SanPham WHERE tenSP LIKE ?";
         try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+name+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai,maDanhMuc;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                moTa = rs.getString(4);
                trangThai = rs.getString(5);
                maDanhMuc = rs.getString(6);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDanhMuc);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Model_SanPham> filterByPriceRange(float minPrice, float maxPrice){
        ArrayList<Model_SanPham> list = new ArrayList<>();
        sql = "SELECT * FROM SanPham WHERE GiaTien BETWEEN ? AND ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, minPrice);
            pr.setObject(2,maxPrice);
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai,maDanhMuc;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                moTa = rs.getString(4);
                trangThai = rs.getString(5);
                maDanhMuc = rs.getString(6);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDanhMuc);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Model_SanPham> filterByTrangThai(String trangThaict){
        ArrayList<Model_SanPham> list = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,MoTa,TrangThai,MaDanhMuc from SanPham Where TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai,maDanhMuc;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                moTa = rs.getString(4);
                trangThai = rs.getString(5);
                maDanhMuc = rs.getString(6);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDanhMuc);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    

}
