/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLyVouCher123;

import QuanLyVoucher.*;
import QuanLyVoucher.*;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import Repo.Repo_Voucher;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QuanLyVoucher extends javax.swing.JFrame {

    private Repo_Voucher repo_Voucher = new Repo_Voucher();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int i=-1;
//    private  JDateChooser Jdatengaybd = new JDateChooser();
//    private JDateChooser Jdatengaykt = new JDateChooser();
    public QuanLyVoucher() {
        
        initComponents();
        this.fillTable(repo_Voucher.getAll());
    }

    void fillTable(ArrayList<Model_Voucher> list){
       dtm = (DefaultTableModel) tblQLVoucher.getModel();
       dtm.setRowCount(0);
       for(Model_Voucher x:list){
           dtm.addRow(x.toDaTaRow());
       }
    }
    void clearForm(){
        txtmavoucher.setText("");
        txttenvoucher.setText("");
        txtsotiengiam.setText("");
        Jdatengaybd.setDate(new Date());
        jdatengaykt.setDate(new Date());
        rdoconhieuluc.setSelected(true);
    }
    void showData(int i){
        String maVoucher = tblQLVoucher.getValueAt(i,0).toString();
        String tenVoucher = tblQLVoucher.getValueAt(i,1).toString();
        String soTienGiam = tblQLVoucher.getValueAt(i,2).toString();
        String ngayBatDau = tblQLVoucher.getValueAt(i,3).toString();
        String ngayKetThuc = tblQLVoucher.getValueAt(i,4).toString();
        String trangThai = tblQLVoucher.getValueAt(i,5).toString();
        
        txtmavoucher.setText(maVoucher);
        txttenvoucher.setText(tenVoucher);
        txtsotiengiam.setText(soTienGiam);
        try {
            Jdatengaybd.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayBatDau));
            jdatengaykt.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ngayKetThuc));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if(trangThai.equals("Hoat Dong")){
            rdoconhieuluc.setSelected(true);
        }else{
            rdohethieuluc.setSelected(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmavoucher = new javax.swing.JTextField();
        txttenvoucher = new javax.swing.JTextField();
        txtsotiengiam = new javax.swing.JTextField();
        rdoconhieuluc = new javax.swing.JRadioButton();
        rdohethieuluc = new javax.swing.JRadioButton();
        Jdatengaybd = new com.toedter.calendar.JDateChooser();
        jdatengaykt = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLVoucher = new javax.swing.JTable();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin VouCher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã Voucher");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên Voucher");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Số Tiền Giảm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày kết thúc");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng Thái");

        buttonGroup1.add(rdoconhieuluc);
        rdoconhieuluc.setText("Hoat Dong");
        rdoconhieuluc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoconhieulucActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdohethieuluc);
        rdohethieuluc.setText("Khong Hoat Dong");

        Jdatengaybd.setDateFormatString("yyyy-MM-dd");

        jdatengaykt.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttenvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmavoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsotiengiam, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoconhieuluc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdohethieuluc))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jdatengaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Jdatengaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtmavoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jdatengaybd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txttenvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jdatengaykt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsotiengiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rdoconhieuluc)
                    .addComponent(rdohethieuluc))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btnthem.setBackground(new java.awt.Color(204, 204, 204));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setText("Thêm Voucher");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(204, 204, 204));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setText("Sửa Voucher");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(204, 204, 204));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoa.setText("Xóa Voucher");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblQLVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã VouCher", "Tên VouCher", "Số Tiền Giảm", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ));
        tblQLVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLVoucher);

        btntimkiem.setBackground(new java.awt.Color(204, 204, 204));
        btntimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btntimkiem)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttimkiem)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLVoucherMouseClicked
        i = tblQLVoucher.getSelectedRow();
        this.showData(i);
    }//GEN-LAST:event_tblQLVoucherMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String maVoucher = txtmavoucher.getText().trim();
        String tenKM = txttenvoucher.getText().trim();
        String soTienGiamstr = txtsotiengiam.getText().trim();
        Date ngaybd = Jdatengaybd.getDate();
        Date ngaykt = jdatengaykt.getDate();
        String trangThai;
        if(rdoconhieuluc.isSelected()){
            trangThai = "Hoat Dong";
        }else{
            trangThai = "Khong Hoat Dong";
        }
        if(maVoucher.isEmpty()||tenKM.isEmpty()||ngaybd==null||ngaykt==null){
        JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
            return;  
        }
        float soTienGiam;
        try {
            soTienGiam = Float.parseFloat(soTienGiamstr);
            if(soTienGiam<=0){
                JOptionPane.showMessageDialog(this,"Số tiền giảm phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập số tiền giảm là số nguyên");
            return;
        }
        if (ngaybd.after(ngaykt)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String strNgayBatDau = sdf.format(ngaybd);
         String strNgayKetThuc = sdf.format(ngaykt);
        if(repo_Voucher.exitByMa(maVoucher)){
            JOptionPane.showMessageDialog(this, "Mã bị Trùng ! Vui lòng đổi mã khác");
            return;
        }
        Model_Voucher mv = new Model_Voucher(maVoucher, tenKM, soTienGiam, ngaybd, ngaykt,trangThai);
        this.repo_Voucher.them(mv);
        this.fillTable(repo_Voucher.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Thêm thành công");
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        i = tblQLVoucher.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần sửa");
            return;
        }
        String maVoucher = txtmavoucher.getText().trim();
        String tenKM = txttenvoucher.getText().trim();
        String soTienGiamstr = txtsotiengiam.getText().trim();
        Date ngaybd = Jdatengaybd.getDate();
        Date ngaykt = jdatengaykt.getDate();
        String trangThai;
        if(rdoconhieuluc.isSelected()){
            trangThai = "Hoat Dong";
        }else{
            trangThai = "Khong Hoat Dong";
        }
        if(maVoucher.isEmpty()||tenKM.isEmpty()||ngaybd==null||ngaykt==null){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
            return;  
        }
        float soTienGiam;
        try {
            soTienGiam = Float.parseFloat(soTienGiamstr);
            if(soTienGiam<=0){
                JOptionPane.showMessageDialog(this,"Số tiền giảm phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập số tiền giảm là số nguyên");
            return;
        }
        if (ngaybd.after(ngaykt)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String strNgayBatDau = sdf.format(ngaybd);
         String strNgayKetThuc = sdf.format(ngaykt);
        
        Model_Voucher mv = new Model_Voucher(maVoucher, tenKM, soTienGiam, ngaybd, ngaykt, trangThai);
        this.repo_Voucher.sua(mv, maVoucher);
        this.fillTable(repo_Voucher.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Sửa thành công");
        
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        i = tblQLVoucher.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần xóa");
            return;
        }
        String maVouchercx = txtmavoucher.getText().trim();
        this.repo_Voucher.xoa(maVouchercx);
        this.fillTable(repo_Voucher.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa Thành công");
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String maVoucherct = txttimkiem.getText().trim();
        String tenVct = txttimkiem.getText().trim();
        String trangThaict = txttimkiem.getText().trim();
        if(repo_Voucher.timkiem(maVoucherct, tenVct, trangThaict).isEmpty()){
            JOptionPane.showMessageDialog(this,"Không tìm thấy danh sách ");
        }else{
            this.fillTable(repo_Voucher.timkiem(maVoucherct, tenVct, trangThaict));
            JOptionPane.showMessageDialog(this,"Danh sách được tìm thấy");
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void rdoconhieulucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoconhieulucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoconhieulucActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyVoucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jdatengaybd;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdatengaykt;
    private javax.swing.JRadioButton rdoconhieuluc;
    private javax.swing.JRadioButton rdohethieuluc;
    private javax.swing.JTable tblQLVoucher;
    private javax.swing.JTextField txtmavoucher;
    private javax.swing.JTextField txtsotiengiam;
    private javax.swing.JTextField txttenvoucher;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
