/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Main;

import library.crudData.tambahBuku;
import library.crudData.tambahAnggota;
import library.crudData.tambahStaff;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import library.Mysql.MysqlCon;
import javax.swing.JOptionPane;
import library.crudData.crud;

/**
 *
 * @author My Computer
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    DefaultTableModel model = new DefaultTableModel(new String[]{"ISBN", "Judul", "Penerbit", "Tahun Buku", "Tanggal Pengadaan", "Pengarang", "Lokasi"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
    public Main() {
        initComponents();
        
//        this.pengarangL.setVisible(false);
//        this.penerbitL.setVisible(false);
//        this.kategoriL.setVisible(false);
//        this.sumberL.setVisible(false);
//        this.rakL.setVisible(false);
//        
//        this.pengarangCB.setVisible(false);
//        this.penerbitCB.setVisible(false);
//        this.kategoriCB.setVisible(false);
//        this.sumberCB.setVisible(false);
//        this.rakCB.setVisible(false);
//        
//        this.cariTF.setVisible(false);
//        this.tambahbukuB.setVisible(false);
//        this.editbukuB.setVisible(false);
//        this.hapusbukuB.setVisible(false);
//        this.cariB.setVisible(false);
//        
//        this.title.setText("Buku");
//        this.panelBawah.add(bukuPanel);
MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"ISBN", "Judul", "Penerbit", "Tahun Buku", "Tanggal Pengadaan", "Pengarang", "Lokasi"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            String t;
            String y;
            String u;

            try {
                rs = stmt.executeQuery("select * from library.book");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("penerbit");
                r = rs.getString("thn_buku");
                t = rs.getString("tgl_pengadaan");
                y = rs.getString("pengarang");
                u = rs.getString("lokasi");
                
                model.addRow(new Object[]{q, w, e, r, t,y,u});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }

        this.titleBuku.setText("Buku");
        panelBawah.removeAll();
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model);
        panelBawah.repaint();
        panelBawah.revalidate();
        editbukuB.setEnabled(false);
    }
    
    
    public Main(String name) {
        initComponents();
        
        MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"ISBN", "Judul", "Penerbit", "Tahun Buku", "Tanggal Pengadaan", "Pengarang", "Lokasi"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            String t;
            String y;
            String u;

            try {
                rs = stmt.executeQuery("select * from library.book");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("penerbit");
                r = rs.getString("thn_buku");
                t = rs.getString("tgl_pengadaan");
                y = rs.getString("pengarang");
                u = rs.getString("lokasi");
                
                model.addRow(new Object[]{q, w, e, r, t,y,u});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleBuku.setText("Buku");
        LabelUser.setText(name);
        panelBawah.removeAll();
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model);
        panelBawah.repaint();
        panelBawah.revalidate();
        editbukuB.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bukuB = new javax.swing.JButton();
        siswaB = new javax.swing.JButton();
        staffB = new javax.swing.JButton();
        settingB = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        peminjamanB = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        pengembalianB = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        datapinjamB = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        panelBawah = new javax.swing.JPanel();
        pengaturanPanel = new javax.swing.JPanel();
        titlePengaturan = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        settingTable = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        datapinjamPanel = new javax.swing.JPanel();
        titleDatapinjam = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        pinjamTable = new javax.swing.JTable();
        pengembalianPanel = new javax.swing.JPanel();
        titlePengembalian = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        JCariAnggotaKembali = new javax.swing.JTextField();
        CariAnggotaKembaliB = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        JCariBukuKembali = new javax.swing.JTextField();
        CariBukuKembaliB = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        BukuKembaliTable = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        peminjamanPanel = new javax.swing.JPanel();
        titlePeminjaman = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JCariIdPinjam = new javax.swing.JTextField();
        CariPinjamAnggotaB = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LabelIDPinjam = new javax.swing.JLabel();
        LabelNamaPinjam = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LabelAlamatPinjam = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LabelDurasi = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        LabelTeleponPinjam = new javax.swing.JLabel();
        LabelDurasi1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JBukuPinjam = new javax.swing.JTextField();
        CariBukuPinjamB = new javax.swing.JButton();
        ScrollPanelPinjam = new javax.swing.JScrollPane();
        BukuPinjamTable = new javax.swing.JTable();
        SimpanPinjamB = new javax.swing.JButton();
        staffPanel = new javax.swing.JPanel();
        titleStaff = new javax.swing.JLabel();
        tambahstaffB = new javax.swing.JButton();
        editstaffB = new javax.swing.JButton();
        hapusstaffB = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        siswaPanel = new javax.swing.JPanel();
        titleSiswa = new javax.swing.JLabel();
        angkatanSiswaCB = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        JcariAnggota = new javax.swing.JTextField();
        cariAnggotaB = new javax.swing.JButton();
        tambahsiswaB = new javax.swing.JButton();
        editsiswaB = new javax.swing.JButton();
        hapussiswaB = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        anggotaTable = new javax.swing.JTable();
        bukuPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bukuTabel = new javax.swing.JTable();
        titleBuku = new javax.swing.JLabel();
        tambahbukuB = new javax.swing.JButton();
        editbukuB = new javax.swing.JButton();
        hapusbukuB = new javax.swing.JButton();
        cariTF = new javax.swing.JTextField();
        cariB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIstem Pengelolaan Perpustakaan (v 0.0.1)");

        panelAtas.setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        bukuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buku.png"))); // NOI18N
        bukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuBActionPerformed(evt);
            }
        });

        siswaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/siswa.png"))); // NOI18N
        siswaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siswaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siswaBActionPerformed(evt);
            }
        });

        staffB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        staffB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        staffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBActionPerformed(evt);
            }
        });

        settingB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/setting.png"))); // NOI18N
        settingB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Buku");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Siswa");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Staff");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Pengaturan");

        peminjamanB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/peminjaman.png"))); // NOI18N
        peminjamanB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        peminjamanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanBActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Peminjaman");

        pengembalianB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/pengembalian.png"))); // NOI18N
        pengembalianB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pengembalianB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengembalianBActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Pengembalian");

        datapinjamB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/datapinjam.png"))); // NOI18N
        datapinjamB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datapinjamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datapinjamBActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Data Pinjam");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(siswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel25)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel27)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(peminjamanB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pengembalianB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(siswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(staffB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(peminjamanB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pengembalianB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(settingB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(jLabel30)
                                .addComponent(jLabel31)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang,");

        LabelUser.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("<Username>");

        jButton11.setBackground(new java.awt.Color(51, 153, 255));
        jButton11.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Logout");
        jButton11.setBorder(null);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(589, 589, 589)
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUser)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panelAtas, java.awt.BorderLayout.PAGE_START);

        panelBawah.setBackground(new java.awt.Color(255, 255, 255));
        panelBawah.setLayout(new java.awt.CardLayout());

        pengaturanPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengaturan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengaturan.setForeground(new java.awt.Color(51, 51, 51));
        titlePengaturan.setText("Title");

        jPanel21.setBackground(new java.awt.Color(51, 153, 255));

        settingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane19.setViewportView(settingTable);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1395, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
        );

        jScrollPane18.setViewportView(jPanel22);

        jButton16.setBackground(new java.awt.Color(0, 204, 0));
        jButton16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Tambah Operator Baru");
        jButton16.setBorder(null);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(255, 204, 0));
        jButton17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Edit");
        jButton17.setBorder(null);
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton18.setBackground(new java.awt.Color(255, 0, 0));
        jButton18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Hapus");
        jButton18.setBorder(null);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout pengaturanPanelLayout = new javax.swing.GroupLayout(pengaturanPanel);
        pengaturanPanel.setLayout(pengaturanPanelLayout);
        pengaturanPanelLayout.setHorizontalGroup(
            pengaturanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengaturanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengaturanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pengaturanPanelLayout.createSequentialGroup()
                        .addComponent(titlePengaturan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pengaturanPanelLayout.setVerticalGroup(
            pengaturanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengaturanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePengaturan)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBawah.add(pengaturanPanel, "card8");

        datapinjamPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleDatapinjam.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleDatapinjam.setText("Title");

        jTextField7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton10.setBackground(new java.awt.Color(51, 153, 255));
        jButton10.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Cari");
        jButton10.setBorder(null);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel16.setBackground(new java.awt.Color(51, 153, 255));

        pinjamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(pinjamTable);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane12.setViewportView(jPanel16);

        javax.swing.GroupLayout datapinjamPanelLayout = new javax.swing.GroupLayout(datapinjamPanel);
        datapinjamPanel.setLayout(datapinjamPanelLayout);
        datapinjamPanelLayout.setHorizontalGroup(
            datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datapinjamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
                    .addGroup(datapinjamPanelLayout.createSequentialGroup()
                        .addComponent(titleDatapinjam)
                        .addGap(65, 65, 65)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        datapinjamPanelLayout.setVerticalGroup(
            datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datapinjamPanelLayout.createSequentialGroup()
                .addGroup(datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datapinjamPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleDatapinjam))
                    .addGroup(datapinjamPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBawah.add(datapinjamPanel, "card14");

        pengembalianPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengembalian.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengembalian.setForeground(new java.awt.Color(51, 51, 51));
        titlePengembalian.setText("Title");

        jPanel12.setBackground(new java.awt.Color(51, 153, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setText("Nama");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setText("Kelas");

        nama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama.setText("<nama>");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("<kelas>");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel47.setText("Maks. Pinjam");

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("<maks. pinjam>");

        jLabel52.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel52.setText("Tanggungan");

        jLabel53.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel53.setText("<jenis pinjam>");

        jLabel54.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel54.setText("Tanggungan");

        jLabel58.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel58.setText("Jenis Anggota");

        jLabel59.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel59.setText("Durasi Pinjam");

        jLabel60.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel60.setText("<durasi pinjam>");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel40))
                .addGap(103, 103, 103)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama)
                    .addComponent(jLabel41))
                .addGap(121, 121, 121)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel52))
                .addGap(68, 68, 68)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel54))
                .addGap(74, 74, 74)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel58))
                .addGap(71, 71, 71)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel60))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel60))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel58)
                            .addComponent(jLabel38)
                            .addComponent(nama))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel54)
                            .addComponent(jLabel59)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel42.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Kode Anggota");

        JCariAnggotaKembali.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        CariAnggotaKembaliB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CariAnggotaKembaliB.setText("Cari");
        CariAnggotaKembaliB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CariAnggotaKembaliB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariAnggotaKembaliBActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Kode Buku");

        JCariBukuKembali.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        CariBukuKembaliB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CariBukuKembaliB.setText("Cari");
        CariBukuKembaliB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CariBukuKembaliB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariBukuKembaliBActionPerformed(evt);
            }
        });

        BukuKembaliTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(BukuKembaliTable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setText("Total Denda");

        jLabel45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setText("Rp");

        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("<nominaldenda>");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(40, 40, 40)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setBackground(new java.awt.Color(51, 204, 0));
        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Simpan");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setText("Baru");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(63, 63, 63)
                                .addComponent(JCariAnggotaKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(CariAnggotaKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(142, 142, 142)
                                .addComponent(JCariBukuKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(CariBukuKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(JCariAnggotaKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariAnggotaKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCariBukuKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CariBukuKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pengembalianPanelLayout = new javax.swing.GroupLayout(pengembalianPanel);
        pengembalianPanel.setLayout(pengembalianPanelLayout);
        pengembalianPanelLayout.setHorizontalGroup(
            pengembalianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengembalianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePengembalian)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pengembalianPanelLayout.setVerticalGroup(
            pengembalianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePengembalian)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        panelBawah.add(pengembalianPanel, "card15");

        peminjamanPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePeminjaman.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePeminjaman.setForeground(new java.awt.Color(51, 51, 51));
        titlePeminjaman.setText("Title");

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Anggota");

        JCariIdPinjam.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        CariPinjamAnggotaB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CariPinjamAnggotaB.setText("Cari");
        CariPinjamAnggotaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CariPinjamAnggotaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariPinjamAnggotaBActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Kode Anggota");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Nama");

        LabelIDPinjam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelIDPinjam.setText("<NIS/KA>");

        LabelNamaPinjam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelNamaPinjam.setText("<Nama>");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Alamat");

        LabelAlamatPinjam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelAlamatPinjam.setText("<Alamat>");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("No Telepon");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Durasi Pinjam");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("3 buku");

        LabelDurasi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelDurasi.setText("3");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Maks. Pinjam");

        LabelTeleponPinjam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelTeleponPinjam.setText("<No Telepon>");

        LabelDurasi1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelDurasi1.setText("hari");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(73, 73, 73)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNamaPinjam)
                    .addComponent(LabelIDPinjam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addGap(108, 108, 108)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelAlamatPinjam)
                    .addComponent(LabelTeleponPinjam))
                .addGap(61, 61, 61)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel26))
                .addGap(68, 68, 68)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(LabelDurasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelDurasi1)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel19))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel26)
                            .addComponent(LabelAlamatPinjam))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelDurasi)
                                .addComponent(LabelDurasi1))
                            .addComponent(LabelTeleponPinjam)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(LabelIDPinjam)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNamaPinjam)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(71, 71, 71)
                        .addComponent(JCariIdPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CariPinjamAnggotaB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JCariIdPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariPinjamAnggotaB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(51, 153, 255));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Kode Buku");

        JBukuPinjam.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        CariBukuPinjamB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CariBukuPinjamB.setText("Cari");
        CariBukuPinjamB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CariBukuPinjamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariBukuPinjamBActionPerformed(evt);
            }
        });

        ScrollPanelPinjam.setBackground(new java.awt.Color(255, 255, 255));

        BukuPinjamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPanelPinjam.setViewportView(BukuPinjamTable);

        SimpanPinjamB.setBackground(new java.awt.Color(51, 204, 0));
        SimpanPinjamB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SimpanPinjamB.setForeground(new java.awt.Color(255, 255, 255));
        SimpanPinjamB.setText("Simpan");
        SimpanPinjamB.setBorder(null);
        SimpanPinjamB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SimpanPinjamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanPinjamBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanelPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(146, 146, 146)
                        .addComponent(JBukuPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CariBukuPinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SimpanPinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(JBukuPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariBukuPinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScrollPanelPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SimpanPinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout peminjamanPanelLayout = new javax.swing.GroupLayout(peminjamanPanel);
        peminjamanPanel.setLayout(peminjamanPanelLayout);
        peminjamanPanelLayout.setHorizontalGroup(
            peminjamanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(peminjamanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePeminjaman)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        peminjamanPanelLayout.setVerticalGroup(
            peminjamanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePeminjaman)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        panelBawah.add(peminjamanPanel, "card9");

        staffPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleStaff.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleStaff.setForeground(new java.awt.Color(51, 51, 51));
        titleStaff.setText("Title");

        tambahstaffB.setBackground(new java.awt.Color(0, 153, 0));
        tambahstaffB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tambahstaffB.setForeground(new java.awt.Color(255, 255, 255));
        tambahstaffB.setText("Tambah");
        tambahstaffB.setBorder(null);
        tambahstaffB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahstaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahstaffBActionPerformed(evt);
            }
        });

        editstaffB.setBackground(new java.awt.Color(255, 153, 0));
        editstaffB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editstaffB.setForeground(new java.awt.Color(255, 255, 255));
        editstaffB.setText("Edit");
        editstaffB.setBorder(null);
        editstaffB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editstaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editstaffBActionPerformed(evt);
            }
        });

        hapusstaffB.setBackground(new java.awt.Color(255, 0, 0));
        hapusstaffB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hapusstaffB.setForeground(new java.awt.Color(255, 255, 255));
        hapusstaffB.setText("Hapus");
        hapusstaffB.setBorder(null);
        hapusstaffB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusstaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusstaffBActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staffTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffTableFocusGained(evt);
            }
        });
        jScrollPane7.setViewportView(staffTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel3);

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleStaff)
                            .addGroup(staffPanelLayout.createSequentialGroup()
                                .addComponent(tambahstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapusstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleStaff)
                .addGap(23, 23, 23)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        panelBawah.add(staffPanel, "card5");

        siswaPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleSiswa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleSiswa.setForeground(new java.awt.Color(51, 51, 51));
        titleSiswa.setText("Title");

        angkatanSiswaCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        angkatanSiswaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Angkatan");

        JcariAnggota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cariAnggotaB.setBackground(new java.awt.Color(51, 153, 255));
        cariAnggotaB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariAnggotaB.setForeground(new java.awt.Color(255, 255, 255));
        cariAnggotaB.setText("Cari");
        cariAnggotaB.setBorder(null);
        cariAnggotaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariAnggotaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAnggotaBActionPerformed(evt);
            }
        });

        tambahsiswaB.setBackground(new java.awt.Color(51, 153, 0));
        tambahsiswaB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tambahsiswaB.setForeground(new java.awt.Color(255, 255, 255));
        tambahsiswaB.setText("Tambah");
        tambahsiswaB.setBorder(null);
        tambahsiswaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahsiswaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahsiswaBActionPerformed(evt);
            }
        });

        editsiswaB.setBackground(new java.awt.Color(255, 153, 0));
        editsiswaB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editsiswaB.setForeground(new java.awt.Color(255, 255, 255));
        editsiswaB.setText("Edit");
        editsiswaB.setBorder(null);
        editsiswaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editsiswaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsiswaBActionPerformed(evt);
            }
        });

        hapussiswaB.setBackground(new java.awt.Color(255, 0, 0));
        hapussiswaB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hapussiswaB.setForeground(new java.awt.Color(255, 255, 255));
        hapussiswaB.setText("Hapus");
        hapussiswaB.setBorder(null);
        hapussiswaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapussiswaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapussiswaBActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        anggotaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        anggotaTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                anggotaTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                anggotaTableFocusLost(evt);
            }
        });
        jScrollPane10.setViewportView(anggotaTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel2);

        javax.swing.GroupLayout siswaPanelLayout = new javax.swing.GroupLayout(siswaPanel);
        siswaPanel.setLayout(siswaPanelLayout);
        siswaPanelLayout.setHorizontalGroup(
            siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(siswaPanelLayout.createSequentialGroup()
                        .addComponent(titleSiswa)
                        .addGap(51, 51, 51)
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addGroup(siswaPanelLayout.createSequentialGroup()
                                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(siswaPanelLayout.createSequentialGroup()
                                        .addComponent(angkatanSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JcariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(siswaPanelLayout.createSequentialGroup()
                                        .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(cariAnggotaB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        siswaPanelLayout.setVerticalGroup(
            siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleSiswa)
                    .addGroup(siswaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(angkatanSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariAnggotaB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        panelBawah.add(siswaPanel, "card3");

        bukuPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));

        bukuTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bukuTabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bukuTabelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bukuTabelFocusLost(evt);
            }
        });
        bukuTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bukuTabelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bukuTabel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel7);

        titleBuku.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleBuku.setForeground(new java.awt.Color(51, 51, 51));
        titleBuku.setText("Title");

        tambahbukuB.setBackground(new java.awt.Color(0, 153, 0));
        tambahbukuB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tambahbukuB.setForeground(new java.awt.Color(255, 255, 255));
        tambahbukuB.setText("Tambah");
        tambahbukuB.setBorder(null);
        tambahbukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahbukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbukuBActionPerformed(evt);
            }
        });

        editbukuB.setBackground(new java.awt.Color(255, 153, 0));
        editbukuB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editbukuB.setForeground(new java.awt.Color(255, 255, 255));
        editbukuB.setText("Edit");
        editbukuB.setBorder(null);
        editbukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editbukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbukuBActionPerformed(evt);
            }
        });

        hapusbukuB.setBackground(new java.awt.Color(255, 0, 0));
        hapusbukuB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hapusbukuB.setForeground(new java.awt.Color(255, 255, 255));
        hapusbukuB.setText("Hapus");
        hapusbukuB.setBorder(null);
        hapusbukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusbukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbukuBActionPerformed(evt);
            }
        });

        cariTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cariB.setBackground(new java.awt.Color(51, 153, 255));
        cariB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariB.setForeground(new java.awt.Color(255, 255, 255));
        cariB.setText("Cari");
        cariB.setBorder(null);
        cariB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bukuPanelLayout = new javax.swing.GroupLayout(bukuPanel);
        bukuPanel.setLayout(bukuPanelLayout);
        bukuPanelLayout.setHorizontalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addComponent(titleBuku)
                        .addGap(53, 53, 53)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bukuPanelLayout.createSequentialGroup()
                                .addComponent(tambahbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bukuPanelLayout.createSequentialGroup()
                                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bukuPanelLayout.setVerticalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBuku)
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambahbukuB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hapusbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        panelBawah.add(bukuPanel, "card2");

        getContentPane().add(panelBawah, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void settingBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBActionPerformed
        // TODO add your handling code here:
       MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"Username", "Password"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            
            try {
                rs = stmt.executeQuery("select * from library.users");
                while(rs.next()){
                q = rs.getString("username");
                w = rs.getString("password");
                model.addRow(new Object[]{q, w});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        
        this.titlePengaturan.setText("Pengaturan");
        panelBawah.removeAll();
        panelBawah.add(pengaturanPanel);
        settingTable.setModel(model);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_settingBActionPerformed

    private void bukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuBActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            String t;
            String y;
            String u;
            
            try {
                rs = stmt.executeQuery("select * from library.book");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("penerbit");
                r = rs.getString("thn_buku");
                t = rs.getString("tgl_pengadaan");
                y = rs.getString("pengarang");
                u = rs.getString("lokasi");
                model.addRow(new Object[]{q, w, e, r, t,y,u});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleBuku.setText("Buku");
        panelBawah.removeAll();
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model);
        editbukuB.setEnabled(false);
        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
        
    }//GEN-LAST:event_bukuBActionPerformed

    private void siswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siswaBActionPerformed
        // TODO add your handling code here:
        
        MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nama", "Alamat", "No Telepon"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            
            try {
                rs = stmt.executeQuery("select * from library.anggota");
                while(rs.next()){
                q = rs.getString("id");
                w = rs.getString("nama");
                e = rs.getString("alamat");
                r = rs.getString("no_telp");
                model.addRow(new Object[]{q, w, e, r});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleSiswa.setText("Siswa");
        panelBawah.removeAll();
        panelBawah.add(siswaPanel);
        anggotaTable.setModel(model);
        editsiswaB.setEnabled(false);
         hapussiswaB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_siswaBActionPerformed

    private void tambahbukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbukuBActionPerformed
        // TODO add your handling code here:
        tambahBuku tb = new tambahBuku();
        tb.setVisible(true);
    }//GEN-LAST:event_tambahbukuBActionPerformed

    private void editbukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbukuBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = bukuTabel.getSelectedRow();
        String value = bukuTabel.getModel().getValueAt(row, column).toString();
        tambahBuku eb = new tambahBuku(value);
        eb.setVisible(true);

    }//GEN-LAST:event_editbukuBActionPerformed

    private void bukuTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuTabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bukuTabelMouseClicked

    private void peminjamanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanBActionPerformed
        // TODO add your handling code here:
        this.titlePeminjaman.setText("Peminjaman");
        panelBawah.removeAll();
        panelBawah.add(peminjamanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_peminjamanBActionPerformed

    private void pengembalianBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengembalianBActionPerformed
        // TODO add your handling code here:
        this.titlePengembalian.setText("Pengembalian");
        panelBawah.removeAll();
        panelBawah.add(pengembalianPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_pengembalianBActionPerformed

    private void datapinjamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datapinjamBActionPerformed
        // TODO add your handling code here:
        
        MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"No Transaksi", "Nama", "ISBN", "Judul", "Tanggal Pinjam", "Tanggal Kembali", "Denda"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            String t;
            String y;
            String u;
            
            try {
                rs = stmt.executeQuery("select * from library.pinjam");
                while(rs.next()){
                q = rs.getString("id_transaksi");
                w = rs.getString("nama");
                e = rs.getString("ISBN");
                r = rs.getString("judul");
                t = rs.getString("t_pinjam");
                y = rs.getString("t_kembali");
                u = rs.getString("denda");
                model.addRow(new Object[]{q, w, e, r, t,y,u});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        
        this.titleDatapinjam.setText("Data Pinjam");
        panelBawah.removeAll();
        panelBawah.add(datapinjamPanel);
        pinjamTable.setModel(model);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_datapinjamBActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void staffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBActionPerformed
        // TODO add your handling code here:
        editstaffB.setEnabled(false);
        hapusstaffB.setEnabled(false);
        MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nama", "Alamat", "No Telepon"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        
        Statement stmt = send.query();
            ResultSet rs;
           
            String q;
            String w;
            String e;
            String r;
            
            try {
                rs = stmt.executeQuery("select * from library.users");
                while(rs.next()){
                q = rs.getString("id");
                w = rs.getString("nama");
                e = rs.getString("alamat");
                r = rs.getString("no_telp");
                model.addRow(new Object[]{q, w, e, r});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleStaff.setText("Staff");
        panelBawah.removeAll();
        panelBawah.add(staffPanel);
        staffTable.setModel(model);
        panelBawah.repaint();
        panelBawah.revalidate();
        
    }//GEN-LAST:event_staffBActionPerformed

    private void hapusbukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbukuBActionPerformed
        crud n = new crud();
        int column = 0;
        int row = bukuTabel.getSelectedRow();
        String value = bukuTabel.getModel().getValueAt(row, column).toString();
        n.deleteBuku(value);
    }//GEN-LAST:event_hapusbukuBActionPerformed

    private void tambahsiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahsiswaBActionPerformed
        // TODO add your handling code here:
        tambahAnggota ta = new tambahAnggota();
        ta.setVisible(true);
    }//GEN-LAST:event_tambahsiswaBActionPerformed

    private void editsiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsiswaBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = anggotaTable.getSelectedRow();
        String value = anggotaTable.getModel().getValueAt(row, column).toString();
        tambahAnggota et = new tambahAnggota(value);
        et.setVisible(true);
    }//GEN-LAST:event_editsiswaBActionPerformed

    private void hapussiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapussiswaBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = anggotaTable.getSelectedRow();
        String value = anggotaTable.getModel().getValueAt(row, column).toString();
        n.deleteAnggota(value);
    }//GEN-LAST:event_hapussiswaBActionPerformed

    private void anggotaTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anggotaTableFocusGained
        // TODO add your handling code here:
        editsiswaB.setEnabled(true);
        hapussiswaB.setEnabled(true);
    }//GEN-LAST:event_anggotaTableFocusGained

    private void bukuTabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bukuTabelFocusGained
        // TODO add your handling code here:
        editbukuB.setEnabled(true);
        hapusbukuB.setEnabled(true);
    }//GEN-LAST:event_bukuTabelFocusGained

    private void bukuTabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bukuTabelFocusLost
        // TODO add your handling code here:
//        editbukuB.setEnabled(false);
    }//GEN-LAST:event_bukuTabelFocusLost

    private void anggotaTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anggotaTableFocusLost
        // TODO add your handling code here:
//        editsiswaB.setEnabled(false);
    }//GEN-LAST:event_anggotaTableFocusLost

    private void cariBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBActionPerformed
        model.setRowCount(0);
        try {
            // TODO add your handling code here:
            MysqlCon send = new MysqlCon( );
            
            String c = cariTF.getText();
            Statement stmt = send.query();
            ResultSet rs;
            rs = stmt.executeQuery("Select * from library.book where book.ISBN like '" + c + "'" + "or book.Penerbit like '" + c + "'" + "or book.Pengarang like '" + c + "'" + "or book.thn_buku like '" + c + "'" + "or book.Judul like '" + c + "'" + "or book.lokasi like '" + c + "'");
            
            String q;
            String w;
            String e;
            String r;
            String t;
            String y;
            String u;
            
             while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("penerbit");
                r = rs.getString("thn_buku");
                t = rs.getString("tgl_pengadaan");
                y = rs.getString("pengarang");
                u = rs.getString("lokasi");
                model.addRow(new Object[]{q, w, e, r, t,y,u});}
                
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        bukuTabel.setModel(model);
    }//GEN-LAST:event_cariBActionPerformed

    private void cariAnggotaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariAnggotaBActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        try {
            // TODO add your handling code here:
            MysqlCon send = new MysqlCon( );
            
            String c = JcariAnggota.getText();
            Statement stmt = send.query();
            ResultSet rs;
            rs = stmt.executeQuery("Select * from library.anggota where anggota.id like '" + c + "'" + "or anggota.nama like'" + c + "'" + "or anggota.alamat like '" + c + "'" + "or anggota.no_telp like '" + c + "'");
            
            String q;
            String w;
            String e;
            String r;
            
             while(rs.next()){
                q = rs.getString("id");
                w = rs.getString("nama");
                e = rs.getString("alamat");
                r = rs.getString("no_telp");
                model.addRow(new Object[]{q, w, e, r});}
                
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        anggotaTable.setModel(model);
    }//GEN-LAST:event_cariAnggotaBActionPerformed

    private void staffTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffTableFocusGained
        // TODO add your handling code here:
        editstaffB.setEnabled(true);
        hapusstaffB.setEnabled(true);
    }//GEN-LAST:event_staffTableFocusGained

    private void tambahstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahstaffBActionPerformed
        // TODO add your handling code here:
        tambahStaff ta = new tambahStaff();
        ta.setVisible(true);
    }//GEN-LAST:event_tambahstaffBActionPerformed

    private void editstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editstaffBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = staffTable.getSelectedRow();
        String value = staffTable.getModel().getValueAt(row, column).toString();
        tambahStaff et = new tambahStaff(value);
        et.setVisible(true);
    }//GEN-LAST:event_editstaffBActionPerformed

    private void hapusstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusstaffBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = staffTable.getSelectedRow();
        String value = staffTable.getModel().getValueAt(row, column).toString();
        n.deleteStaff(value);
    }//GEN-LAST:event_hapusstaffBActionPerformed

    private void CariPinjamAnggotaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariPinjamAnggotaBActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        try {
            // TODO add your handling code here:
            MysqlCon send = new MysqlCon( );
            
            String c = JCariIdPinjam.getText(); //untuk dapat value field
            Statement stmt = send.query();
            ResultSet rs;
            rs = stmt.executeQuery("Select * from library.anggota where anggota.id like '" + c + "'");
            
            String q;
            String w;
            String e;
            String r;
            
             while(rs.next()){
                q = rs.getString("id");
                LabelIDPinjam.setText(q);
                w = rs.getString("nama");
                LabelNamaPinjam.setText(w);
                e = rs.getString("alamat");
                LabelAlamatPinjam.setText(e);
                r = rs.getString("no_telp");
                LabelTeleponPinjam.setText(r);
            }
                
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
    }//GEN-LAST:event_CariPinjamAnggotaBActionPerformed

    private void CariBukuPinjamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariBukuPinjamBActionPerformed
        // TODO add your handling code here:
        MysqlCon send = new MysqlCon( );
        DefaultTableModel model = new DefaultTableModel(new String[]{"ISBN", "Judul", "Tahun Buku", "Lokasi"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
        try {
            // TODO add your handling code here:
            model.setRowCount(0);
            String c = JBukuPinjam.getText();
            Statement stmt = send.query();
            ResultSet rs;
            rs = stmt.executeQuery("Select * from library.book where book.ISBN like '" + c + "'");
            
            String q;
            String w;
            String r;
            String u;
            
             while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                r = rs.getString("thn_buku");
                u = rs.getString("lokasi");
                model.addRow(new Object[]{q, w, r, u});}
                
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        BukuPinjamTable.setModel(model);
    }//GEN-LAST:event_CariBukuPinjamBActionPerformed

    private void SimpanPinjamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanPinjamBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        String q = LabelIDPinjam.getText();
        int column = 0;
        int row = 0;
        String w = BukuPinjamTable.getModel().getValueAt(row, column).toString();
        String e = LabelDurasi.getText();
        n.createPinjam(q,w,e);
        
    }//GEN-LAST:event_SimpanPinjamBActionPerformed

    private void CariAnggotaKembaliBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariAnggotaKembaliBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariAnggotaKembaliBActionPerformed

    private void CariBukuKembaliBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariBukuKembaliBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariBukuKembaliBActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BukuKembaliTable;
    private javax.swing.JTable BukuPinjamTable;
    private javax.swing.JButton CariAnggotaKembaliB;
    private javax.swing.JButton CariBukuKembaliB;
    private javax.swing.JButton CariBukuPinjamB;
    private javax.swing.JButton CariPinjamAnggotaB;
    private javax.swing.JTextField JBukuPinjam;
    private javax.swing.JTextField JCariAnggotaKembali;
    private javax.swing.JTextField JCariBukuKembali;
    private javax.swing.JTextField JCariIdPinjam;
    private javax.swing.JTextField JcariAnggota;
    private javax.swing.JLabel LabelAlamatPinjam;
    private javax.swing.JLabel LabelDurasi;
    private javax.swing.JLabel LabelDurasi1;
    private javax.swing.JLabel LabelIDPinjam;
    private javax.swing.JLabel LabelNamaPinjam;
    private javax.swing.JLabel LabelTeleponPinjam;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JScrollPane ScrollPanelPinjam;
    private javax.swing.JButton SimpanPinjamB;
    private javax.swing.JTable anggotaTable;
    private javax.swing.JComboBox<String> angkatanSiswaCB;
    private javax.swing.JButton bukuB;
    private javax.swing.JPanel bukuPanel;
    private javax.swing.JTable bukuTabel;
    private javax.swing.JButton cariAnggotaB;
    private javax.swing.JButton cariB;
    private javax.swing.JTextField cariTF;
    private javax.swing.JButton datapinjamB;
    private javax.swing.JPanel datapinjamPanel;
    private javax.swing.JButton editbukuB;
    private javax.swing.JButton editsiswaB;
    private javax.swing.JButton editstaffB;
    private javax.swing.JButton hapusbukuB;
    private javax.swing.JButton hapussiswaB;
    private javax.swing.JButton hapusstaffB;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel nama;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JButton peminjamanB;
    private javax.swing.JPanel peminjamanPanel;
    private javax.swing.JPanel pengaturanPanel;
    private javax.swing.JButton pengembalianB;
    private javax.swing.JPanel pengembalianPanel;
    private javax.swing.JTable pinjamTable;
    private javax.swing.JButton settingB;
    private javax.swing.JTable settingTable;
    private javax.swing.JButton siswaB;
    private javax.swing.JPanel siswaPanel;
    private javax.swing.JButton staffB;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JTable staffTable;
    private javax.swing.JButton tambahbukuB;
    private javax.swing.JButton tambahsiswaB;
    private javax.swing.JButton tambahstaffB;
    private javax.swing.JLabel titleBuku;
    private javax.swing.JLabel titleDatapinjam;
    private javax.swing.JLabel titlePeminjaman;
    private javax.swing.JLabel titlePengaturan;
    private javax.swing.JLabel titlePengembalian;
    private javax.swing.JLabel titleSiswa;
    private javax.swing.JLabel titleStaff;
    // End of variables declaration//GEN-END:variables
}
