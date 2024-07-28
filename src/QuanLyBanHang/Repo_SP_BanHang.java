/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBanHang;


import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Repo_SP_BanHang {
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Model_SP_BanHang> getAll(){
        ArrayList<Model_SP_BanHang> list = new ArrayList<>();
        sql = "Select hdct.MaSP,sp.TenSP,hdct.GiaTien,hdct.TrangThai from HoaDonChiTiet hdct join SanPham sp on sp.MaSP = hdct.MaSP";
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
                Model_SP_BanHang mv = new Model_SP_BanHang(maSP,tenSP, giaTien, trangThai);
                list.add(mv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Model_SP_BanHang> timKiem(String maSPct,String tenSPct, String trangThaict){
        ArrayList<Model_SP_BanHang> list = new ArrayList<>();
        sql = "Select hdct.MaSP,sp.TenSP,hdct.GiaTien,hdct.TrangThai from HoaDonChiTiet hdct join SanPham sp on sp.MaSP = hdct.MaSP where hdct.MaSP like ? or sp.TenSP like ? or hdct.TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+maSPct+'%');
            pr.setObject(3, '%'+tenSPct+'%');
            pr.setObject(2,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maSP,tenSP,trangThai;
                float giaTien;
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                giaTien = rs.getFloat(3);
                trangThai = rs.getString(4);
                Model_SP_BanHang mv = new Model_SP_BanHang(maSP, tenSP, giaTien, trangThai);
                list.add(mv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        
}
