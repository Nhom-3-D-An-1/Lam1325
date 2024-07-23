/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLySanPham_DanhMuc;

//import QuanLySanPham_DanhMuc.*;
import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repo_DanhMuc {
    private String sql;
    private Connection con;
    private PreparedStatement pr;
    private ResultSet rs;
    
    public ArrayList<Model_DanhMuc> getAll1(){
        ArrayList<Model_DanhMuc> listdm = new ArrayList<>();
        sql = "Select MaDanhMuc,TenDanhMuc,TrangThai from DanhMucChiTiet";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                String maDM,tenDM,trangThai;
                maDM = rs.getString(1);
                tenDM = rs.getString(2);
                trangThai = rs.getString(3);
                Model_DanhMuc dm = new Model_DanhMuc(maDM, tenDM,trangThai);
                listdm.add(dm);
                        
            }
            return listdm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them1(Model_DanhMuc m2){
        sql = "Insert into DanhMucChiTiet (MaDanhMuc,TenDanhMuc,TrangThai) values (?,?,?)";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, m2.getMaDanhMuc());
            pr.setObject(2, m2.getTenDanhMuc());
            pr.setObject(3, m2.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean  exitByMa(String maDM){
        sql = "Select count (*) from DanhMucChiTiet where MaDanhMuc =?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, maDM);
            rs = pr.executeQuery();
            if(rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return false;
    }
    public int sua1(Model_DanhMuc m2 ,String maDM){
        sql = "Update DanhMucChiTiet set TenDanhMuc =?, TrangThai =? where MaDanhMuc =?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, m2.getTenDanhMuc());
            pr.setObject(2, m2.getTrangThai());
            pr.setObject(3, maDM);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa1(String maDMcx){
        sql="Delete from DanhMucChiTiet where MaDanhMuc = ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, maDMcx);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     public ArrayList<Model_DanhMuc> TimKiem1(String tenDMct){
        ArrayList<Model_DanhMuc> listdm = new ArrayList<>();
        sql = "Select MaDanhMuc,TenDanhMuc,TrangThai from DanhMucChiTiet where TenDanhMuc like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+tenDMct+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maDM,tenDM,trangThai;
                maDM = rs.getString(1);
                tenDM = rs.getString(2);
                trangThai = rs.getString(3);
                Model_DanhMuc dm = new Model_DanhMuc(maDM, tenDM,trangThai);
                listdm.add(dm);
                        
            }
            return listdm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
