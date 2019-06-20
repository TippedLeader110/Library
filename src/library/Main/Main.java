/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Main;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import library.Mysql.MysqlCon;
import library.crudData.crud;
import library.crudData.editBuku;
import library.crudData.editSiswa;
import library.crudData.tambahBuku;
import library.crudData.tambahSiswa;
import library.crudData.tambaheditAkun;
import library.crudData.tambaheditStaff;
/**
 *
 * @author My Computer
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    MysqlCon send = new MysqlCon( );
    DefaultTableModel model_buku = new DefaultTableModel(new String[]{"ISBN", "Judul", "Pengarang", "Penerbit", "Tahun Buku", "Jenis", "Kategori","Tanggal Pengadaan","Lokasi", "Jumlah"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
     DefaultTableModel model_bukupinjam = new DefaultTableModel(new String[]{"ISBN", "Judul", "Tahun Buku", "Jenis", "Kategori","Lokasi"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
     DefaultTableModel model_siswa = new DefaultTableModel(new String[]{"NIS", "Nama", "Tingkat", "Jurusan", "Kelas", "Alamat", "No Telepon"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
     DefaultTableModel model_staff = new DefaultTableModel(new String[]{"ID petugas", "Nama", "Alamat", "No Telepon"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
     DefaultTableModel model_user = new DefaultTableModel(new String[]{"ID petugas", "Username", "Password"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
      DefaultTableModel model_datapinjam = new DefaultTableModel(new String[]{"ID Transaksi", "ISBN", "Judul", "NIS", "Siswa", "Tingkat", "Jurusan", "Kelas", "ID Petugas", "Petugas", "Tanggal Pinjam", "Tanggal Kembali", "Denda"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
      DefaultTableModel model_siswapinjam = new DefaultTableModel(new String[]{"NIS", "Nama", "Alamat","No Telepon"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
      DefaultTableModel model_kembali = new DefaultTableModel(new String[]{"ID Transaksi", "ISBN", "Judul", "Siswa", "jenis", "kategori", "Tanggal Pinjam"}, 0){
        @Override
        
        public boolean isCellEditable(int row, int column) {
                return false;
        }
        };
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model_buku);
     TableRowSorter<DefaultTableModel> ts = new TableRowSorter<DefaultTableModel>(model_siswa);
     TableRowSorter<DefaultTableModel> ts2 = new TableRowSorter<DefaultTableModel>(model_staff);
     TableRowSorter<DefaultTableModel> tp = new TableRowSorter<DefaultTableModel>(model_datapinjam);
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
        Statement stmt = send.query();
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
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
        editbukuB.setEnabled(false);
        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
        KategoriCB.setEnabled(false);
    }
    
    public Main(String name) {
        initComponents();
        Statement stmt = send.query();
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
        this.titleBuku.setText("Buku");
        LabelUser.setText(name);
        panelBawah.removeAll();
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
        editbukuB.setEnabled(false);
        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();;
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
        jLabel1 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        bukuBAtas = new javax.swing.JButton();
        siswaBAtas = new javax.swing.JButton();
        staffBAtas = new javax.swing.JButton();
        settingBAtas = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        presensiBAtas = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        peminjamanBAtas = new javax.swing.JButton();
        pengembalianBAtas = new javax.swing.JButton();
        datapinjamBAtas = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panelBawah = new javax.swing.JPanel();
        peminjamanPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        pemiUmumP = new javax.swing.JPanel();
        titlePemBukuUmum = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        siswaPinjamUmumField = new javax.swing.JTextField();
        cariSiswaPinjamUmumB = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        LabelnamaPinjamUmum = new javax.swing.JLabel();
        LabeltingkatPinjamUmum = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        LabeljurusanPinjamUmum = new javax.swing.JLabel();
        LabelkelasPinjamUmum = new javax.swing.JLabel();
        durasiField = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        maksField = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        bukuPinjamUmumField = new javax.swing.JTextField();
        tambahbukuPinjamField = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        bukuPinjamUmumTabel = new javax.swing.JTable();
        simpanPinjamUmum = new javax.swing.JButton();
        resetbukuPinjamUmum = new javax.swing.JButton();
        pemiMapelP = new javax.swing.JPanel();
        tingkatPinjamMapelCB = new javax.swing.JComboBox<>();
        jurusanPinjamMapelCB = new javax.swing.JComboBox<>();
        kelasPinjamMapelCB = new javax.swing.JComboBox<>();
        titlePemBukuMapel = new javax.swing.JLabel();
        simpanPinjamMapelB = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        siswaPinjamMapelTabel = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        bukuPinjamMapelTabel = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tahunField = new javax.swing.JTextField();
        bulanfield = new javax.swing.JTextField();
        hariField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        carisiswaPinjamMapelB = new javax.swing.JButton();
        bukuPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bukuTabel = new javax.swing.JTable();
        titleBuku = new javax.swing.JLabel();
        kategoriL = new javax.swing.JLabel();
        sumberL = new javax.swing.JLabel();
        rakL = new javax.swing.JLabel();
        JenisCB = new javax.swing.JComboBox<>();
        KategoriCB = new javax.swing.JComboBox<>();
        rakCB = new javax.swing.JComboBox<>();
        tambahbukuB = new javax.swing.JButton();
        editbukuB = new javax.swing.JButton();
        hapusbukuB = new javax.swing.JButton();
        cariTF = new javax.swing.JTextField();
        cariBukuB = new javax.swing.JButton();
        penerbitL1 = new javax.swing.JLabel();
        penerbitL2 = new javax.swing.JLabel();
        thnCB = new javax.swing.JComboBox<>();
        rakL2 = new javax.swing.JLabel();
        laporanPanel = new javax.swing.JPanel();
        titleLaporan = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        kasPanel = new javax.swing.JPanel();
        titleKas = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        pengembalianPanel = new javax.swing.JPanel();
        pengeUmumP = new javax.swing.JPanel();
        titlePengembalianUmum = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        LabelnamaKembali = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        LabeltingkatKembali = new javax.swing.JLabel();
        LabeljurusanKembali = new javax.swing.JLabel();
        LabelkelasKembali = new javax.swing.JLabel();
        dendaField = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        siswakembaliField = new javax.swing.JTextField();
        cariKembaliB = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        bukuKembaliTabel = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        LabelDenda = new javax.swing.JLabel();
        simpanKembaliB = new javax.swing.JButton();
        datapinjamPanel = new javax.swing.JPanel();
        titleDatapinjam = new javax.swing.JLabel();
        datapinjamField = new javax.swing.JTextField();
        caridatapinjamB = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        datapinjamTabel = new javax.swing.JTable();
        pengaturanPanel = new javax.swing.JPanel();
        titlePengaturan = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        userTabel = new javax.swing.JTable();
        tambahUserB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        staffPanel = new javax.swing.JPanel();
        titleStaff = new javax.swing.JLabel();
        staffField = new javax.swing.JTextField();
        caristaffB = new javax.swing.JButton();
        tambahstaffB = new javax.swing.JButton();
        editstaffB = new javax.swing.JButton();
        hapusstaffB = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        staffTabel = new javax.swing.JTable();
        siswaPanel = new javax.swing.JPanel();
        titleSiswa = new javax.swing.JLabel();
        tingkatSiswaCB = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cariSiswaField = new javax.swing.JTextField();
        cariSiswaB = new javax.swing.JButton();
        tambahsiswaB = new javax.swing.JButton();
        editsiswaB = new javax.swing.JButton();
        hapussiswaB = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        siswaTabel = new javax.swing.JTable();
        jurusanSiswaCB = new javax.swing.JComboBox<>();
        jLabel93 = new javax.swing.JLabel();
        kelasSiswaCB = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        presensiPanel = new javax.swing.JPanel();
        titlePresensi = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        tambahPresensiB = new javax.swing.JButton();
        editPresensiB = new javax.swing.JButton();
        hapusPresensiB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIstem Pengelolaan Perpustakaan (v 0.0.1)");

        panelAtas.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang,");

        LabelUser.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("<Username>");

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        bukuBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buku.png"))); // NOI18N
        bukuBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bukuBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuBAtasActionPerformed(evt);
            }
        });

        siswaBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/siswa.png"))); // NOI18N
        siswaBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siswaBAtasActionPerformed(evt);
            }
        });

        staffBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        staffBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        staffBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBAtasActionPerformed(evt);
            }
        });

        settingBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/setting.png"))); // NOI18N
        settingBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBAtasActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Buku");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Siswa");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Staff");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Pengaturan");

        presensiBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/presensi.png"))); // NOI18N
        presensiBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presensiBAtasActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Presensi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bukuBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(siswaBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presensiBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(presensiBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(staffBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel27))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(siswaBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bukuBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(settingBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25)
                                .addComponent(jLabel30)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Database", jPanel1);

        jPanel25.setBackground(new java.awt.Color(51, 153, 255));

        peminjamanBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/peminjaman.png"))); // NOI18N
        peminjamanBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        peminjamanBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanBAtasActionPerformed(evt);
            }
        });

        pengembalianBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/pengembalian.png"))); // NOI18N
        pengembalianBAtas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pengembalianBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengembalianBAtasActionPerformed(evt);
            }
        });

        datapinjamBAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/datapinjam.png"))); // NOI18N
        datapinjamBAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datapinjamBAtasActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Peminjaman");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Pengembalian");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Data Pinjam");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(peminjamanBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pengembalianBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datapinjamBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pengembalianBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peminjamanBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datapinjamBAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel25);

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 988, Short.MAX_VALUE)
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(LabelUser))
                .addGap(60, 60, 60))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAtasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(LabelUser))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(panelAtas, java.awt.BorderLayout.PAGE_START);

        panelBawah.setBackground(new java.awt.Color(255, 255, 255));
        panelBawah.setLayout(new java.awt.CardLayout());

        jTabbedPane3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        pemiUmumP.setBackground(new java.awt.Color(255, 255, 255));

        titlePemBukuUmum.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePemBukuUmum.setForeground(new java.awt.Color(51, 51, 51));
        titlePemBukuUmum.setText("Title");

        jPanel13.setBackground(new java.awt.Color(51, 153, 255));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("NIS");

        siswaPinjamUmumField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        cariSiswaPinjamUmumB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariSiswaPinjamUmumB.setText("Cari");
        cariSiswaPinjamUmumB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariSiswaPinjamUmumB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSiswaPinjamUmumBActionPerformed(evt);
            }
        });

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel77.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel77.setText("Nama");

        jLabel95.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel95.setText("Kelas");

        LabelnamaPinjamUmum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelnamaPinjamUmum.setText("<Nama>");

        LabeltingkatPinjamUmum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabeltingkatPinjamUmum.setText("<Tingkat>");

        jLabel99.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel99.setText("Maks. Pinjam");

        jLabel101.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel101.setText("Durasi Pinjam");

        LabeljurusanPinjamUmum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabeljurusanPinjamUmum.setText("<Jurusan>");

        LabelkelasPinjamUmum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelkelasPinjamUmum.setText("<Kelas>");

        jLabel109.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel109.setText("Hari");

        jLabel100.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel100.setText("Buku");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(durasiField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
                    .addComponent(LabelnamaPinjamUmum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addGap(40, 40, 40)
                        .addComponent(LabeltingkatPinjamUmum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabeljurusanPinjamUmum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelkelasPinjamUmum))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addGap(95, 95, 95)
                        .addComponent(maksField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100)))
                .addGap(361, 361, 361))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabeltingkatPinjamUmum)
                    .addComponent(LabeljurusanPinjamUmum)
                    .addComponent(LabelkelasPinjamUmum)
                    .addComponent(LabelnamaPinjamUmum)
                    .addComponent(jLabel77)
                    .addComponent(jLabel95))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(durasiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel109))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel99))
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel100)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(71, 71, 71)
                        .addComponent(siswaPinjamUmumField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariSiswaPinjamUmumB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(siswaPinjamUmumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariSiswaPinjamUmumB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(51, 153, 255));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Kode Buku");

        bukuPinjamUmumField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        tambahbukuPinjamField.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tambahbukuPinjamField.setText("Tambah");
        tambahbukuPinjamField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahbukuPinjamField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbukuPinjamFieldActionPerformed(evt);
            }
        });

        jScrollPane25.setBackground(new java.awt.Color(255, 255, 255));

        bukuPinjamUmumTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane25.setViewportView(bukuPinjamUmumTabel);

        simpanPinjamUmum.setBackground(new java.awt.Color(51, 204, 0));
        simpanPinjamUmum.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        simpanPinjamUmum.setForeground(new java.awt.Color(255, 255, 255));
        simpanPinjamUmum.setText("Simpan");
        simpanPinjamUmum.setBorder(null);
        simpanPinjamUmum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanPinjamUmum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanPinjamUmumActionPerformed(evt);
            }
        });

        resetbukuPinjamUmum.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        resetbukuPinjamUmum.setText("Reset");
        resetbukuPinjamUmum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetbukuPinjamUmum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbukuPinjamUmumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(bukuPinjamUmumField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambahbukuPinjamField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetbukuPinjamUmum))
                    .addComponent(simpanPinjamUmum, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(527, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(tambahbukuPinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbukuPinjamUmum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bukuPinjamUmumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(simpanPinjamUmum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pemiUmumPLayout = new javax.swing.GroupLayout(pemiUmumP);
        pemiUmumP.setLayout(pemiUmumPLayout);
        pemiUmumPLayout.setHorizontalGroup(
            pemiUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemiUmumPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pemiUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pemiUmumPLayout.createSequentialGroup()
                        .addComponent(titlePemBukuUmum)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pemiUmumPLayout.setVerticalGroup(
            pemiUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemiUmumPLayout.createSequentialGroup()
                .addComponent(titlePemBukuUmum)
                .addGap(34, 34, 34)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Peminjaman Buku Umum", pemiUmumP);

        pemiMapelP.setBackground(new java.awt.Color(255, 255, 255));

        tingkatPinjamMapelCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tingkatPinjamMapelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Tingkat--", "10", "11", "12", "Alumni" }));

        jurusanPinjamMapelCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jurusanPinjamMapelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Jurusan--", "Produksi dan Siaran Televisi", "Teknik Audio Vidio", "Teknik dan Bisnis Sepeda Motor", "Teknik Instalasi Tenaga Listrik", "Teknik Komputer dan Jaringan", "Teknik Kendaraan Ringan Otomotif", "Teknik Pengelasan", "Teknik Pemesinan", "Teknik Pendingin dan Tata Udara", "Bisnis dan Konstruksi Properti", "Desain Permodelan dan Informasi Bangunan", "Rekayasa Perangkat Lunak", "Teknik Geomatika", "Teknik Jaringan Tenaga Listrik" }));

        kelasPinjamMapelCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kelasPinjamMapelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Kelas--", "1", "2", "3" }));

        titlePemBukuMapel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePemBukuMapel.setForeground(new java.awt.Color(51, 51, 51));
        titlePemBukuMapel.setText("Title");

        simpanPinjamMapelB.setBackground(new java.awt.Color(51, 204, 0));
        simpanPinjamMapelB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        simpanPinjamMapelB.setForeground(new java.awt.Color(255, 255, 255));
        simpanPinjamMapelB.setText("Simpan");
        simpanPinjamMapelB.setBorder(null);
        simpanPinjamMapelB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanPinjamMapelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanPinjamMapelBActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Batal");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel15.setBackground(new java.awt.Color(51, 153, 255));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Siswa");

        siswaPinjamMapelTabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        siswaPinjamMapelTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(siswaPinjamMapelTabel);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel45.setBackground(new java.awt.Color(51, 153, 255));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Buku yang Harus Dipinjam");

        bukuPinjamMapelTabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bukuPinjamMapelTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane27.setViewportView(bukuPinjamMapelTabel);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("Kelas");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel18.setText("Tingkat");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel19.setText("Jurusan");

        tahunField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tahunField.setText("Tahun");
        tahunField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tahunFieldFocusGained(evt);
            }
        });
        tahunField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunFieldActionPerformed(evt);
            }
        });

        bulanfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bulanfield.setText("Bulan");
        bulanfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bulanfieldFocusGained(evt);
            }
        });

        hariField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hariField.setText("Hari");
        hariField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hariFieldFocusGained(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Dikembalikan Tanggal");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText(" - ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText(" - ");

        carisiswaPinjamMapelB.setText("Cari");
        carisiswaPinjamMapelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carisiswaPinjamMapelBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pemiMapelPLayout = new javax.swing.GroupLayout(pemiMapelP);
        pemiMapelP.setLayout(pemiMapelPLayout);
        pemiMapelPLayout.setHorizontalGroup(
            pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemiMapelPLayout.createSequentialGroup()
                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titlePemBukuMapel)
                        .addGap(66, 66, 66)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(tingkatPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jurusanPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(kelasPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carisiswaPinjamMapelB))
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pemiMapelPLayout.createSequentialGroup()
                                .addComponent(tahunField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bulanfield, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hariField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))
                        .addGap(31, 31, 31)
                        .addComponent(simpanPinjamMapelB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        pemiMapelPLayout.setVerticalGroup(
            pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemiMapelPLayout.createSequentialGroup()
                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePemBukuMapel)
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemiMapelPLayout.createSequentialGroup()
                                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jurusanPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kelasPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carisiswaPinjamMapelB)
                                    .addComponent(tingkatPinjamMapelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemiMapelPLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(29, 29, 29)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanPinjamMapelB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pemiMapelPLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addGroup(pemiMapelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tahunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bulanfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hariField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Peminjaman Buku Mapel", pemiMapelP);

        javax.swing.GroupLayout peminjamanPanelLayout = new javax.swing.GroupLayout(peminjamanPanel);
        peminjamanPanel.setLayout(peminjamanPanelLayout);
        peminjamanPanelLayout.setHorizontalGroup(
            peminjamanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addGap(0, 0, 0))
        );
        peminjamanPanelLayout.setVerticalGroup(
            peminjamanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 227, Short.MAX_VALUE))
        );

        panelBawah.add(peminjamanPanel, "card16");

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
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

        kategoriL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        kategoriL.setForeground(new java.awt.Color(51, 51, 51));
        kategoriL.setText("Jenis");

        sumberL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        sumberL.setForeground(new java.awt.Color(51, 51, 51));
        sumberL.setText("Kategori");

        rakL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rakL.setForeground(new java.awt.Color(51, 51, 51));
        rakL.setText("Rak");

        JenisCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JenisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis", "Umum", "Khusus", "Mapel" }));
        JenisCB.setName("Kategori"); // NOI18N
        JenisCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JenisCBItemStateChanged(evt);
            }
        });

        KategoriCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        KategoriCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kategori" }));
        KategoriCB.setName("Kategori"); // NOI18N
        KategoriCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KategoriCBItemStateChanged(evt);
            }
        });

        rakCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rakCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rak" }));
        rakCB.setName("Kategori"); // NOI18N
        rakCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rakCBItemStateChanged(evt);
            }
        });

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

        thnCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        thnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Buku" }));
        thnCB.setName("Kategori"); // NOI18N
        thnCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thnCBItemStateChanged(evt);
            }
        });

        rakL2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rakL2.setForeground(new java.awt.Color(51, 51, 51));
        rakL2.setText("Tahun Buku");

        javax.swing.GroupLayout bukuPanelLayout = new javax.swing.GroupLayout(bukuPanel);
        bukuPanel.setLayout(bukuPanelLayout);
        bukuPanelLayout.setHorizontalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addComponent(titleBuku)
                        .addGap(53, 53, 53)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bukuPanelLayout.createSequentialGroup()
                                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JenisCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kategoriL))
                                .addGap(18, 18, 18)
                                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumberL))
                                .addGap(18, 18, 18)
                                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rakCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rakL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rakL2)
                                    .addComponent(thnCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bukuPanelLayout.createSequentialGroup()
                                .addComponent(tambahbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(penerbitL2)
                                    .addComponent(penerbitL1))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        bukuPanelLayout.setVerticalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBuku)
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kategoriL)
                            .addComponent(sumberL)
                            .addComponent(rakL)
                            .addComponent(rakL2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JenisCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rakCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bukuPanelLayout.createSequentialGroup()
                        .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambahbukuB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hapusbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bukuPanelLayout.createSequentialGroup()
                        .addComponent(penerbitL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(penerbitL2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        panelBawah.add(bukuPanel, "card2");

        laporanPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleLaporan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLaporan.setForeground(new java.awt.Color(51, 51, 51));
        titleLaporan.setText("Title");

        jPanel28.setBackground(new java.awt.Color(51, 153, 255));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Laporan Data Buku & Keanggotaan");

        jButton21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton21.setText("Laporan Data Buku");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton23.setText("Laporan Data Anggota");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(51, 153, 255));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Laporan Peringkat Presensi");

        jButton24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton24.setText("Laporan Presensi (Kunjungan)");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton25.setText("Laporan Peringkat Pengunjung");
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(51, 153, 255));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Laporan Pendapatan");

        jButton26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton26.setText("Laporan Kas Harian Operator");
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton27.setText("Laporan Pendapatan Denda");
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(18, 18, 18)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(51, 153, 255));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Laporan Aliran Kas");

        jButton28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton28.setText("Laporan Kas Masuk");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton29.setText("Laporan Kas Keluar");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout laporanPanelLayout = new javax.swing.GroupLayout(laporanPanel);
        laporanPanel.setLayout(laporanPanelLayout);
        laporanPanelLayout.setHorizontalGroup(
            laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLaporan)
                    .addGroup(laporanPanelLayout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laporanPanelLayout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1041, Short.MAX_VALUE))
        );
        laporanPanelLayout.setVerticalGroup(
            laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLaporan)
                .addGap(18, 18, 18)
                .addGroup(laporanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(laporanPanelLayout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laporanPanelLayout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(489, Short.MAX_VALUE))
        );

        panelBawah.add(laporanPanel, "card10");

        kasPanel.setBackground(new java.awt.Color(255, 255, 255));
        kasPanel.setForeground(new java.awt.Color(51, 51, 51));

        titleKas.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleKas.setText("Title");

        jPanel17.setBackground(new java.awt.Color(51, 153, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mulai Tanggal");

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("Sampai Tanggal");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(73, 73, 73)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(59, 59, 59)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton12.setBackground(new java.awt.Color(51, 204, 0));
        jButton12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Pemasukan");
        jButton12.setBorder(null);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton13.setBackground(new java.awt.Color(255, 0, 0));
        jButton13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Hapus");
        jButton13.setBorder(null);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton14.setBackground(new java.awt.Color(255, 204, 0));
        jButton14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Pengeluaran");
        jButton14.setBorder(null);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(51, 51, 51));
        jButton15.setText("Tampilkan");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(51, 153, 255));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(jTable9);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane16.setViewportView(jPanel20);

        javax.swing.GroupLayout kasPanelLayout = new javax.swing.GroupLayout(kasPanel);
        kasPanel.setLayout(kasPanelLayout);
        kasPanelLayout.setHorizontalGroup(
            kasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kasPanelLayout.createSequentialGroup()
                        .addComponent(titleKas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE))
                .addContainerGap())
        );
        kasPanelLayout.setVerticalGroup(
            kasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleKas)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        panelBawah.add(kasPanel, "card11");

        pengembalianPanel.setBackground(new java.awt.Color(255, 255, 255));

        pengeUmumP.setBackground(new java.awt.Color(255, 255, 255));

        titlePengembalianUmum.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengembalianUmum.setForeground(new java.awt.Color(51, 51, 51));
        titlePengembalianUmum.setText("Title");

        jPanel18.setBackground(new java.awt.Color(51, 153, 255));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel78.setText("Nama");

        LabelnamaKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelnamaKembali.setText("<Nama>");

        jLabel96.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel96.setText("Kelas");

        LabeltingkatKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabeltingkatKembali.setText("<Tingkat>");

        LabeljurusanKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabeljurusanKembali.setText("<Jurusan>");

        LabelkelasKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelkelasKembali.setText("<Kelas>");

        jLabel106.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel106.setText("Denda");

        jLabel111.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel111.setText("/Hari");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(73, 73, 73)
                        .addComponent(LabelnamaKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel96)
                        .addGap(70, 70, 70)
                        .addComponent(LabeltingkatKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabeljurusanKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelkelasKembali))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addGap(33, 33, 33)
                        .addComponent(dendaField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111)))
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(LabelnamaKembali)
                    .addComponent(LabeltingkatKembali)
                    .addComponent(LabeljurusanKembali)
                    .addComponent(LabelkelasKembali)
                    .addComponent(jLabel96))
                .addGap(42, 42, 42)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dendaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel111)))
                .addGap(83, 83, 83))
        );

        jLabel61.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("NIS");

        siswakembaliField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        cariKembaliB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariKembaliB.setText("Cari");
        cariKembaliB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariKembaliB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariKembaliBActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Buku Yang Dipinjam");

        bukuKembaliTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(bukuKembaliTabel);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Total Denda");

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setText("Rp");

        LabelDenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LabelDenda.setForeground(new java.awt.Color(51, 51, 51));
        LabelDenda.setText("<nominaldenda>");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addGap(40, 40, 40)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelDenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(LabelDenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        simpanKembaliB.setBackground(new java.awt.Color(51, 204, 0));
        simpanKembaliB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        simpanKembaliB.setForeground(new java.awt.Color(255, 255, 255));
        simpanKembaliB.setText("Simpan");
        simpanKembaliB.setBorder(null);
        simpanKembaliB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanKembaliB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKembaliBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(63, 63, 63)
                                .addComponent(siswakembaliField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cariKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel62)
                            .addComponent(simpanKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(siswakembaliField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simpanKembaliB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pengeUmumPLayout = new javax.swing.GroupLayout(pengeUmumP);
        pengeUmumP.setLayout(pengeUmumPLayout);
        pengeUmumPLayout.setHorizontalGroup(
            pengeUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1677, Short.MAX_VALUE)
            .addGroup(pengeUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pengeUmumPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pengeUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titlePengembalianUmum)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(126, Short.MAX_VALUE)))
        );
        pengeUmumPLayout.setVerticalGroup(
            pengeUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
            .addGroup(pengeUmumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pengeUmumPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titlePengembalianUmum)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pengembalianPanelLayout = new javax.swing.GroupLayout(pengembalianPanel);
        pengembalianPanel.setLayout(pengembalianPanelLayout);
        pengembalianPanelLayout.setHorizontalGroup(
            pengembalianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pengeUmumP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pengembalianPanelLayout.setVerticalGroup(
            pengembalianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pengeUmumP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBawah.add(pengembalianPanel, "card13");

        datapinjamPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleDatapinjam.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleDatapinjam.setText("Title");

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

        jPanel16.setBackground(new java.awt.Color(51, 153, 255));

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
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE)
                    .addGroup(datapinjamPanelLayout.createSequentialGroup()
                        .addComponent(titleDatapinjam)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(datapinjamPanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(datapinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(caridatapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datapinjamPanelLayout.setVerticalGroup(
            datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datapinjamPanelLayout.createSequentialGroup()
                .addComponent(titleDatapinjam)
                .addGap(9, 9, 9)
                .addGroup(datapinjamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datapinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caridatapinjamB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        panelBawah.add(datapinjamPanel, "card14");

        pengaturanPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengaturan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengaturan.setForeground(new java.awt.Color(51, 51, 51));
        titlePengaturan.setText("Title");

        jPanel21.setBackground(new java.awt.Color(51, 153, 255));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Pengaturan Akun Operator");

        userTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        userTabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTabelFocusGained(evt);
            }
        });
        jScrollPane19.setViewportView(userTabel);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jScrollPane18.setViewportView(jPanel22);

        tambahUserB.setBackground(new java.awt.Color(0, 204, 0));
        tambahUserB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tambahUserB.setForeground(new java.awt.Color(255, 255, 255));
        tambahUserB.setText("Tambah / Edit Akun");
        tambahUserB.setBorder(null);
        tambahUserB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahUserB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahUserBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pilih ID Petugas terlebih dahulu");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1637, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(tambahUserB, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahUserB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
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
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );

        panelBawah.add(pengaturanPanel, "card8");

        staffPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleStaff.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleStaff.setForeground(new java.awt.Color(51, 51, 51));
        titleStaff.setText("Title");

        staffField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        caristaffB.setBackground(new java.awt.Color(51, 153, 255));
        caristaffB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        caristaffB.setForeground(new java.awt.Color(255, 255, 255));
        caristaffB.setText("Cari");
        caristaffB.setBorder(null);
        caristaffB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caristaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caristaffBActionPerformed(evt);
            }
        });

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

        staffTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        staffTabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffTabelFocusGained(evt);
            }
        });
        jScrollPane7.setViewportView(staffTabel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addComponent(titleStaff)
                        .addGap(49, 49, 49)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(staffPanelLayout.createSequentialGroup()
                                .addComponent(tambahstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hapusstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(staffField))
                        .addGap(18, 18, 18)
                        .addComponent(caristaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleStaff))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caristaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusstaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        panelBawah.add(staffPanel, "card5");

        siswaPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleSiswa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleSiswa.setForeground(new java.awt.Color(51, 51, 51));
        titleSiswa.setText("Title");

        tingkatSiswaCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tingkatSiswaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tingkat", "10", "11", "12", "Alumni" }));
        tingkatSiswaCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tingkatSiswaCBItemStateChanged(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Tingkat");

        cariSiswaField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cariSiswaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSiswaFieldActionPerformed(evt);
            }
        });

        cariSiswaB.setBackground(new java.awt.Color(51, 153, 255));
        cariSiswaB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cariSiswaB.setForeground(new java.awt.Color(255, 255, 255));
        cariSiswaB.setText("Cari");
        cariSiswaB.setBorder(null);
        cariSiswaB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariSiswaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSiswaBActionPerformed(evt);
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

        siswaTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        siswaTabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                siswaTabelFocusGained(evt);
            }
        });
        jScrollPane10.setViewportView(siswaTabel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel2);

        jurusanSiswaCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jurusanSiswaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jurusan" }));
        jurusanSiswaCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jurusanSiswaCBItemStateChanged(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(51, 51, 51));
        jLabel93.setText("Jurusan");

        kelasSiswaCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kelasSiswaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas", "1", "2", "3" }));
        kelasSiswaCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kelasSiswaCBItemStateChanged(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(51, 51, 51));
        jLabel94.setText("Kelas");

        javax.swing.GroupLayout siswaPanelLayout = new javax.swing.GroupLayout(siswaPanel);
        siswaPanel.setLayout(siswaPanelLayout);
        siswaPanelLayout.setHorizontalGroup(
            siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE)
                    .addGroup(siswaPanelLayout.createSequentialGroup()
                        .addComponent(titleSiswa)
                        .addGap(51, 51, 51)
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tingkatSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(siswaPanelLayout.createSequentialGroup()
                                .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(siswaPanelLayout.createSequentialGroup()
                                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel93)
                                    .addComponent(jurusanSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel94)
                                    .addComponent(kelasSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cariSiswaField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariSiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariSiswaField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(siswaPanelLayout.createSequentialGroup()
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tingkatSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jurusanSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kelasSiswaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cariSiswaB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        panelBawah.add(siswaPanel, "card3");

        presensiPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePresensi.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePresensi.setForeground(new java.awt.Color(51, 51, 51));
        titlePresensi.setText("Title");

        jPanel39.setBackground(new java.awt.Color(0, 153, 255));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane24.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jScrollPane23.setViewportView(jPanel39);

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setText("NIS / Kode Anggota");

        jTextField10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton20.setBackground(new java.awt.Color(51, 153, 255));
        jButton20.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Cari");
        jButton20.setBorder(null);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tambahPresensiB.setBackground(new java.awt.Color(0, 204, 0));
        tambahPresensiB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tambahPresensiB.setForeground(new java.awt.Color(255, 255, 255));
        tambahPresensiB.setText("Tambah");
        tambahPresensiB.setBorder(null);
        tambahPresensiB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        editPresensiB.setBackground(new java.awt.Color(255, 153, 0));
        editPresensiB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editPresensiB.setForeground(new java.awt.Color(255, 255, 255));
        editPresensiB.setText("Edit");
        editPresensiB.setBorder(null);
        editPresensiB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        hapusPresensiB.setBackground(new java.awt.Color(255, 0, 0));
        hapusPresensiB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        hapusPresensiB.setForeground(new java.awt.Color(255, 255, 255));
        hapusPresensiB.setText("Hapus");
        hapusPresensiB.setBorder(null);
        hapusPresensiB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout presensiPanelLayout = new javax.swing.GroupLayout(presensiPanel);
        presensiPanel.setLayout(presensiPanelLayout);
        presensiPanelLayout.setHorizontalGroup(
            presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presensiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 1657, Short.MAX_VALUE)
                    .addGroup(presensiPanelLayout.createSequentialGroup()
                        .addGroup(presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePresensi)
                            .addGroup(presensiPanelLayout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addGap(44, 44, 44)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(presensiPanelLayout.createSequentialGroup()
                                .addComponent(tambahPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        presensiPanelLayout.setVerticalGroup(
            presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presensiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePresensi)
                .addGap(18, 18, 18)
                .addGroup(presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(presensiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusPresensiB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        panelBawah.add(presensiPanel, "card12");

        getContentPane().add(panelBawah, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void caristaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caristaffBActionPerformed
        // TODO add your handling code here:
        staffTabel.setRowSorter(ts2);
        if(staffField.equals(""))
            ts2.setRowFilter(RowFilter.regexFilter(""));
        else
            ts2.setRowFilter(RowFilter.regexFilter(staffField.getText()));
            
    }//GEN-LAST:event_caristaffBActionPerformed

    public final class Allow {
    private Allow(){}
        public Boolean allow_ = true;
    }
    
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
        editBuku eb = new editBuku(value);
        eb.setVisible(true); 
    }//GEN-LAST:event_editbukuBActionPerformed

    private void bukuTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuTabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bukuTabelMouseClicked

    private void tambahUserBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahUserBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = userTabel.getSelectedRow();
        String value = userTabel.getModel().getValueAt(row, column).toString();
        System.out.println(value);
        tambaheditAkun tea = new tambaheditAkun(value);
        tea.setVisible(true);
    }//GEN-LAST:event_tambahUserBActionPerformed

    private void hapusbukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbukuBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = bukuTabel.getSelectedRow();
        String value = bukuTabel.getModel().getValueAt(row, column).toString();
        n.deleteBuku(value);
        modelbuku();
    }//GEN-LAST:event_hapusbukuBActionPerformed

    private void KategoriCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KategoriCBItemStateChanged
        // TODO add your handling code here:
        bukuTabel.setRowSorter(tr);
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = evt.getItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        if(Kategori.equals("Kategori")){
            if(lokasi.equals("Rak")){
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }
        }else{
            tr.setRowFilter(RowFilter.regexFilter(Kategori));
        }
    }//GEN-LAST:event_KategoriCBItemStateChanged

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
        if(jenis.equals("Jenis")){
            KategoriCB.setEnabled(false);
            if(lokasi.equals("Rak")){
                tr.setRowFilter(RowFilter.regexFilter(""));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }    
            else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }
        }
        else
            tr.setRowFilter(RowFilter.regexFilter(jenis));
            
    }//GEN-LAST:event_JenisCBItemStateChanged

    private void bukuTabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bukuTabelFocusGained
        // TODO add your handling code here:
        editbukuB.setEnabled(true);
        hapusbukuB.setEnabled(true);
    }//GEN-LAST:event_bukuTabelFocusGained

    private void rakCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rakCBItemStateChanged
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        if(!lokasi.equals("Rak")){
            tr.setRowFilter(RowFilter.regexFilter(lokasi));
        }
        else{
            if(jenis.equals("Jenis")){
                tr.setRowFilter(RowFilter.regexFilter(""));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }
            else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!Kategori.equals("Kategori"))
                    tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }
        }
            
    }//GEN-LAST:event_rakCBItemStateChanged

    private void cariBukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBukuBActionPerformed
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        if(nama.equals("")){
            if(jenis.equals("Jenis")){
               tr.setRowFilter(RowFilter.regexFilter(""));
               if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
               if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }else if(Kategori.equals("Kategori")){
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }
        }else
            tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            if(jenis.equals("Jenis")){
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }else if(Kategori.equals("Kategori")){
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
            }
    }//GEN-LAST:event_cariBukuBActionPerformed

    private void thnCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thnCBItemStateChanged
        // TODO add your handling code here:
        String lokasi = rakCB.getSelectedItem().toString();
        String jenis = JenisCB.getSelectedItem().toString();
        String Kategori = KategoriCB.getSelectedItem().toString();
        String tahun = thnCB.getSelectedItem().toString();
        String nama = cariTF.getText();
        bukuTabel.setRowSorter(tr);
        if(tahun.equals("Tahun Buku")){
            tr.setRowFilter(RowFilter.regexFilter(""));
            if(!jenis.equals("Jenis")){
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!Kategori.equals("Kategori"))
                    tr.setRowFilter(RowFilter.regexFilter(Kategori));
            }
            if(!lokasi.equals("Rak"))
                tr.setRowFilter(RowFilter.regexFilter(lokasi));
            if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
        }
        else
            tr.setRowFilter(RowFilter.regexFilter("^"+tahun+"$"));
    }//GEN-LAST:event_thnCBItemStateChanged

    private void tambahsiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahsiswaBActionPerformed
        // TODO add your handling code here:
        tambahSiswa ts = new tambahSiswa();
        ts.setVisible(true);
        
    }//GEN-LAST:event_tambahsiswaBActionPerformed

    private void editsiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsiswaBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = siswaTabel.getSelectedRow();
        String value = siswaTabel.getModel().getValueAt(row, column).toString();
        editSiswa es = new editSiswa(value);
        es.setVisible(true);
    }//GEN-LAST:event_editsiswaBActionPerformed

    private void hapussiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapussiswaBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = siswaTabel.getSelectedRow();
        String value = siswaTabel.getModel().getValueAt(row, column).toString();
        n.deleteSiswa(value);
    }//GEN-LAST:event_hapussiswaBActionPerformed

    private void siswaTabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_siswaTabelFocusGained
        // TODO add your handling code here:
        editsiswaB.setEnabled(true);
        hapussiswaB.setEnabled(true);
    }//GEN-LAST:event_siswaTabelFocusGained

    private void tambahstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahstaffBActionPerformed
        // TODO add your handling code here:
        tambaheditStaff te = new tambaheditStaff();
        te.setVisible(true);
    }//GEN-LAST:event_tambahstaffBActionPerformed

    private void hapusstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusstaffBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = staffTabel.getSelectedRow();
        String value = staffTabel.getModel().getValueAt(row, column).toString();
        n.deleteStaff(value);
    }//GEN-LAST:event_hapusstaffBActionPerformed

    private void staffTabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffTabelFocusGained
        // TODO add your handling code here:
        editstaffB.setEnabled(true);
        hapusstaffB.setEnabled(true);
    }//GEN-LAST:event_staffTabelFocusGained

    private void editstaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editstaffBActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = staffTabel.getSelectedRow();
        String value = staffTabel.getModel().getValueAt(row, column).toString();
        tambaheditStaff te = new tambaheditStaff(value);
        te.setVisible(true);
    }//GEN-LAST:event_editstaffBActionPerformed

    private void siswaBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siswaBAtasActionPerformed
        // TODO add your handling code here:
        editsiswaB.setEnabled(false);
        hapussiswaB.setEnabled(false);
        model_siswa.setRowCount(0);
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
        ResultSet rs;
        
        String q, w, e, r, t, y, u;
        try {
                rs = stmt.executeQuery("select * from perpus.siswa_view");
                while(rs.next()){
                q = rs.getString("nis");
                w = rs.getString("nama");
                e = rs.getString("tingkat");
                r = rs.getString("jurusan");
                t = rs.getString("kelas");
                y = rs.getString("alamat");
                u = rs.getString("no_telp");
                model_siswa.addRow(new Object[]{q, w, e, r, t,y,u});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        
        //jurusan
        try{
            ResultSet rs_jurusan = stmt.executeQuery("select distinct kelas.jurusan from perpus.kelas order by kelas.jurusan asc");
            while(rs_jurusan.next()){
                String jurusan = rs_jurusan.getString("jurusan");
               jurusanSiswaCB.addItem(jurusan); 
            }   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
        
        this.titleSiswa.setText("Siswa");
        panelBawah.removeAll();
        panelBawah.add(siswaPanel);
        siswaTabel.setModel(model_siswa);
        siswaTabel.setAutoCreateRowSorter(true);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_siswaBAtasActionPerformed

    private void bukuBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuBAtasActionPerformed
        // TODO add your handling code here:
        model_buku.setRowCount(0);
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
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
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
        editbukuB.setEnabled(false);
        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_bukuBAtasActionPerformed
    
    public void modelbuku(){
        model_buku.setRowCount(0);
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
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
        panelBawah.add(bukuPanel);
        bukuTabel.setModel(model_buku);
        bukuTabel.setAutoCreateRowSorter(true);
        editbukuB.setEnabled(false);
        hapusbukuB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }
    
    private void staffBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBAtasActionPerformed
        // TODO add your handling code here:
        editstaffB.setEnabled(false);
        hapusstaffB.setEnabled(false);
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
        ResultSet rs;
        
        String q, w, e, r;
        
        try {
                rs = stmt.executeQuery("select * from perpus.petugas");
                while(rs.next()){
                q = rs.getString("id_petugas");
                w = rs.getString("nama");
                e = rs.getString("alamat");
                r = rs.getString("no_telp");
                model_staff.addRow(new Object[]{q, w, e, r});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        
        this.titleStaff.setText("Staff");
        panelBawah.removeAll();
        panelBawah.add(staffPanel);
        staffTabel.setModel(model_staff);
        panelBawah.repaint();
        panelBawah.revalidate();
        
    }//GEN-LAST:event_staffBAtasActionPerformed

    private void settingBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBAtasActionPerformed
        // TODO add your handling code here:
        MysqlCon send = new MysqlCon( );
        
        Statement stmt = send.query();
        ResultSet rs;
        
        String q, w, e;
        
        try {
                rs = stmt.executeQuery("select * from perpus.petugas");
                while(rs.next()){
                q = rs.getString("id_petugas");
                w = rs.getString("username");
                e = rs.getString("password");
                model_user.addRow(new Object[]{q,w,e});}
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
            }
        this.titlePengaturan.setText("Pengaturan");
        panelBawah.removeAll();
        panelBawah.add(pengaturanPanel);
        userTabel.setModel(model_user);
        tambahUserB.setEnabled(false);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_settingBAtasActionPerformed

    private void cariSiswaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSiswaBActionPerformed
        // TODO add your handling code here:
        siswaTabel.setRowSorter(ts);
        String tingkat = tingkatSiswaCB.getSelectedItem().toString();
        String jurusan = jurusanSiswaCB.getSelectedItem().toString();
        String kelas = kelasSiswaCB.getSelectedItem().toString();
        String nama = cariSiswaField.getText();
        if(nama.equals("")){
            ts.setRowFilter(RowFilter.regexFilter(""));
            if(!jurusan.equals("Jurusan"))
                ts.setRowFilter(RowFilter.regexFilter(jurusan));
            if(!tingkat.equals("Tingkat"))
                ts.setRowFilter(RowFilter.regexFilter(tingkat));
            if(!kelas.equals("Kelas"))
                ts.setRowFilter(RowFilter.regexFilter(kelas));
        }else
            ts.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
    }//GEN-LAST:event_cariSiswaBActionPerformed

    private void cariSiswaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSiswaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariSiswaFieldActionPerformed

    private void tingkatSiswaCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tingkatSiswaCBItemStateChanged
        // TODO add your handling code here:
        siswaTabel.setRowSorter(ts);
        String tingkat = tingkatSiswaCB.getSelectedItem().toString();
        String jurusan = jurusanSiswaCB.getSelectedItem().toString();
        String kelas = kelasSiswaCB.getSelectedItem().toString();
        String nama = cariSiswaField.getText();
        if(tingkat.equals("Tingkat")){
            ts.setRowFilter(RowFilter.regexFilter(""));
            if(!jurusan.equals("Jurusan"))
                ts.setRowFilter(RowFilter.regexFilter(jurusan));
            if(!kelas.equals("Kelas"))
                ts.setRowFilter(RowFilter.regexFilter(kelas));
            if(!nama.equals(""))
                ts.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
        }else
            ts.setRowFilter(RowFilter.regexFilter(tingkat));
    }//GEN-LAST:event_tingkatSiswaCBItemStateChanged

    private void jurusanSiswaCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jurusanSiswaCBItemStateChanged
        // TODO add your handling code here:
        siswaTabel.setRowSorter(ts);
        String tingkat = tingkatSiswaCB.getSelectedItem().toString();
        String jurusan = jurusanSiswaCB.getSelectedItem().toString();
        String kelas = kelasSiswaCB.getSelectedItem().toString();
        String nama = cariSiswaField.getText();
        if(jurusan.equals("Jurusan")){
            ts.setRowFilter(RowFilter.regexFilter(""));
            if(!tingkat.equals("Tingkat"))
                ts.setRowFilter(RowFilter.regexFilter(tingkat));
            if(!kelas.equals("Kelas"))
                ts.setRowFilter(RowFilter.regexFilter(kelas));
            if(!nama.equals(""))
                ts.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
        }else
            ts.setRowFilter(RowFilter.regexFilter(jurusan));
    }//GEN-LAST:event_jurusanSiswaCBItemStateChanged

    private void kelasSiswaCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kelasSiswaCBItemStateChanged
        // TODO add your handling code here:
        siswaTabel.setRowSorter(ts);
        String tingkat = tingkatSiswaCB.getSelectedItem().toString();
        String jurusan = jurusanSiswaCB.getSelectedItem().toString();
        String kelas = kelasSiswaCB.getSelectedItem().toString();
        String nama = cariSiswaField.getText();
        if(kelas.equals("Kelas")){
            ts.setRowFilter(RowFilter.regexFilter(""));
            if(!tingkat.equals("Tingkat"))
                ts.setRowFilter(RowFilter.regexFilter(tingkat));
            if(!jurusan.equals("Jurusan"))
                ts.setRowFilter(RowFilter.regexFilter(jurusan));
            if(!nama.equals(""))
                ts.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
        }else
            ts.setRowFilter(RowFilter.regexFilter(kelas));
    }//GEN-LAST:event_kelasSiswaCBItemStateChanged

    private void presensiBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presensiBAtasActionPerformed
        // TODO add your handling code here:
        this.titlePresensi.setText("Presensi");
        panelBawah.removeAll();
        panelBawah.add(presensiPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_presensiBAtasActionPerformed

    private void caridatapinjamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridatapinjamBActionPerformed
        // TODO add your handling code here:
        datapinjamTabel.setRowSorter(tp);
        String pinjam = datapinjamField.getText();
        if(pinjam.equals(""))
            tp.setRowFilter(RowFilter.regexFilter(""));
        else
            tp.setRowFilter(RowFilter.regexFilter("^(?i)"+pinjam));
    }//GEN-LAST:event_caridatapinjamBActionPerformed

    private void userTabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTabelFocusGained
        // TODO add your handling code here:
        tambahUserB.setEnabled(true);
    }//GEN-LAST:event_userTabelFocusGained

    private void datapinjamBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datapinjamBAtasActionPerformed
        // TODO add your handling code here:
        model_datapinjam.setRowCount(0);
        MysqlCon send = new MysqlCon( );

        Statement stmt = send.query();
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
        panelBawah.add(datapinjamPanel);
        datapinjamTabel.setModel(model_datapinjam);
        datapinjamTabel.setAutoCreateRowSorter(true);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_datapinjamBAtasActionPerformed

    private void pengembalianBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengembalianBAtasActionPerformed
        // TODO add your handling code here:
        this.titlePengembalianUmum.setText("Pengembalian Buku");

        panelBawah.removeAll();
        panelBawah.add(pengembalianPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_pengembalianBAtasActionPerformed

    private void peminjamanBAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanBAtasActionPerformed
        // TODO add your handling code here:
        this.titlePemBukuUmum.setText("Peminjaman Buku Umum ");
        this.titlePemBukuMapel.setText("Peminjaman Buku Mapel ");
        panelBawah.removeAll();
        panelBawah.add(peminjamanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_peminjamanBAtasActionPerformed

    private void cariKembaliBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariKembaliBActionPerformed
        // TODO add your handling code here:
        model_kembali.setRowCount(0);
        String id = siswakembaliField.getText();
        MysqlCon send = new MysqlCon( );

            Statement stmt = send.query();
            ResultSet rs;
            ResultSet rs2;
        try{
            rs = stmt.executeQuery("select * from perpus.siswa_view where nis = "+id);
            while(rs.next()){
                LabelnamaKembali.setText(rs.getString("nama"));
                LabeltingkatKembali.setText(rs.getString("tingkat"));
                LabeljurusanKembali.setText(rs.getString("jurusan"));
                LabelkelasKembali.setText(rs.getString("kelas"));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        try{
            rs = stmt.executeQuery("select * from perpus.pinjam inner join perpus.book on pinjam.isbn = book.isbn where pinjam.nis = "+id);
            while(rs.next()){
                String id_trans = rs.getString("id_transaksi");
                String isbn = rs.getString("isbn");
                String judul = rs.getString("judul");
                String siswa = rs.getString("siswa");
                String t = rs.getString("t_pinjam");
                String j = rs.getString("jenis_buku");
                String k = rs.getString("kategori");
                model_kembali.addRow(new Object[]{id_trans,isbn,judul,siswa,j,k,t});}
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        
        bukuKembaliTabel.setModel(model_kembali);
        
        int row = 0;
        int i = 0;
        int max_row = model_kembali.getRowCount();
        int denda;
                if(dendaField.getText().equals(""))
                    denda = 0;
                else
                    denda = Integer.parseInt(dendaField.getText());
        try{            
            while(row<max_row){
            String id_trans = bukuKembaliTabel.getModel().getValueAt(row, 0).toString();
             rs = stmt.executeQuery("Select perpus.denda(CURDATE(),"+ id +","+ id_trans +","+ denda +") as denda");
            while(rs.next()){
                i = i + rs.getInt("denda");
                LabelDenda.setText(String.valueOf(i));
             }
            row++;
            if(row==max_row)
                break;
        }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
    }//GEN-LAST:event_cariKembaliBActionPerformed

    private void carisiswaPinjamMapelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carisiswaPinjamMapelBActionPerformed
        // TODO add your handling code here:
        MysqlCon send = new MysqlCon( );

        Statement stmt = send.query();
        ResultSet rs;

        String q,w,e,r,t,y;

        String tingkat = tingkatPinjamMapelCB.getSelectedItem().toString();
        String jurusan = jurusanPinjamMapelCB.getSelectedItem().toString();
        String kelas = kelasPinjamMapelCB.getSelectedItem().toString();

        try{
            rs = stmt.executeQuery("select * from perpus.siswa_view where tingkat = "+tingkat+" and jurusan = '"+jurusan+"' and kelas = "+kelas);
            while(rs.next()){
                q = rs.getString("nis");
                w = rs.getString("nama");
                e = rs.getString("alamat");
                r = rs.getString("no_telp");
                model_siswapinjam.addRow(new Object[]{q,w,e,r});}
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }

        try{
            rs = stmt.executeQuery("select * from perpus.buku where jenis_buku = 'Mapel' and kategori = perpus.ambil_kategori_jurusan("+tingkat+",'"+jurusan+"',"+kelas+")");
            while(rs.next()){
                q = rs.getString("isbn");
                w = rs.getString("judul");
                e = rs.getString("thn_buku");
                r = rs.getString("jenis_buku");
                t = rs.getString("kategori");
                y = rs.getString("lokasi");
                model_bukupinjam.addRow(new Object[]{q,w,e,r,t,y});
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
        bukuPinjamMapelTabel.setModel(model_bukupinjam);
        siswaPinjamMapelTabel.setModel(model_siswapinjam);
    }//GEN-LAST:event_carisiswaPinjamMapelBActionPerformed

    private void hariFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hariFieldFocusGained
        // TODO add your handling code here:
        hariField.setText("");
    }//GEN-LAST:event_hariFieldFocusGained

    private void bulanfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bulanfieldFocusGained
        // TODO add your handling code here:
        bulanfield.setText("");
    }//GEN-LAST:event_bulanfieldFocusGained

    private void tahunFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunFieldActionPerformed

    private void tahunFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tahunFieldFocusGained
        // TODO add your handling code here:
        tahunField.setText("");
    }//GEN-LAST:event_tahunFieldFocusGained

    private void simpanPinjamMapelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanPinjamMapelBActionPerformed
        // TODO add your handling code here:
        try{
            crud c = new crud();
            MysqlCon send = new MysqlCon( );

            Statement stmt = send.query();
            ResultSet rs;
            int row = 0;
            int row2 = 0;
            int max_row = model_siswapinjam.getRowCount();
            int max_row2 = model_bukupinjam.getRowCount();
            String dedlain = tahunField.getText()+"-"+bulanfield.getText()+"-"+hariField.getText();
            rs = stmt.executeQuery("select id_petugas from perpus.petugas where nama = '"+LabelUser.getText()+"'");
            while(rs.next()){
                String petugas = rs.getString("id_petugas");
                while(row2<max_row2){
                    String isbn = bukuPinjamMapelTabel.getModel().getValueAt(row2, 0).toString();
                    while(row<max_row){
                        String nis = siswaPinjamMapelTabel.getModel().getValueAt(row, 0).toString();
                        int rs2 = c.createPinjam2(nis, petugas, isbn, dedlain);
                        if(rs2!=0){
                            row++;
                            if(row==max_row){
                                row2++;
                                row = 0;
                            }else
                            continue;
                        }
                        else{
                            JOptionPane.showMessageDialog(this, rs, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        }
                        if(row2==max_row2){
                            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        continue;
                    }
                }
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
    }//GEN-LAST:event_simpanPinjamMapelBActionPerformed

    private void resetbukuPinjamUmumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbukuPinjamUmumActionPerformed
        // TODO add your handling code here:
        model_bukupinjam.setRowCount(0);
    }//GEN-LAST:event_resetbukuPinjamUmumActionPerformed

    private void simpanPinjamUmumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanPinjamUmumActionPerformed
        // TODO add your handling code here:
        int row = 0;
        crud c = new crud();
        String nis = siswaPinjamUmumField.getText();
        String durasi = durasiField.getText();
        MysqlCon send = new MysqlCon( );
        int max_row  = model_bukupinjam.getRowCount();
        Statement stmt = send.query();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("select id_petugas from perpus.petugas where nama = '"+LabelUser.getText()+"'");
            while(rs.next()){
                String id = rs.getString("id_petugas");
                while(row<max_row){
                    String isbn = bukuPinjamMapelTabel.getModel().getValueAt(row, 0).toString();
                    int rs2 = c.createPinjam(nis, id, isbn, durasi);
                    if(rs2!=0){
                        row++;
                        if(row==max_row){
                            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        else
                        continue;
                    }else{
                        JOptionPane.showMessageDialog(this, rs, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }

    }//GEN-LAST:event_simpanPinjamUmumActionPerformed

    private void tambahbukuPinjamFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbukuPinjamFieldActionPerformed
        // TODO add your handling code here:
        String isbn = bukuPinjamUmumField.getText();
        MysqlCon send = new MysqlCon( );

        Statement stmt = send.query();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("select * from perpus.buku where jenis_buku = 'Umum' and isbn = "+isbn);
            while(rs.next()){
                String q = rs.getString("isbn");
                String w = rs.getString("judul");
                String e = rs.getString("thn_buku");
                String r = rs.getString("jenis_buku");
                String t = rs.getString("kategori");
                String y = rs.getString("lokasi");
                
                model_bukupinjam.addRow(new Object[]{q, w, e, r});
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }

        int count_row = model_bukupinjam.getRowCount();
        int max_pinjam = Integer.valueOf(maksField.getText());
        int row = 0;
        if(count_row==max_pinjam+1){
            JOptionPane.showMessageDialog(this, "Maksimal "+ max_pinjam +" buku" , "Kesalahan", JOptionPane.ERROR_MESSAGE);
            model_bukupinjam.setRowCount(Integer.parseInt(maksField.getText()));
        }
        bukuPinjamUmumTabel.setModel(model_bukupinjam);
    }//GEN-LAST:event_tambahbukuPinjamFieldActionPerformed

    private void cariSiswaPinjamUmumBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSiswaPinjamUmumBActionPerformed
        // TODO add your handling code here:
        String id = siswaPinjamUmumField.getText();
        MysqlCon send = new MysqlCon( );

        Statement stmt = send.query();
        ResultSet rs;
        try{
            rs = stmt.executeQuery("select * from perpus.siswa_view where nis = "+id);
            while(rs.next()){
                LabelnamaPinjamUmum.setText(rs.getString("nama"));
                LabeltingkatPinjamUmum.setText(rs.getString("tingkat"));
                LabeljurusanPinjamUmum.setText(rs.getString("jurusan"));
                LabelkelasPinjamUmum.setText(rs.getString("kelas"));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung : " + ex);
        }
    }//GEN-LAST:event_cariSiswaPinjamUmumBActionPerformed

    private void simpanKembaliBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKembaliBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        String q = dendaField.getText();
        String r = siswakembaliField.getText();
        int row;
        int max_row = model_kembali.getRowCount();
        if(bukuKembaliTabel.getSelectedRow() == -1){
            row = 0;
            while(max_row>row){
                String e = bukuKembaliTabel.getModel().getValueAt(row, 0).toString();
                int rs = n.createKembali(q, e, r);
                if(rs!=0){
                    row++;
                    if(row==max_row){
                        JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }else
                        continue;
                }
                else{
                    JOptionPane.showMessageDialog(this, rs, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else{
            row = bukuKembaliTabel.getSelectedRow();
            String e = bukuKembaliTabel.getModel().getValueAt(row, 0).toString();
            int rs = n.createKembali(q, e, r);
            if(rs!=0){
                    JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, rs, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
        }
                
                
    }//GEN-LAST:event_simpanKembaliBActionPerformed

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
    private javax.swing.JComboBox<String> JenisCB;
    private javax.swing.JComboBox<String> KategoriCB;
    private javax.swing.JLabel LabelDenda;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JLabel LabeljurusanKembali;
    private javax.swing.JLabel LabeljurusanPinjamUmum;
    private javax.swing.JLabel LabelkelasKembali;
    private javax.swing.JLabel LabelkelasPinjamUmum;
    private javax.swing.JLabel LabelnamaKembali;
    private javax.swing.JLabel LabelnamaPinjamUmum;
    private javax.swing.JLabel LabeltingkatKembali;
    private javax.swing.JLabel LabeltingkatPinjamUmum;
    private javax.swing.JButton bukuBAtas;
    private javax.swing.JTable bukuKembaliTabel;
    private javax.swing.JPanel bukuPanel;
    private javax.swing.JTable bukuPinjamMapelTabel;
    private javax.swing.JTextField bukuPinjamUmumField;
    private javax.swing.JTable bukuPinjamUmumTabel;
    private javax.swing.JTable bukuTabel;
    private javax.swing.JTextField bulanfield;
    private javax.swing.JButton cariBukuB;
    private javax.swing.JButton cariKembaliB;
    private javax.swing.JButton cariSiswaB;
    private javax.swing.JTextField cariSiswaField;
    private javax.swing.JButton cariSiswaPinjamUmumB;
    private javax.swing.JTextField cariTF;
    private javax.swing.JButton caridatapinjamB;
    private javax.swing.JButton carisiswaPinjamMapelB;
    private javax.swing.JButton caristaffB;
    private javax.swing.JButton datapinjamBAtas;
    private javax.swing.JTextField datapinjamField;
    private javax.swing.JPanel datapinjamPanel;
    private javax.swing.JTable datapinjamTabel;
    private javax.swing.JTextField dendaField;
    private javax.swing.JTextField durasiField;
    private javax.swing.JButton editPresensiB;
    private javax.swing.JButton editbukuB;
    private javax.swing.JButton editsiswaB;
    private javax.swing.JButton editstaffB;
    private javax.swing.JButton hapusPresensiB;
    private javax.swing.JButton hapusbukuB;
    private javax.swing.JButton hapussiswaB;
    private javax.swing.JButton hapusstaffB;
    private javax.swing.JTextField hariField;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JComboBox<String> jurusanPinjamMapelCB;
    private javax.swing.JComboBox<String> jurusanSiswaCB;
    private javax.swing.JPanel kasPanel;
    private javax.swing.JLabel kategoriL;
    private javax.swing.JComboBox<String> kelasPinjamMapelCB;
    private javax.swing.JComboBox<String> kelasSiswaCB;
    private javax.swing.JPanel laporanPanel;
    private javax.swing.JTextField maksField;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JPanel pemiMapelP;
    private javax.swing.JPanel pemiUmumP;
    private javax.swing.JButton peminjamanBAtas;
    private javax.swing.JPanel peminjamanPanel;
    private javax.swing.JLabel penerbitL1;
    private javax.swing.JLabel penerbitL2;
    private javax.swing.JPanel pengaturanPanel;
    private javax.swing.JPanel pengeUmumP;
    private javax.swing.JButton pengembalianBAtas;
    private javax.swing.JPanel pengembalianPanel;
    private javax.swing.JButton presensiBAtas;
    private javax.swing.JPanel presensiPanel;
    private javax.swing.JComboBox<String> rakCB;
    private javax.swing.JLabel rakL;
    private javax.swing.JLabel rakL2;
    private javax.swing.JButton resetbukuPinjamUmum;
    private javax.swing.JButton settingBAtas;
    private javax.swing.JButton simpanKembaliB;
    private javax.swing.JButton simpanPinjamMapelB;
    private javax.swing.JButton simpanPinjamUmum;
    private javax.swing.JButton siswaBAtas;
    private javax.swing.JPanel siswaPanel;
    private javax.swing.JTable siswaPinjamMapelTabel;
    private javax.swing.JTextField siswaPinjamUmumField;
    private javax.swing.JTable siswaTabel;
    private javax.swing.JTextField siswakembaliField;
    private javax.swing.JButton staffBAtas;
    private javax.swing.JTextField staffField;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JTable staffTabel;
    private javax.swing.JLabel sumberL;
    private javax.swing.JTextField tahunField;
    private javax.swing.JButton tambahPresensiB;
    private javax.swing.JButton tambahUserB;
    private javax.swing.JButton tambahbukuB;
    private javax.swing.JButton tambahbukuPinjamField;
    private javax.swing.JButton tambahsiswaB;
    private javax.swing.JButton tambahstaffB;
    private javax.swing.JComboBox<String> thnCB;
    private javax.swing.JComboBox<String> tingkatPinjamMapelCB;
    private javax.swing.JComboBox<String> tingkatSiswaCB;
    private javax.swing.JLabel titleBuku;
    private javax.swing.JLabel titleDatapinjam;
    private javax.swing.JLabel titleKas;
    private javax.swing.JLabel titleLaporan;
    private javax.swing.JLabel titlePemBukuMapel;
    private javax.swing.JLabel titlePemBukuUmum;
    private javax.swing.JLabel titlePengaturan;
    private javax.swing.JLabel titlePengembalianUmum;
    private javax.swing.JLabel titlePresensi;
    private javax.swing.JLabel titleSiswa;
    private javax.swing.JLabel titleStaff;
    private javax.swing.JTable userTabel;
    // End of variables declaration//GEN-END:variables
}
