    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package QuanLyDoanhThu;

import DB.DBConnect;
//    import JDBC.DBConnect;

    import java.util.ArrayList;
    import java.util.List;
    import java.sql.*;

    /**
     *
     * @author Hoàng Quân
     */
    public class QuanLyDoanhThuServer {
             public static List<HoaDon> getDoanhThu(){
            List<HoaDon> HoaDonList = new ArrayList<>();
            try {
                Connection con = DBConnect.getConnection();
                String sql = """
                            WITH HoaDondoanhthu AS (
                            SELECT 
                            NgayTao AS Ngay,
                            COUNT(MaHD) AS SoLuongHoaDon,
                            SUM(TongTien) AS TongTien
                            FROM HoaDon
                            GROUP BY NgayTao
                            )
                            SELECT 
                                ROW_NUMBER() OVER (ORDER BY Ngay) AS STT,
                                Ngay,
                                SoLuongHoaDon,
                                TongTien
                            FROM HoaDondoanhthu
                            ORDER BY Ngay;
                             """;
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {  
                    Date Ngay = rs.getDate(2);
                    String ma = rs.getString(3);
                    float Tong = rs.getFloat(4);
                    HoaDon hoaDon = new HoaDon(ma, ma, sql, Ngay, Tong, ma, ma, ma, ma);
                    HoaDonList.add(hoaDon);

                }
                return HoaDonList;

            } catch (Exception e) {
                 e.printStackTrace();
            }
            return null;
        }

        public static List<HoaDon> TimKiemTheoNgay(Date ngay) {
        List<HoaDon> HoaDonList = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = """
                         SELECT MaHD, MaNV, SDT, NgayTao, TongTien, MaKH, MaVoucher, TrangThai, DiaChi
                         FROM HoaDon
                         WHERE NgayTao = ?;
                         """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngay);  
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                String MaHD = rs.getString(1);
                String MaNV = rs.getString(2);
                String SDT = rs.getString(3);
                Date NgayTao = rs.getDate(4);
                float TongTien = rs.getFloat(5);
                String MaKH = rs.getString(6);
                String MaVoucher = rs.getString(7);
                String DiaChi = rs.getString(8);
                String TrangThai = rs.getString(9);
                HoaDon hoaDon = new HoaDon(MaHD, MaNV, SDT, NgayTao, TongTien, TrangThai, DiaChi, MaKH, MaVoucher);
                HoaDonList.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return HoaDonList; 
    }
        
        
        
         public static List<HoaDon> TimKiemnamThang(Date NgayBatDau, Date NgayKetThuc) {
            List<HoaDon> HoaDonList = new ArrayList<>();
            try {
                Connection con = DBConnect.getConnection();
                String sql = """
                              SELECT MaHD, MaNV, SDT, NgayTao, TongTien, MaKH, MaVoucher, TrangThai, DiaChi
                              FROM HoaDon
                              WHERE NgayTao BETWEEN ? AND ?;
                             """;
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDate(1, NgayBatDau);  
                ps.setDate(2, NgayKetThuc); 
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String MaHD = rs.getString(1);
                    String MaNV = rs.getString(2);
                    String SDT = rs.getString(3);
                    Date NgayTao = rs.getDate(4);
                    float TongTien = rs.getFloat(5);
                    String MaKH = rs.getString(6);
                    String MaVoucher = rs.getString(7);
                    String DiaChi = rs.getString(8);
                    String TrangThai = rs.getString(9);
                    HoaDon hoaDon = new HoaDon(MaHD, MaNV, SDT, NgayTao, TongTien, TrangThai, DiaChi, MaKH, MaVoucher);
                    HoaDonList.add(hoaDon);
                }
            } catch (Exception e) {
                e.printStackTrace(); 
            }
            return HoaDonList; 
        }












    }
