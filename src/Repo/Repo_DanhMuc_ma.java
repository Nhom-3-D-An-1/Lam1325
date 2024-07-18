/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import View.*;
import DB.DBConnect;
import Model.Model_DanhMuc_ma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
public class Repo_DanhMuc_ma {
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Model_DanhMuc_ma> getAll(){
        ArrayList<Model_DanhMuc_ma> listDM = new ArrayList<>();
        sql = "Select MaDanhMuc from DanhMucChiTiet";
        try {
            con = DBConnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                String maDanhMuc;
                maDanhMuc = rs.getString(1);
                Model_DanhMuc_ma dm = new Model_DanhMuc_ma(maDanhMuc);
                listDM.add(dm);
            }
            return listDM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
