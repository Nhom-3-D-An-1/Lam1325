/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLySanPham_DanhMuc;

//import QuanLySanPham_DanhMuc.*;
//import Model.Model_DanhMuc;
//import Model.Model_DanhMuc_ma;
//import Model.Model_SanPham;
//import Repo.Repo_DanhMuc;
//import Repo.Repo_DanhMuc_ma;
//import Repo.Repo_SanPham;
//import View.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QuanLySanPham extends javax.swing.JFrame {

    private Repo_DanhMuc_ma repoDM = new Repo_DanhMuc_ma();
    private Repo_SanPham repo_SP = new Repo_SanPham();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int i =-1;
    private Repo_DanhMuc repo_DanhMuc = new Repo_DanhMuc();
    public QuanLySanPham() {
        initComponents();

        for(Model_DanhMuc_ma x:repoDM.getAll()){
            cbbmadanhmuc.addItem(x.getMaDanhMuc().toString());
        }
        fillTable(repo_SP.getAll());
        fillTable1(repo_DanhMuc.getAll1());
        this.populateFilterCombos();
        this.populateFilterCombos1();
        this.populateFilterCombos2();
    }
    private void populateFilterCombos() {
        cbbtensp.addItem("All");
        for (Model_SanPham sp : repo_SP.getAll()) {
            cbbtensp.addItem(sp.getTenSP());
        }
    }
    private void filterProducts() {
        String selectedName = cbbtensp.getSelectedItem().toString();
        ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
        if (!selectedName.equals("All")) {
            filteredList = repo_SP.filterByName(selectedName);
        }
        fillTable(filteredList);
    }
    
    
    private void populateFilterCombos1(){
        cbbtrangThai.addItem("All");
        cbbtrangThai.addItem("Con hang");
        cbbtrangThai.addItem("Het hang");
    }
    private void filterProducts1(){
        String selectedtrangThai = cbbtrangThai.getSelectedItem().toString();
        ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
        if(!selectedtrangThai.equals("All")){
            switch(selectedtrangThai){
                case "Con hang":
                    filteredList = repo_SP.filterByTrangThai("Con hang");
                    break;
                case "Het hang":
                    filteredList = repo_SP.filterByTrangThai("Het hang");
                    break;
            }
        }
        fillTable(filteredList);
    }
    private void  populateFilterCombos2(){
        cbbgiatien.addItem("All");
        cbbgiatien.addItem("< 10000");
        cbbgiatien.addItem("10000 - 50000");
        cbbgiatien.addItem(">=50000");
    }
    private void filterProducts2(){
        String selectedPriceRange = cbbgiatien.getSelectedItem().toString();
        ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
        if (!selectedPriceRange.equals("All")) {
            switch (selectedPriceRange) {
                case "< 10000":
                    filteredList = repo_SP.filterByPriceRange(0, 10000);
                    break;
                case "10000 - 50000":
                    filteredList = repo_SP.filterByPriceRange(10001, 50000);
                    break;
                case ">=50000":
                    filteredList = repo_SP.filterByPriceRange(50001, Float.MAX_VALUE);
                    break;
            }
        }
        fillTable(filteredList);
    }
    private void  populateFilterCombos3(){
        
    }
    void clearForm(){
        txtmasp.setText("");
        txttensp.setText("");
        txtgiatien.setText("");
        txtmota.setText("");
        rdoconhang.setSelected(true);
        cbbmadanhmuc.setSelectedIndex(0);
    }

    void fillTable(ArrayList<Model_SanPham> list){
        dtm = (DefaultTableModel) tblQLSP.getModel();
        dtm.setRowCount(0);
        for(Model_SanPham x:list){
            dtm.addRow(x.toDataRow());
        }
    }
    void showDaTa(int i){
        String maSP = tblQLSP.getValueAt(i, 0).toString();
        String tenSP = tblQLSP.getValueAt(i, 1).toString();
        String giaTien = tblQLSP.getValueAt(i, 2).toString();
        String moTa = tblQLSP.getValueAt(i, 3).toString();
        String trangThai = tblQLSP.getValueAt(i, 4).toString();
        String maDM = tblQLSP.getValueAt(i, 5).toString();
        
        txtmasp.setText(maSP);
        txttensp.setText(tenSP);
        txtgiatien.setText(giaTien);
        txtmota.setText(moTa);
        
        if(trangThai.equals("Con hang")){
            rdoconhang.setSelected(true);
        }else {
            rdohethang.setSelected(true);
        }
        if(maDM.equals("DM01")){
            cbbmadanhmuc.setSelectedItem("DM01");
        }else{
            cbbmadanhmuc.setSelectedItem("DM02");
        }
        
    }
    
    void fillTable1(ArrayList<Model_DanhMuc> list){
        dtm = (DefaultTableModel) tblQLDM.getModel();
        dtm.setRowCount(0);
        for(Model_DanhMuc x:list){
            dtm.addRow(x.toDaTaRow1());
        }
    }
    void showDaTa1(int i){
        String maDM = tblQLDM.getValueAt(i,0).toString();
        String tenDM = tblQLDM.getValueAt(i,1).toString();
        String moTa = tblQLDM.getValueAt(i,2).toString();
        txtmadanhmuc.setText(maDM);
        txttendanhmuc.setText(tenDM);
        txtmotadanhmuc.setText(moTa);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtgiatien = new javax.swing.JTextField();
        txtmota = new javax.swing.JTextField();
        rdoconhang = new javax.swing.JRadioButton();
        rdohethang = new javax.swing.JRadioButton();
        cbbmadanhmuc = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLSP = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbtensp = new javax.swing.JComboBox<>();
        cbbgiatien = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbtrangThai = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtmadanhmuc = new javax.swing.JTextField();
        txttendanhmuc = new javax.swing.JTextField();
        txtmotadanhmuc = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnthemdm = new javax.swing.JButton();
        btnsuadm = new javax.swing.JButton();
        btnxoadm = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txttimkiemdm = new javax.swing.JTextField();
        btntimkiemdm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLDM = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jToolBar1.setRollover(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 250));

        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setText("Giá Tiền");

        jLabel4.setText("Mô Tả");

        jLabel5.setText("Trạng Thái");

        jLabel6.setText("Mã Danh Mục");

        buttonGroup1.add(rdoconhang);
        rdoconhang.setText("Còn hàng");

        buttonGroup1.add(rdohethang);
        rdohethang.setText("Hết hàng");

        btnthem.setBackground(new java.awt.Color(204, 204, 204));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setText("Thêm sản phẩm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(204, 204, 204));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setText("Sửa sản phẩm");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(204, 204, 204));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoa.setText("Xóa sản phẩm");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmasp)
                    .addComponent(txttensp)
                    .addComponent(txtgiatien, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoconhang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdohethang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbbmadanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoconhang)
                            .addComponent(rdohethang))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txtgiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbmadanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

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
                .addContainerGap()
                .addComponent(txttimkiem)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btntimkiem)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btntimkiem)
                .addContainerGap())
        );

        tblQLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản phẩm", "Tên Sản Phẩm", "Giá Tiền", "Mô Tả", "Trạng Thái", "Mã Danh Mục"
            }
        ));
        tblQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLSP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setText("Tên Sản Phẩm");

        jLabel8.setText("Giá Tiền");

        cbbtensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtenspActionPerformed(evt);
            }
        });

        cbbgiatien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbgiatienActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng Thái");

        cbbtrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtrangThaiActionPerformed(evt);
            }
        });

        jLabel13.setText("Mã Danh Mục");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbtensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbgiatien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbtrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 76, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbtensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbgiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbtrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        jTabbedPane1.addTab("Sản Phẩm", jToolBar1);

        jToolBar2.setRollover(true);

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin danh mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel9.setText("Mã Danh Mục");

        jLabel10.setText("Tên Danh Mục");

        jLabel11.setText("Mô Tả");

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btnthemdm.setBackground(new java.awt.Color(204, 204, 204));
        btnthemdm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthemdm.setText("Thêm Danh Mục");
        btnthemdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemdmActionPerformed(evt);
            }
        });

        btnsuadm.setBackground(new java.awt.Color(204, 204, 204));
        btnsuadm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsuadm.setText("Sửa Danh Mục");
        btnsuadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuadmActionPerformed(evt);
            }
        });

        btnxoadm.setBackground(new java.awt.Color(204, 204, 204));
        btnxoadm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoadm.setText("Xóa Danh mục");
        btnxoadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoadmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthemdm, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnsuadm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoadm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthemdm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsuadm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoadm, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmadanhmuc)
                    .addComponent(txttendanhmuc, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmotadanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtmotadanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(txtmadanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel10))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(txttendanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Danh Mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btntimkiemdm.setBackground(new java.awt.Color(204, 204, 204));
        btntimkiemdm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntimkiemdm.setText("Tìm Kiếm");
        btntimkiemdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemdmActionPerformed(evt);
            }
        });

        tblQLDM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục", "Mô Tả"
            }
        ));
        tblQLDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLDMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLDM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(txttimkiemdm, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btntimkiemdm, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiemdm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiemdm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jToolBar2.add(jPanel6);

        jTabbedPane1.addTab("Danh mục", jToolBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSPMouseClicked
        i = tblQLSP.getSelectedRow();
        this.showDaTa(i);
    }//GEN-LAST:event_tblQLSPMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String maSP = txtmasp.getText().trim();
        String tenSP = txttensp.getText().trim();
        String giaTiensp = txtgiatien.getText().trim();
        String moTa = txtmota.getText().trim();
        String trangThai;
        if(rdoconhang.isSelected()){
            trangThai = "Con hang";
        }else{
            trangThai = "Het hang";
        }
        String maDM = cbbmadanhmuc.getSelectedItem().toString();
        if(maSP.isEmpty() || tenSP.isEmpty()|| moTa.isEmpty()||trangThai.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin");
            return;
        }
        float giaTien;
        try {
             giaTien = Float.parseFloat(giaTiensp);
             if(giaTien<=0){
                 JOptionPane.showMessageDialog(this,"Giá Tiền Phải Lớn Hơn Không");
                 return;
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập học Phí là số nguyên");
            return;
        }
        
        if(repo_SP.exitByma(maSP)){
            JOptionPane.showMessageDialog(this,"Mã bị trùng ! vui lòng nhập mã khác");
            return;
        }
        Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDM);
        this.repo_SP.them(sp);
        this.fillTable(repo_SP.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Thêm sản phẩm thành công");
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        i = tblQLSP.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần sửa");
            return;
        }
        String maSP = txtmasp.getText().trim();
        String tenSP = txttensp.getText().trim();
        String giaTiensp = txtgiatien.getText().trim();
        String moTa = txtmota.getText().trim();
        String trangThai;
        if(rdoconhang.isSelected()){
            trangThai = "Con hang";
        }else{
            trangThai = "Het hang";
        }
        String maDM = cbbmadanhmuc.getSelectedItem().toString();
        if(maSP.isEmpty() || tenSP.isEmpty()|| moTa.isEmpty()||trangThai.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin");
            return;
        }
        float giaTien;
        try {
             giaTien = Float.parseFloat(giaTiensp);
             if(giaTien<=0){
                 JOptionPane.showMessageDialog(this,"Giá Tiền Phải Lớn Hơn Không");
                 return;
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập học Phí là số nguyên");
            return;
        }
        Model_SanPham sp = new Model_SanPham(maSP, tenSP, giaTien, moTa, trangThai, maDM);
        this.repo_SP.sua(sp, maSP);
        this.fillTable(repo_SP.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Sửa sản phẩm thành công");
        
        
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        i = tblQLSP.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần xóa");
            return;
        }
        String maSPcx = txtmasp.getText().trim();
        this.repo_SP.xoa(maSPcx);
        this.fillTable(repo_SP.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa Thành Công");
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String tenSPct = txttimkiem.getText().trim();
        if(repo_SP.timKiem(tenSPct).isEmpty()){
            JOptionPane.showMessageDialog(this,"Không tìm thấy danh sách theo tên vừa tìm");
        }else{
            this.fillTable(repo_SP.timKiem(tenSPct));
            JOptionPane.showMessageDialog(this,"Danh sách được tìm thấy");
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void cbbtenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtenspActionPerformed
        this.filterProducts();
    }//GEN-LAST:event_cbbtenspActionPerformed

    private void cbbgiatienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbgiatienActionPerformed
        this.filterProducts2();
    }//GEN-LAST:event_cbbgiatienActionPerformed

    private void tblQLDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLDMMouseClicked
        i = tblQLDM.getSelectedRow();
        this.showDaTa1(i);
    }//GEN-LAST:event_tblQLDMMouseClicked

    private void btnthemdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemdmActionPerformed
        String maDM = txtmadanhmuc.getText().trim();
        String tenDM = txttendanhmuc.getText().trim();
        String moTa = txtmotadanhmuc.getText().trim();
        if(maDM.isEmpty() || tenDM.isEmpty()|| moTa.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
            return;
        }
        if(repo_DanhMuc.exitByMa(maDM)){
            JOptionPane.showMessageDialog(this, "Mã bị trùng ! Vui lòng nhập mã khác");
            return;
        }
        Model_DanhMuc dm = new Model_DanhMuc(maDM, tenDM, moTa);
        this.repo_DanhMuc.them1(dm);
        this.fillTable1(repo_DanhMuc.getAll1());
        this.clearForm();
        
        JOptionPane.showMessageDialog(this, "Thêm Danh Mục Thành Công");
    }//GEN-LAST:event_btnthemdmActionPerformed

    private void btnsuadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuadmActionPerformed
        i = tblQLDM.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Bạn chưa chọn dòng cần sửa");
            return;
        }
        String maDM = txtmadanhmuc.getText().trim();
        String tenDM = txttendanhmuc.getText().trim();
        String moTa = txtmotadanhmuc.getText().trim();
        if(maDM.isEmpty() || tenDM.isEmpty()|| moTa.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
            return;
        }
        Model_DanhMuc dm = new Model_DanhMuc(maDM, tenDM, moTa);
        this.repo_DanhMuc.sua1(dm, maDM);
        this.fillTable1(repo_DanhMuc.getAll1());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Sửa danh mục thành công");
    }//GEN-LAST:event_btnsuadmActionPerformed

    private void btnxoadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoadmActionPerformed
        i = tblQLDM.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this,"Bạn chưa chọn dòng cần sửa");
            return;
        }
        String maDMcx = txtmadanhmuc.getText().trim();
        this.repo_DanhMuc.xoa1(maDMcx);
        this.fillTable1(repo_DanhMuc.getAll1());
        this.clearForm();
        JOptionPane.showMessageDialog(this,"Xóa Danh Mục Thành Công");
    }//GEN-LAST:event_btnxoadmActionPerformed

    private void btntimkiemdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemdmActionPerformed
        String tenDMct = txttimkiemdm.getText().trim();
        if(repo_DanhMuc.TimKiem1(tenDMct).isEmpty()){
            JOptionPane.showMessageDialog(this,"Không tìm thấy danh sách theo tên vừa tìm");
        }else{
            this.fillTable1(repo_DanhMuc.TimKiem1(tenDMct));
            JOptionPane.showMessageDialog(this,"Danh sách được tìm thấy");
        }
    }//GEN-LAST:event_btntimkiemdmActionPerformed

    private void cbbtrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangThaiActionPerformed
        this.filterProducts1();
    }//GEN-LAST:event_cbbtrangThaiActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnsuadm;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthemdm;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btntimkiemdm;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxoadm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbgiatien;
    private javax.swing.JComboBox<String> cbbmadanhmuc;
    private javax.swing.JComboBox<String> cbbtensp;
    private javax.swing.JComboBox<String> cbbtrangThai;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JRadioButton rdoconhang;
    private javax.swing.JRadioButton rdohethang;
    private javax.swing.JTable tblQLDM;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JTextField txtgiatien;
    private javax.swing.JTextField txtmadanhmuc;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtmotadanhmuc;
    private javax.swing.JTextField txttendanhmuc;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttimkiemdm;
    // End of variables declaration//GEN-END:variables
}
