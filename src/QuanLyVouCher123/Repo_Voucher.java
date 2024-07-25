/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVouCher123;

import QuanLyVoucher.*;
import QuanLyVoucher.*;
import DB.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
                String maVoucher,tenKM,trangThai;
                Date ngayBatDau,ngayKetThuc;
                float soTienGiam;
                maVoucher = rs.getString(1);
                tenKM = rs.getString(2);
                soTienGiam = rs.getFloat(3);
                ngayBatDau = rs.getDate(4);
                ngayKetThuc = rs.getDate(5);
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
//        sql = "Delete from Voucher where MaVoucher =?";
//        try {
//           con = DBConnect.getConnection();
//            pr = con.prepareStatement(sql);
//            pr.setObject(1, maVouchercx);
//            return pr.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
        try {
        con = DBConnect.getConnection();

        // Xóa các bản ghi trong bảng HoaDonChiTiet liên quan
        String sql = "DELETE FROM HoaDonChiTiet WHERE MaHD IN (SELECT MaHD FROM HoaDon WHERE MaVoucher = ?)";
        pr = con.prepareStatement(sql);
        pr.setObject(1, maVouchercx);
        pr.executeUpdate();

        // Xóa các bản ghi trong bảng HoaDon liên quan
        sql = "DELETE FROM HoaDon WHERE MaVoucher = ?";
        pr = con.prepareStatement(sql);
        pr.setObject(1, maVouchercx);
        pr.executeUpdate();

        // Cuối cùng, xóa bản ghi trong bảng Voucher
        sql = "DELETE FROM Voucher WHERE MaVoucher = ?";
        pr = con.prepareStatement(sql);
        pr.setObject(1, maVouchercx);
        return pr.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
    }
     public ArrayList<Model_Voucher> timkiem(String maVocherct, String tenVct,String trangThaict){
        ArrayList<Model_Voucher> listV = new ArrayList<>();
        sql = "Select MaVoucher,TenV,SoTienGiamVND,NgayBatDau,NgayKetThuc,TrangThai from Voucher where MaVoucher like? or TenV like ? or TrangThai like ?";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1,'%'+maVocherct+'%');
            pr.setObject(2,'%'+tenVct+'%');
            pr.setObject(3,'%'+trangThaict+'%');
            rs = pr.executeQuery();
            while(rs.next()){
                String maVoucher,tenKM,trangThai;
                Date ngayBatDau,ngayKetThuc;
                float soTienGiam;
                maVoucher = rs.getString(1);
                tenKM = rs.getString(2);
                soTienGiam = rs.getFloat(3);
                ngayBatDau = rs.getDate(4);
                ngayKetThuc = rs.getDate(5);
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
