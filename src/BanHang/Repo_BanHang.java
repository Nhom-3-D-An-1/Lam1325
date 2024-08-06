/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanHang;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Repo_BanHang {
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Model_BanHang> getAll(){
        ArrayList<Model_BanHang> list = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,TrangThai from SanPham";
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
                Model_BanHang mv = new Model_BanHang(maSP, tenSP, giaTien, trangThai);
                list.add(mv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public ArrayList<Model_BanHang> timKiem(String maSPct, String tenSPct, String trangThaict){
        ArrayList<Model_BanHang> list = new ArrayList<>();
        sql = "Select MaSP,TenSP,GiaTien,TrangThai from SanPham where MaSP like ? or TenSP like ? or TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+maSPct+'%');
            pr.setObject(2,'%'+tenSPct+'%');
//            pr.setObject(3,'%'+giaTienct+'%');
            pr.setObject(3,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_BanHang mv = new Model_BanHang(maSP, tenSP, giaTien, trangThai);
                list.add(mv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
