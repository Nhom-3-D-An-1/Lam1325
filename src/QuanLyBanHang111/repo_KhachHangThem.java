/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyBanHang111;
import DB.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Quân
 */
public class repo_KhachHangThem {
    public static List<KhachHang> getBtnThem(){
        List<KhachHang> ListKh = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps =   con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                String MaKH = rs.getString(1);
                String TenKH = rs.getString(2);
                String GioiTinh = rs.getString(3);
                String DiaChi = rs.getString(4);
                String SDT = rs.getString(5);
                String LoaiKhacHang = rs.getString(6);
                int DiemThanhVien = rs.getInt(7);
                KhachHang kh =new KhachHang(MaKH, TenKH, GioiTinh, DiaChi, SDT, LoaiKhacHang, DiemThanhVien);
                ListKh.add(kh);

                
            }
            return ListKh;
        } catch (Exception e) {
        }
        return null;
    }
    
    
}
