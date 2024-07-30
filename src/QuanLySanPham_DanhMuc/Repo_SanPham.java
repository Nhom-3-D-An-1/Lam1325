/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLySanPham_DanhMuc;

import DB.DBConnect;

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
        sql = "Select MaSP,TenSP,GiaTien,TrangThai from SanPham ";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, trangThai);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_SanPham m2){
        sql = "Insert into SanPham(MaSP,TenSP,GiaTien,TrangThai) values (?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, m2.getMaSP());
            pr.setObject(2, m2.getTenSP());
            pr.setObject(3, m2.getGiaTien());
            pr.setObject(4, m2.getTrangThai());
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
        sql = "Update SanPham set TenSP =?,GiaTien=?,TrangThai=? where MaSP =?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(4, maSPcs);
            pr.setObject(1, m2.getTenSP());
            pr.setObject(2, m2.getGiaTien());
            pr.setObject(3, m2.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(String maSPcx){
        
    try {
        con = DBConnect.getConnection();
        
        // Bắt đầu giao dịch
        con.setAutoCommit(false);
        
        // Xóa dữ liệu trong bảng HoaDonChiTiet trước
        String sqlDeleteDetails = "DELETE FROM HoaDonChiTiet WHERE MaSP=?";
        pr = con.prepareStatement(sqlDeleteDetails);
        pr.setObject(1, maSPcx);
        pr.executeUpdate();
        
        // Xóa dữ liệu trong bảng SanPham
        String sqlDeleteProduct = "DELETE FROM SanPham WHERE MaSP=?";
        pr = con.prepareStatement(sqlDeleteProduct);
        pr.setObject(1, maSPcx);
        int result = pr.executeUpdate();
        
        // Cam kết giao dịch
        con.commit();
        
        return result;
    } catch (Exception e) {
        if (con != null) {
            try {
                // Rollback giao dịch nếu có lỗi
                con.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        e.printStackTrace();
        return 0;
    } finally {
        try {
            if (pr != null) pr.close();
            if (con != null) con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

     public ArrayList<Model_SanPham> timKiem(String tenSPct,String trangThaict){
        ArrayList<Model_SanPham> listSP = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,TrangThai from SanPham where TenSP like ? or TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+tenSPct+'%');
            pr.setObject(2,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,moTa,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, trangThai);
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
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, trangThai);
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
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, trangThai);
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
        sql = "Select MaSP,TenSP,GiaTien,TrangThai from SanPham Where TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, trangThai);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
