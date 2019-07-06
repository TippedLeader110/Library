/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Main;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import library.Mysql.MysqlCon;
import library.crudData.tambaheditPresensi;

/**
 *
 * @author My Computer
 */
public class Guest extends javax.swing.JFrame {

    /**
     * Creates new form Guest
     */
    MysqlCon send = new MysqlCon( );
    DefaultTableModel model_datapinjam = new DefaultTableModel(new String[]{"ID Transaksi", "ISBN", "Judul", "NIS", "Siswa", "Tingkat", "Jurusan", "Kelas", "ID Petugas", "Petugas", "Tanggal Pinjam", "Tanggal Kembali", "Denda"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
    DefaultTableModel model_buku = new DefaultTableModel(new String[]{"ISBN", "Judul", "Pengarang", "Penerbit", "Tahun Buku", "Jenis", "Kategori","Tanggal Pengadaan","Lokasi", "Jumlah"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
    DefaultTableModel model_presensi = new DefaultTableModel(new String[]{"No", "NIS", "Tanggal", "Jam", "keterangan"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
    
        TableRowSorter<DefaultTableModel> tp = new TableRowSorter<DefaultTableModel>(model_datapinjam);
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model_buku);
        TableRowSorter<DefaultTableModel> pr = new TableRowSorter<DefaultTableModel>(model_presensi);
        
        Statement stmt = send.query();
        
        
        
    public Guest() {
        
        initComponents();       
        
                
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Apa Anda Yakin ingin menutup Aplikasi?",
                        "Konfirmasi", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    System.exit(0);
                  
                } else {
                    System.out.println("do nothing");
                }
            }
        });
        
        ResultSet rs;
           
            String q, w, e, r, t, y, u, i, o, p;
            try {
                rs = stmt.executeQuery("select * from perpus.buku");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("pengarang");
                r = rs.getString("penerbit");
                t = rs.getString("thn_buku");
                y = rs.getString("jenis_buku");
                u = rs.getString("kategori");
                i = rs.getString("tgl_pengadaan");
                o = rs.getString("lokasi");
                p = rs.getString("jmlh");
                model_buku.addRow(new Object[]{q, w, e, r, t,y,u,i,o,p});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
            
        //combo box lokasi
        try{
            ResultSet rs_lok = stmt.executeQuery("Select distinct buku.lokasi from perpus.buku");
            while(rs_lok.next()){
                String lokasi = rs_lok.getString("lokasi");
                rakCB.addItem(lokasi); 
            }   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
        
        //combo box tahun buku
        try{
            ResultSet rs_thn = stmt.executeQuery("Select distinct buku.thn_buku from perpus.buku order by thn_buku asc");
            while(rs_thn.next()){
                String thn = rs_thn.getString("thn_buku");
                thnCB.addItem(thn); 
            }   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
            
        this.titleBuku.setText("Buku");
        panelBawah.removeAll();
        panelBawah.add(panelHome);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
        KategoriCB.setEnabled(false);
//        editbukuB.setEnabled(false);
//        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
        KategoriCB.setEnabled(false);
        
        
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
        exitGM = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        homeB = new javax.swing.JButton();
        bukuBAtas = new javax.swing.JButton();
        datapinjamBAatas = new javax.swing.JButton();
        presensiBAtas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelBawah = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bukuBBawah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        presensiBBawah = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datapinjamBBawah = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        panelBuku = new javax.swing.JPanel();
        titleBuku = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bukuTabel = new javax.swing.JTable();
        kategoriL = new javax.swing.JLabel();
        JenisCB = new javax.swing.JComboBox<>();
        sumberL = new javax.swing.JLabel();
        KategoriCB = new javax.swing.JComboBox<>();
        rakL = new javax.swing.JLabel();
        rakCB = new javax.swing.JComboBox<>();
        rakL2 = new javax.swing.JLabel();
        thnCB = new javax.swing.JComboBox<>();
        cariTF = new javax.swing.JTextField();
        cariBukuB = new javax.swing.JButton();
        penerbitL1 = new javax.swing.JLabel();
        penerbitL2 = new javax.swing.JLabel();
        panelDatapinjam = new javax.swing.JPanel();
        titleDatapinjam = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        datapinjamTabel = new javax.swing.JTable();
        datapinjamField = new javax.swing.JTextField();
        caridatapinjamB = new javax.swing.JButton();
        panelPresensi = new javax.swing.JPanel();
        titlePresensi = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        presensitabel = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        presensiTF = new javax.swing.JTextField();
        presensiCariB = new javax.swing.JButton();
        presensiTambahB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guest Mode - Sistem Pengelolaan Perpustakaan");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resources/images/icon-JFrame.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        panelAtas.setBackground(new java.awt.Color(51, 153, 255));

        exitGM.setBackground(new java.awt.Color(255, 0, 0));
        exitGM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exitGM.setForeground(new java.awt.Color(255, 255, 255));
        exitGM.setText("Login");
        exitGM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGMActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Home");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buku");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Data Pinjam");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Presensi");

        homeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/home-icon.png"))); // NOI18N
        homeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBActionPerformed(evt);
            }
        });

        bukuBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/book-icon.png"))); // NOI18N
        bukuBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bukuBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuBAtasActionPerformed(evt);
            }
        });

        datapinjamBAatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/datapinjam-icon.png"))); // NOI18N
        datapinjamBAatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datapinjamBAatasActionPerformed(evt);
            }
        });

        presensiBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/presensi-icon.png"))); // NOI18N
        presensiBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presensiBAtasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bukuBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datapinjamBAatas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel33)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presensiBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(homeB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bukuBAtas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(presensiBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datapinjamBAatas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel33)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sistem Pengelolaan Perpustakaan");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Perpustakaan SMK Negeri 1 Percut Sei Tuan");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/info-sekolah.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/info-jurusan.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/deliserdang.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/kemdikbud-rt.png"))); // NOI18N

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(panelAtasLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(exitGM, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAtasLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitGM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelAtas, java.awt.BorderLayout.PAGE_START);

        panelBawah.setBackground(new java.awt.Color(255, 255, 255));
        panelBawah.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Home");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        bukuBBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/book-icon.png"))); // NOI18N
        bukuBBawah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bukuBBawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuBBawahActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Buku");

        presensiBBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/presensi-icon.png"))); // NOI18N
        presensiBBawah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        presensiBBawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presensiBBawahActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Presensi");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Selamat datang di aplikasi Sistem Tata Kelola Perpustakaan ");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel5.setText("Anda sedang berada dalam Guest Mode (Mode Tamu)");

        datapinjamBBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-icon/datapinjam-icon.png"))); // NOI18N
        datapinjamBBawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datapinjamBBawahActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Data Pinjam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bukuBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datapinjamBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(presensiBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presensiBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bukuBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(datapinjamBBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel9))))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        panelBawah.add(panelHome, "card3");

        panelBuku.setBackground(new java.awt.Color(255, 255, 255));

        titleBuku.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleBuku.setForeground(new java.awt.Color(51, 51, 51));
        titleBuku.setText("Title");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1320, 645));

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
        jScrollPane2.setViewportView(bukuTabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        kategoriL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        kategoriL.setForeground(new java.awt.Color(51, 51, 51));
        kategoriL.setText("Jenis");

        JenisCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JenisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis", "Umum", "Khusus", "Mapel" }));
        JenisCB.setName("Kategori"); // NOI18N
        JenisCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JenisCBItemStateChanged(evt);
            }
        });
        JenisCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisCBActionPerformed(evt);
            }
        });

        sumberL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        sumberL.setForeground(new java.awt.Color(51, 51, 51));
        sumberL.setText("Kategori");

        KategoriCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        KategoriCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kategori" }));
        KategoriCB.setName("Kategori"); // NOI18N
        KategoriCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KategoriCBItemStateChanged(evt);
            }
        });

        rakL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rakL.setForeground(new java.awt.Color(51, 51, 51));
        rakL.setText("Rak");

        rakCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rakCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rak" }));
        rakCB.setName("Kategori"); // NOI18N
        rakCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rakCBItemStateChanged(evt);
            }
        });

        rakL2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rakL2.setForeground(new java.awt.Color(51, 51, 51));
        rakL2.setText("Tahun Buku");

        thnCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        thnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Buku" }));
        thnCB.setName("Kategori"); // NOI18N
        thnCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thnCBItemStateChanged(evt);
            }
        });

        cariTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cariTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTFActionPerformed(evt);
            }
        });

        cariBukuB.setBackground(new java.awt.Color(51, 153, 255));
        cariBukuB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariBukuB.setForeground(new java.awt.Color(255, 255, 255));
        cariBukuB.setText("Cari");
        cariBukuB.setBorder(null);
        cariBukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariBukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBukuBActionPerformed(evt);
            }
        });

        penerbitL1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        penerbitL1.setForeground(new java.awt.Color(51, 51, 51));
        penerbitL1.setText("*Pilih Jenis Buku sebelum memilih kategori");

        penerbitL2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        penerbitL2.setForeground(new java.awt.Color(51, 51, 51));
        penerbitL2.setText("*Untuk reset ComboBox pilih item nama ComboBox, reset ComboBox kategori pilih item kategori pada ComboBox Kategori");
        penerbitL2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelBukuLayout = new javax.swing.GroupLayout(panelBuku);
        panelBuku.setLayout(panelBukuLayout);
        panelBukuLayout.setHorizontalGroup(
            panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelBukuLayout.createSequentialGroup()
                        .addComponent(titleBuku)
                        .addGap(18, 18, 18)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JenisCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategoriL))
                        .addGap(18, 18, 18)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sumberL))
                        .addGap(18, 18, 18)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBukuLayout.createSequentialGroup()
                                .addComponent(rakL)
                                .addGap(90, 90, 90)
                                .addComponent(rakL2))
                            .addGroup(panelBukuLayout.createSequentialGroup()
                                .addComponent(rakCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thnCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBukuLayout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(penerbitL2)
                                    .addComponent(penerbitL1))))
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBukuLayout.setVerticalGroup(
            panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBuku)
                    .addGroup(panelBukuLayout.createSequentialGroup()
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kategoriL)
                            .addComponent(sumberL)
                            .addComponent(rakL)
                            .addComponent(rakL2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JenisCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rakCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(penerbitL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(penerbitL2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBawah.add(panelBuku, "card2");

        panelDatapinjam.setBackground(new java.awt.Color(255, 255, 255));

        titleDatapinjam.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleDatapinjam.setText("Title");

        jPanel16.setBackground(new java.awt.Color(51, 153, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(1320, 480));

        datapinjamTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(datapinjamTabel);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1324, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(jPanel16);

        datapinjamField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        caridatapinjamB.setBackground(new java.awt.Color(51, 153, 255));
        caridatapinjamB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        caridatapinjamB.setForeground(new java.awt.Color(255, 255, 255));
        caridatapinjamB.setText("Cari");
        caridatapinjamB.setBorder(null);
        caridatapinjamB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caridatapinjamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridatapinjamBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatapinjamLayout = new javax.swing.GroupLayout(panelDatapinjam);
        panelDatapinjam.setLayout(panelDatapinjamLayout);
        panelDatapinjamLayout.setHorizontalGroup(
            panelDatapinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatapinjamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatapinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                    .addGroup(panelDatapinjamLayout.createSequentialGroup()
                        .addGroup(panelDatapinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleDatapinjam)
                            .addGroup(panelDatapinjamLayout.createSequentialGroup()
                                .addComponent(datapinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(caridatapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatapinjamLayout.setVerticalGroup(
            panelDatapinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatapinjamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDatapinjam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatapinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datapinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caridatapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBawah.add(panelDatapinjam, "card14");

        panelPresensi.setBackground(new java.awt.Color(255, 255, 255));

        titlePresensi.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePresensi.setForeground(new java.awt.Color(51, 51, 51));
        titlePresensi.setText("Title");

        jPanel18.setBackground(new java.awt.Color(0, 153, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(1346, 480));

        presensitabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(presensitabel);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(jPanel18);

        jLabel75.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel75.setText("NIS / Kode Anggota");

        presensiTF.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        presensiCariB.setBackground(new java.awt.Color(51, 153, 255));
        presensiCariB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        presensiCariB.setForeground(new java.awt.Color(255, 255, 255));
        presensiCariB.setText("Cari");
        presensiCariB.setBorder(null);
        presensiCariB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        presensiTambahB.setBackground(new java.awt.Color(0, 204, 0));
        presensiTambahB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        presensiTambahB.setForeground(new java.awt.Color(255, 255, 255));
        presensiTambahB.setText("Tambah");
        presensiTambahB.setBorder(null);
        presensiTambahB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        presensiTambahB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presensiTambahBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPresensiLayout = new javax.swing.GroupLayout(panelPresensi);
        panelPresensi.setLayout(panelPresensiLayout);
        panelPresensiLayout.setHorizontalGroup(
            panelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresensiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelPresensiLayout.createSequentialGroup()
                        .addGroup(panelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePresensi)
                            .addComponent(jLabel75)
                            .addGroup(panelPresensiLayout.createSequentialGroup()
                                .addComponent(presensiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(presensiCariB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(presensiTambahB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1043, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPresensiLayout.setVerticalGroup(
            panelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresensiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePresensi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presensiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presensiCariB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presensiTambahB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(panelPresensi, "card12");

        getContentPane().add(panelBawah, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bukuBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuBAtasActionPerformed
        // TODO add your handling code here:
        tr.setRowFilter(RowFilter.regexFilter(""));
        model_buku.setRowCount(0);
        JenisCB.setSelectedIndex(0);
        KategoriCB.setSelectedIndex(0);
        rakCB.setSelectedIndex(0);
        thnCB.setSelectedIndex(0);
        cariTF.setText("");
            stmt = send.query();
            ResultSet rs;
           
            String q, w, e, r, t, y, u, i, o, p;
            try {
                rs = stmt.executeQuery("select * from perpus.buku");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("pengarang");
                r = rs.getString("penerbit");
                t = rs.getString("thn_buku");
                y = rs.getString("jenis_buku");
                u = rs.getString("Kategori");
                i = rs.getString("tgl_pengadaan");
                o = rs.getString("lokasi");
                p = rs.getString("jmlh");
                model_buku.addRow(new Object[]{q, w, e, r, t,y,u,i,o,p});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleBuku.setText("Buku");
        panelBawah.removeAll();
        panelBawah.add(panelBuku);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
//        editbukuB.setEnabled(false);
//        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_bukuBAtasActionPerformed

    private void homeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBActionPerformed
        // TODO add your handling code here:
        this.titleBuku.setText("Home");
        panelBawah.removeAll();
        panelBawah.add(panelHome);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_homeBActionPerformed

    private void bukuBBawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuBBawahActionPerformed
        // TODO add your handling code here:
//        this.titleBuku.setText("Buku");
//        panelBawah.removeAll();
//        panelBawah.add(panelBuku);
//        panelBawah.repaint();
//        panelBawah.revalidate();
        tr.setRowFilter(RowFilter.regexFilter(""));
        model_buku.setRowCount(0);
        JenisCB.setSelectedIndex(0);
        KategoriCB.setSelectedIndex(0);
        rakCB.setSelectedIndex(0);
        thnCB.setSelectedIndex(0);
        cariTF.setText("");
//        Statement stmt = send.query();
            stmt = send.query();
            ResultSet rs;
           
            String q, w, e, r, t, y, u, i, o, p;
            try {
                rs = stmt.executeQuery("select * from perpus.buku");
                while(rs.next()){
                q = rs.getString("ISBN");
                w = rs.getString("judul");
                e = rs.getString("pengarang");
                r = rs.getString("penerbit");
                t = rs.getString("thn_buku");
                y = rs.getString("jenis_buku");
                u = rs.getString("Kategori");
                i = rs.getString("tgl_pengadaan");
                o = rs.getString("lokasi");
                p = rs.getString("jmlh");
                model_buku.addRow(new Object[]{q, w, e, r, t,y,u,i,o,p});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titleBuku.setText("Buku");
        panelBawah.removeAll();
        panelBawah.add(panelBuku);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
//        editbukuB.setEnabled(false);
//        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_bukuBBawahActionPerformed

    private void presensiBBawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presensiBBawahActionPerformed
        // TODO add your handling code here:
        this.titlePresensi.setText("Presensi");
        panelBawah.removeAll();
        panelBawah.add(panelPresensi);
        panelBawah.repaint();
        panelBawah.revalidate();
        

        
    }//GEN-LAST:event_presensiBBawahActionPerformed

    private void presensiBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presensiBAtasActionPerformed
        // TODO add your handling code here:
        pr.setRowFilter(RowFilter.regexFilter(""));
        model_presensi.setRowCount(0);
//        tipetanggalpresensiCB.setSelectedIndex(0);
//        TingkatPresensiCB.setSelectedIndex(0);
//        JurusanPresensiCB.setSelectedIndex(0);
//        kelasPresensiCB.setSelectedIndex(0);
//        kegfield.setText("");
        
        stmt = send.query();
        ResultSet rs;
        String q, w, e, r, t,y,u,i,o; 
        
        //jurusan
//        try{
//            ResultSet rs_jurusan = stmt.executeQuery("select distinct kelas.jurusan from perpus.kelas order by kelas.jurusan asc");
//            while(rs_jurusan.next()){
//                String jurusan = rs_jurusan.getString("jurusan");
//               JurusanPresensiCB.addItem(jurusan); 
//            }   
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
//        }
        
        try {
                rs = stmt.executeQuery("select * from perpus.presensi_view");
                while(rs.next()){
                q = rs.getString("no_presensi");
                w = rs.getString("nis");
                y = rs.getString("nama");
                u = rs.getString("tingkat");
                i = rs.getString("jurusan");
                o = rs.getString("kelas");
                e = rs.getString("tanggal");
                t = rs.getString("kegiatan");
                model_presensi.addRow(new Object[]{q,w,y,u,i,o,e,t});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        
        
        this.titlePresensi.setText("Presensi");
        panelBawah.removeAll();
        panelBawah.add(panelPresensi);
        presensitabel.setModel(model_presensi);
        presensitabel.setAutoCreateRowSorter(true);
//        tanggal1presensiLabel.setEnabled(false);
//        tanggal2presensiLabel.setEnabled(false);
//        tahunpresensiField1.setEnabled(false);
//        tahunpresensiField2.setEnabled(false);
//        bulanpresensifield1.setEnabled(false);
//        bulanpresensifield2.setEnabled(false);
//        haripresensiField1.setEnabled(false);
//        haripresensiField2.setEnabled(false);
//        labelpresensit1.setEnabled(false);
//        labelpresensit2.setEnabled(false);
//        labelpresensit3.setEnabled(false);
//        labelpresensit4.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_presensiBAtasActionPerformed

    private void exitGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGMActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showOptionDialog(this, 
                        "Tinggalkan Guest Mode Sekarang?", 
                        "Konfirmasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(jawab == JOptionPane.YES_OPTION){
            DaftarPrototipe dp = new DaftarPrototipe();
            this.dispose();
            dp.setVisible(true);
        }
    }//GEN-LAST:event_exitGMActionPerformed

    private void datapinjamBAatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datapinjamBAatasActionPerformed
        // TODO add your handling code here:
//        this.titleDatapinjam.setText("Data Pinjam");
//        panelBawah.removeAll();
//        panelBawah.add(panelDatapinjam);
//        panelBawah.repaint();
//        panelBawah.revalidate();
        model_datapinjam.setRowCount(0);
        stmt = send.query();
        ResultSet rs;

        String q,w,e,r,t,y,u,i,o,p,z,x,c;
        try {
            rs = stmt.executeQuery("select * from perpus.pinjam");
            while(rs.next()){
                q = rs.getString("id_transaksi");
                w = rs.getString("isbn");
                e = rs.getString("judul");
                r = rs.getString("nis");
                t = rs.getString("siswa");
                y = rs.getString("tingkat");
                u = rs.getString("jurusan");
                i = rs.getString("kelas");
                o = rs.getString("id_petugas");
                p = rs.getString("petugas");
                z = rs.getString("t_pinjam");
                x = rs.getString("t_kembali");
                c = rs.getString("denda");
                model_datapinjam.addRow(new Object[]{q,w,e,r,t,y,u,i,o,p,z,x,c});}
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        this.titleDatapinjam.setText("Data Pinjam");
        panelBawah.removeAll();
        panelBawah.add(panelDatapinjam);
        datapinjamTabel.setModel(model_datapinjam);
        datapinjamTabel.setAutoCreateRowSorter(true);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_datapinjamBAatasActionPerformed

    private void datapinjamBBawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datapinjamBBawahActionPerformed
        // TODO add your handling code here:
        model_datapinjam.setRowCount(0);
        stmt = send.query();
        ResultSet rs;

        String q,w,e,r,t,y,u,i,o,p,z,x,c;
        try {
            rs = stmt.executeQuery("select * from perpus.pinjam");
            while(rs.next()){
                q = rs.getString("id_transaksi");
                w = rs.getString("isbn");
                e = rs.getString("judul");
                r = rs.getString("nis");
                t = rs.getString("siswa");
                y = rs.getString("tingkat");
                u = rs.getString("jurusan");
                i = rs.getString("kelas");
                o = rs.getString("id_petugas");
                p = rs.getString("petugas");
                z = rs.getString("t_pinjam");
                x = rs.getString("t_kembali");
                c = rs.getString("denda");
                model_datapinjam.addRow(new Object[]{q,w,e,r,t,y,u,i,o,p,z,x,c});}
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        this.titleDatapinjam.setText("Data Pinjam");
        panelBawah.removeAll();
        panelBawah.add(panelDatapinjam);
        datapinjamTabel.setModel(model_datapinjam);
        datapinjamTabel.setAutoCreateRowSorter(true);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_datapinjamBBawahActionPerformed

    private void caridatapinjamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridatapinjamBActionPerformed
        // TODO add your handling code here:
        
        
        datapinjamTabel.setRowSorter(tp);
        String pinjam = datapinjamField.getText();
        if(pinjam.equals(""))
        tp.setRowFilter(RowFilter.regexFilter(""));
        else
        tp.setRowFilter(RowFilter.regexFilter("^(?i)"+pinjam));
    }//GEN-LAST:event_caridatapinjamBActionPerformed

    private void JenisCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JenisCBItemStateChanged
        // TODO add your handling code here:

        //combo box kategori
        KategoriCB.setEnabled(true);
        KategoriCB.removeAllItems();
        KategoriCB.addItem("Kategori");
        Statement stmt = send.query();
        try{
            String jenis = JenisCB.getSelectedItem().toString();
            ResultSet rs2 = stmt.executeQuery("Select distinct book.kategori from perpus.book where jenis_buku = '"+ jenis +"'");
            while(rs2.next()){
                String kategori = rs2.getString("kategori");
                KategoriCB.addItem(kategori);
                KategoriCB.setSelectedIndex(0);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }

        //search by combo box
        bukuTabel.setRowSorter(tr);
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String lokasi = rakCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(5);
        if(jenis.equals("Jenis")){
            KategoriCB.setSelectedIndex(0);
            KategoriCB.setEnabled(false);
            filters.add(RowFilter.regexFilter(""));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }
        else{
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }
        tr.setRowFilter(RowFilter.andFilter(filters));

    }//GEN-LAST:event_JenisCBItemStateChanged

    private void JenisCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisCBActionPerformed

    private void KategoriCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KategoriCBItemStateChanged
        // TODO add your handling code here:
        bukuTabel.setRowSorter(tr);
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = evt.getItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(5);
        if(Kategori.equals("Kategori")){
            filters.add(RowFilter.regexFilter(""));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }else{
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }
        tr.setRowFilter(RowFilter.andFilter(filters));
    }//GEN-LAST:event_KategoriCBItemStateChanged

    private void rakCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rakCBItemStateChanged
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(5);
        if(lokasi.equals("Rak")){
            filters.add(RowFilter.regexFilter(""));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
        }
        else{
            filters.add(RowFilter.regexFilter(lokasi));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
        }
        tr.setRowFilter(RowFilter.andFilter(filters));
    }//GEN-LAST:event_rakCBItemStateChanged

    private void thnCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thnCBItemStateChanged
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(5);
        if(tahun.equals("Tahun Buku")){
            filters.add(RowFilter.regexFilter(""));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
        }
        else{
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
            if(!nama.equals(""))
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
        }
        tr.setRowFilter(RowFilter.andFilter(filters));
    }//GEN-LAST:event_thnCBItemStateChanged

    private void cariTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTFActionPerformed
        // TODO add your handling code here:
        this.getRootPane().setDefaultButton(cariBukuB);
    }//GEN-LAST:event_cariTFActionPerformed

    private void cariBukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBukuBActionPerformed
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(5);
        if(nama.equals("")){
            filters.add(RowFilter.regexFilter(""));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }
        else{
            filters.add(RowFilter.regexFilter("^(?i)"+nama));
            if(!jenis.equals("Jenis"))
            filters.add(RowFilter.regexFilter("^"+jenis+"$"));
            if(!Kategori.equals("Kategori"))
            filters.add(RowFilter.regexFilter("^"+Kategori+"$"));
            if(!tahun.equals("Tahun Buku"))
            filters.add(RowFilter.regexFilter("^"+tahun+"$"));
            if(!lokasi.equals("Rak"))
            filters.add(RowFilter.regexFilter("^"+lokasi+"$"));
        }
        tr.setRowFilter(RowFilter.andFilter(filters));
    }//GEN-LAST:event_cariBukuBActionPerformed

    private void presensiTambahBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presensiTambahBActionPerformed
        // TODO add your handling code here:
        tambaheditPresensi tep = new tambaheditPresensi();
        tep.setVisible(true);
        
    }//GEN-LAST:event_presensiTambahBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        infoSekolah is = new infoSekolah();
        is.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        infoJurusan ij = new infoJurusan();
        ij.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JenisCB;
    private javax.swing.JComboBox<String> KategoriCB;
    private javax.swing.JButton bukuBAtas;
    private javax.swing.JButton bukuBBawah;
    private javax.swing.JTable bukuTabel;
    private javax.swing.JButton cariBukuB;
    private javax.swing.JTextField cariTF;
    private javax.swing.JButton caridatapinjamB;
    private javax.swing.JButton datapinjamBAatas;
    private javax.swing.JButton datapinjamBBawah;
    private javax.swing.JTextField datapinjamField;
    private javax.swing.JTable datapinjamTabel;
    private javax.swing.JButton exitGM;
    private javax.swing.JButton homeB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kategoriL;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JPanel panelBuku;
    private javax.swing.JPanel panelDatapinjam;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelPresensi;
    private javax.swing.JLabel penerbitL1;
    private javax.swing.JLabel penerbitL2;
    private javax.swing.JButton presensiBAtas;
    private javax.swing.JButton presensiBBawah;
    private javax.swing.JButton presensiCariB;
    private javax.swing.JTextField presensiTF;
    private javax.swing.JButton presensiTambahB;
    private javax.swing.JTable presensitabel;
    private javax.swing.JComboBox<String> rakCB;
    private javax.swing.JLabel rakL;
    private javax.swing.JLabel rakL2;
    private javax.swing.JLabel sumberL;
    private javax.swing.JComboBox<String> thnCB;
    private javax.swing.JLabel titleBuku;
    private javax.swing.JLabel titleDatapinjam;
    private javax.swing.JLabel titlePresensi;
    // End of variables declaration//GEN-END:variables
}
