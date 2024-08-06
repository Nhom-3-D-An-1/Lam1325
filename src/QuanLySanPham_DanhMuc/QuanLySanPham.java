/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuanLySanPham_DanhMuc;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QuanLySanPham extends javax.swing.JFrame {


    private Repo_SanPham repo_SP = new Repo_SanPham();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int i =-1;

    public QuanLySanPham() {
        initComponents();
        fillTable(repo_SP.getAll());
        // Gọi phương thức để điền dữ liệu vào các combobox
        populateFilterCombos();

        // Thiết lập hành động khi thay đổi giá trị của combobox
        cbbtensp.addActionListener(e -> filterProducts());
        cbbtrangThai.addActionListener(e -> filterProducts());
        cbbgiatien.addActionListener(e -> filterProducts());

//        this.populateFilterCombos();
//        this.populateFilterCombos1();
//        this.populateFilterCombos2();
    }
//        private void populateFilterCombos() {
//            cbbtensp.addItem("All");
//            for (Model_SanPham sp : repo_SP.getAll()) {
//                cbbtensp.addItem(sp.getTenSP());
//            }
//        }
//        private void filterProducts() {
//            String selectedName = cbbtensp.getSelectedItem().toString();
//            ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
//            if (!selectedName.equals("All")) {
//                filteredList = repo_SP.filterByName(selectedName);
//            }
//             
//             
//            fillTable(filteredList);
//        }
//        
//        
//        private void populateFilterCombos1(){
//            cbbtrangThai.addItem("All");
//            cbbtrangThai.addItem("Con hang");
//            cbbtrangThai.addItem("Het hang");
//        }
//        private void filterProducts1(){
//            String selectedtrangThai = cbbtrangThai.getSelectedItem().toString();
//            ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
//            if(!selectedtrangThai.equals("All")){
//                switch(selectedtrangThai){
//                    case "Con hang":
//                        filteredList = repo_SP.filterByTrangThai("Con hang");
//                        break;
//                    case "Het hang":
//                        filteredList = repo_SP.filterByTrangThai("Het hang");
//                        break;
//                }
//            }
//            fillTable(filteredList);
//        }
//        private void  populateFilterCombos2(){
//            cbbgiatien.addItem("All");
//            cbbgiatien.addItem("<=10000");
//            cbbgiatien.addItem("10000 - 30000");
//            cbbgiatien.addItem(">30000");
//        }
//        private void filterProducts2(){
//            String selectedPriceRange = cbbgiatien.getSelectedItem().toString();
//            ArrayList<Model_SanPham> filteredList = repo_SP.getAll();
//            if (!selectedPriceRange.equals("All")) {
//                switch (selectedPriceRange) {
//                    case "<=10000":
//                        filteredList = repo_SP.filterByPriceRange(0, 10000);
//                        break;
//                    case "10000 - 30000":
//                        filteredList = repo_SP.filterByPriceRange(10001, 30000);
//                        break;
//                    case ">30000":
//                        filteredList = repo_SP.filterByPriceRange(30001, Float.MAX_VALUE);
//                        break;
//                }
//            }
//            fillTable(filteredList);
//        }
    private void populateFilterCombos() {
    cbbtensp.addItem("All");
    for (Model_SanPham sp : repo_SP.getAll()) {
        cbbtensp.addItem(sp.getTenSP());
    }

    cbbtrangThai.addItem("All");
    cbbtrangThai.addItem("Còn hàng");
    cbbtrangThai.addItem("Hết hàng");

    cbbgiatien.addItem("All");
    cbbgiatien.addItem("<=10000");
    cbbgiatien.addItem("10000 - 30000");
    cbbgiatien.addItem(">30000");
}
    private void filterProducts() {
    // Kiểm tra null và gán giá trị mặc định
    String selectedName = cbbtensp.getSelectedItem() != null ? cbbtensp.getSelectedItem().toString() : "All";
    String selectedTrangThai = cbbtrangThai.getSelectedItem() != null ? cbbtrangThai.getSelectedItem().toString() : "All";
    String selectedPriceRange = cbbgiatien.getSelectedItem() != null ? cbbgiatien.getSelectedItem().toString() : "All";

    // Thiết lập bộ lọc tên
    String nameFilter = selectedName.equals("All") ? "" : selectedName;
    // Thiết lập bộ lọc trạng thái
    String trangThaiFilter = selectedTrangThai.equals("All") ? "" : selectedTrangThai;

    // Thiết lập bộ lọc giá
    float minPrice = 0;
    float maxPrice = Float.MAX_VALUE;

    switch (selectedPriceRange) {
        case "<=10000":
            maxPrice = 10000;
            break;
        case "10000 - 30000":
            minPrice = 10001;
            maxPrice = 30000;
            break;
        case ">30000":
            minPrice = 30001;
            break;
    }

    // Lọc sản phẩm dựa trên tên, giá và trạng thái
    ArrayList<Model_SanPham> filteredList = repo_SP.filterProducts(nameFilter, minPrice, maxPrice, trangThaiFilter);
    fillTable(filteredList);
}



        
    void clearForm(){
        txtmasp.setText("");
        txttensp.setText("");
        txtgiatien.setText("");
        rdoconhang.setSelected(true);
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
        String soLuong = tblQLSP.getValueAt(i, 2).toString();
        String giaTien = tblQLSP.getValueAt(i, 3).toString();
        String trangThai = tblQLSP.getValueAt(i, 4).toString();
//        txtmasp.disable(); // không cho phép sửa mã khi thực hiện sửa
        txtmasp.setText(maSP);
        txttensp.setText(tenSP);
        txtsoluong.setText(soLuong);
        txtgiatien.setText(giaTien);
        
        if(trangThai.equals("Hết hàng")){
            rdohethang.setSelected(true);
        }else {
            rdoconhang.setSelected(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtgiatien = new javax.swing.JTextField();
        rdoconhang = new javax.swing.JRadioButton();
        rdohethang = new javax.swing.JRadioButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        btnhienthi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
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

        jLabel5.setText("Trạng Thái");

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

        btnlammoi.setBackground(new java.awt.Color(204, 204, 204));
        btnlammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlammoi.setText("Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnhienthi.setBackground(new java.awt.Color(204, 204, 204));
        btnhienthi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnhienthi.setText("Làm Mới table");
        btnhienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhienthiActionPerformed(evt);
            }
        });

        jLabel4.setText("Số Lượng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmasp, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(txttensp)
                    .addComponent(txtsoluong))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnhienthi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtgiatien, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(btnlammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoconhang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdohethang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnlammoi)
                            .addComponent(btnhienthi)
                            .addComponent(jLabel4)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtgiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(rdoconhang)
                            .addComponent(rdohethang))))
                .addContainerGap(63, Short.MAX_VALUE))
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
                "Mã Sản phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền", "Trạng Thái"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
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
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addComponent(cbbtrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(82, Short.MAX_VALUE))
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        jTabbedPane1.addTab("Sản Phẩm", jToolBar1);

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
        String soLuongstr = txtsoluong.getText().trim();
        String giaTiensp = txtgiatien.getText().trim();
        String trangThai;
        if(rdohethang.isSelected()){
            trangThai = "Hết hàng";
        }else{
            trangThai = "Còn hàng";
        }
        String regex = "^[a-zA-Z0-9]+$";
        if(maSP.isEmpty() || tenSP.isEmpty()||trangThai.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin");
            return;
        }
         if(!maSP.matches(regex)) {
        JOptionPane.showMessageDialog(this, "chỉ được nhập chữ và số,không được nhập khoảng trắng ");
        return;
    }
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongstr);
            if(soLuong<=0){
                JOptionPane.showMessageDialog(this, "Số Lượng phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số nguyên");
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
            JOptionPane.showMessageDialog(this,"Vui lòng nhập giá tiền là số nguyên");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return; // User chose not to proceed
            }
        if(repo_SP.exitByma(maSP)){
            JOptionPane.showMessageDialog(this,"Mã bị trùng ! vui lòng nhập mã khác");
            return;
        }
        Model_SanPham sp = new Model_SanPham(maSP, tenSP, soLuong,giaTien, trangThai);
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
        String soLuongstr = txtsoluong.getText().trim();
        String giaTiensp = txtgiatien.getText().trim();
        String trangThai;
        if(rdoconhang.isSelected()){
            trangThai = "Còn hàng";
        }else{
            trangThai = "Hết hàng";
        }
        if(maSP.isEmpty() || tenSP.isEmpty()||trangThai.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin");
            return;
        }

        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongstr);
            if(soLuong<=0){
                JOptionPane.showMessageDialog(this, "Số Lượng phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số nguyên");
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
            JOptionPane.showMessageDialog(this,"Vui lòng nhập giá tiền là số nguyên");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return; // User chose not to proceed
            }
        Model_SanPham sp = new Model_SanPham(maSP, tenSP,soLuong, giaTien, trangThai);
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
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return; // User chose not to proceed
            }
        this.repo_SP.xoa(maSPcx);
        this.fillTable(repo_SP.getAll());
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa Thành Công");
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed

          String tenSPct = txttimkiem.getText().trim();
          String trangThaict = txttimkiem.getText().trim();
          if(repo_SP.timKiem(tenSPct, trangThaict).isEmpty()){
              JOptionPane.showMessageDialog(this,"Không tìm thấy danh sách cần tìm");
          }else{
              this.fillTable(repo_SP.timKiem(tenSPct, trangThaict));
              JOptionPane.showMessageDialog(this,"Danh sách được tìm thấy");
          }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void cbbtenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtenspActionPerformed
        this.filterProducts();
           
    }//GEN-LAST:event_cbbtenspActionPerformed

    private void cbbgiatienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbgiatienActionPerformed
        this.filterProducts();

    }//GEN-LAST:event_cbbgiatienActionPerformed

    private void cbbtrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangThaiActionPerformed
        this.filterProducts();

    }//GEN-LAST:event_cbbtrangThaiActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        txtmasp.setText("");
        txttensp.setText("");
        txtsoluong.setText("");
        txtgiatien.setText("");
        rdoconhang.setSelected(true);
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnhienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhienthiActionPerformed
        this.fillTable(repo_SP.getAll());
    }//GEN-LAST:event_btnhienthiActionPerformed

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
    private javax.swing.JButton btnhienthi;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbgiatien;
    private javax.swing.JComboBox<String> cbbtensp;
    private javax.swing.JComboBox<String> cbbtrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rdoconhang;
    private javax.swing.JRadioButton rdohethang;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JTextField txtgiatien;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
