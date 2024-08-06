/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BHSP;

import BHSP.KhahHangThem;
import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Quân
 */
public class KhachHangThemServer {
    public static List<KhahHangThem> getKhachHang() {
        List<KhahHangThem> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "select MaKH,TenKH,GioiTinh,DiaChi,SDT,LoaiKhacHang,DiemThanhVien from KhachHang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaKH = rs.getString(1);
                String TenKH = rs.getString(2);
                String GioiTinh = rs.getString(3);
                String DiaChi = rs.getString(4);
                String SDT = rs.getString(5);
                String LoaiKhacHang = rs.getString(6);
                int DiemThanhVien = rs.getInt(7);

                KhahHangThem kh = new KhahHangThem(MaKH, TenKH, GioiTinh, DiaChi, SDT, LoaiKhacHang, DiemThanhVien);
                list.add(kh);
            }

            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public static void them( KhahHangThem kh){
        try {
            Connection con = DBConnect.getConnection();
            String sql = " INSERT INTO KhachHang(MaKH,TenKH,GioiTinh,DiaChi,SDT,LoaiKhacHang,DiemThanhVien) VALUES(?,?,?,?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,kh.getMaKH() );
            ps.setString(2,kh.getTenKh() );
            ps.setString(3,kh.getGioiTinh() );
            ps.setString(4,kh.getDiaChi() );
            ps.setString(5,kh.getSDT());
            ps.setString(6,kh.getLoaiKhacHang() );
            ps.setInt(7,kh.getDiemThanhVien() );
            ps.executeUpdate();
        } catch (Exception e) {
        }
     
        
    }
    
    
               public List<KhahHangThem> TimkiemKH(String searchQuery) {
    List<KhahHangThem> result = new ArrayList<>();
    // Giả sử bạn có một danh sách tất cả khách hàng
    List<KhahHangThem> allKhachHang = getKhachHang();

    for (KhahHangThem kh : allKhachHang) {
        if (kh.getMaKH().contains(searchQuery) || 
            kh.getTenKh().contains(searchQuery) ||
            kh.getSDT().contains(searchQuery)) {
            result.add(kh);
        }
    }
    return result;
}
    
}
