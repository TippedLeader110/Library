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
     DefaultTableModel model_pinjam = new DefaultTableModel(new String[]{"ISBN", "Judul", "Tahun Buku", "Lokasi"}, 0){
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
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model_buku);
     TableRowSorter<DefaultTableModel> ts = new TableRowSorter<DefaultTableModel>(model_siswa);
     TableRowSorter<DefaultTableModel> ts2 = new TableRowSorter<DefaultTableModel>(model_staff);
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
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        panelBawah = new javax.swing.JPanel();
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
        ResetBukuB = new javax.swing.JButton();
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
        PengembalianUmumPanel = new javax.swing.JPanel();
        titlePengembalianUmum = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        kodeanggota1 = new javax.swing.JLabel();
        nama1 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        datapinjamPanel = new javax.swing.JPanel();
        titleDatapinjam = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        PengembalianMapelPanel = new javax.swing.JPanel();
        titlePengembalianMapel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        kodeanggota = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        PeminjamanMapelPanel = new javax.swing.JPanel();
        titlePeminjamanMapel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pengaturanPanel = new javax.swing.JPanel();
        titlePengaturan = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        passwordPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        backofficePanel = new javax.swing.JPanel();
        titleBackoffice = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ekspordataBuku = new javax.swing.JButton();
        ekspordataBuku1 = new javax.swing.JButton();
        ekspordataBuku2 = new javax.swing.JButton();
        ekspordataBuku3 = new javax.swing.JButton();
        ekspordataBuku4 = new javax.swing.JButton();
        ekspordataBuku5 = new javax.swing.JButton();
        backupdbB = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        impordataBuku = new javax.swing.JButton();
        impordataSiswa = new javax.swing.JButton();
        impordataStaff = new javax.swing.JButton();
        impordataGuru = new javax.swing.JButton();
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
        guruPanel = new javax.swing.JPanel();
        titleGuru = new javax.swing.JLabel();
        cariguruTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tambahguruB = new javax.swing.JButton();
        editguruB = new javax.swing.JButton();
        hapusguruB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        PeminjamanUmumPanel = new javax.swing.JPanel();
        titlePeminjamanUmum = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton33 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        siswaPanel = new javax.swing.JPanel();
        titleSiswa = new javax.swing.JLabel();
        angkatanSiswaCB = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        tambahsiswaB = new javax.swing.JButton();
        editsiswaB = new javax.swing.JButton();
        hapussiswaB = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        siswaTabel = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        BukuMB = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        SiswaMB = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        StaffMB = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        PasswordMB = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        SettingMB = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        peminjBUmumMB = new javax.swing.JMenuItem();
        PeminjBMapelMB = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIstem Pengelolaan Perpustakaan (v 0.0.1)");

        panelAtas.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang,");

        LabelUser.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("<Username>");

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

        jLabel29.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Password");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Pengaturan");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Peminjaman");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Pengembalian");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Data Pinjam");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Kas");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Laporan");

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(28, 28, 28)
                .addComponent(jLabel36)
                .addGap(46, 46, 46)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(LabelUser)
                .addGap(108, 108, 108))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(LabelUser))
                    .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel25)
                        .addComponent(jLabel27)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30)
                        .addComponent(jLabel31)
                        .addComponent(jLabel32)
                        .addComponent(jLabel33)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelAtas, java.awt.BorderLayout.PAGE_START);

        panelBawah.setBackground(new java.awt.Color(255, 255, 255));
        panelBawah.setLayout(new java.awt.CardLayout());

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
                .addContainerGap(49, Short.MAX_VALUE))
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

        ResetBukuB.setBackground(new java.awt.Color(255, 255, 255));
        ResetBukuB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ResetBukuB.setText("Reset");
        ResetBukuB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ResetBukuB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResetBukuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBukuBActionPerformed(evt);
            }
        });

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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
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
                                .addGap(18, 18, 18)
                                .addComponent(ResetBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
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
                                .addComponent(hapusbukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ResetBukuB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bukuPanelLayout.createSequentialGroup()
                        .addComponent(penerbitL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(penerbitL2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(821, Short.MAX_VALUE))
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
                .addContainerGap(368, Short.MAX_VALUE))
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
                .addContainerGap(48, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane16))
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
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        panelBawah.add(kasPanel, "card11");

        PengembalianUmumPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengembalianUmum.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengembalianUmum.setForeground(new java.awt.Color(51, 51, 51));
        titlePengembalianUmum.setText("Title");

        jPanel18.setBackground(new java.awt.Color(51, 153, 255));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Kode Anggota");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel47.setText("Nama");

        jLabel59.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel59.setText("Kelas");

        kodeanggota1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kodeanggota1.setText("<kode anggota>");

        nama1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama1.setText("<nama>");

        jLabel60.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel60.setText("<kelas>");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(37, 37, 37)
                        .addComponent(kodeanggota1)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel47)
                        .addGap(50, 50, 50)
                        .addComponent(nama1)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel59)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel60)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel47)
                    .addComponent(jLabel59)
                    .addComponent(kodeanggota1)
                    .addComponent(nama1)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel61.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("NIS / Kode Anggota");

        jTextField8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton11.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton11.setText("Cari");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Kode Buku");

        jTextField13.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton30.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton30.setText("Cari");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(jTable11);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel65.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("<nominaldenda>");

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
                .addComponent(jLabel65)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton31.setBackground(new java.awt.Color(51, 204, 0));
        jButton31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Simpan");
        jButton31.setBorder(null);
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton32.setForeground(new java.awt.Color(51, 51, 51));
        jButton32.setText("Baru");
        jButton32.setBorder(null);
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(63, 63, 63)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(142, 142, 142)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PengembalianUmumPanelLayout = new javax.swing.GroupLayout(PengembalianUmumPanel);
        PengembalianUmumPanel.setLayout(PengembalianUmumPanelLayout);
        PengembalianUmumPanelLayout.setHorizontalGroup(
            PengembalianUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengembalianUmumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PengembalianUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePengembalianUmum)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        PengembalianUmumPanelLayout.setVerticalGroup(
            PengembalianUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengembalianUmumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePengembalianUmum)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(PengembalianUmumPanel, "card13");

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

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(jTable7);

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
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBawah.add(datapinjamPanel, "card14");

        PengembalianMapelPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengembalianMapel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengembalianMapel.setForeground(new java.awt.Color(51, 51, 51));
        titlePengembalianMapel.setText("Title");

        jPanel12.setBackground(new java.awt.Color(51, 153, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Kode Anggota");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setText("Nama");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setText("Kelas");

        kodeanggota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kodeanggota.setText("<kode anggota>");

        nama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama.setText("<nama>");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("<kelas>");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(37, 37, 37)
                        .addComponent(kodeanggota)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel38)
                        .addGap(50, 50, 50)
                        .addComponent(nama)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel40)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel41)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel38)
                    .addComponent(jLabel40)
                    .addComponent(kodeanggota)
                    .addComponent(nama)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel42.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("NIS / Kode Anggota");

        jTextField5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton6.setText("Cari");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Kode Buku");

        jTextField6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton7.setText("Cari");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(142, 142, 142)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PengembalianMapelPanelLayout = new javax.swing.GroupLayout(PengembalianMapelPanel);
        PengembalianMapelPanel.setLayout(PengembalianMapelPanelLayout);
        PengembalianMapelPanelLayout.setHorizontalGroup(
            PengembalianMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengembalianMapelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PengembalianMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePengembalianMapel)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        PengembalianMapelPanelLayout.setVerticalGroup(
            PengembalianMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengembalianMapelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePengembalianMapel)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(PengembalianMapelPanel, "card15");

        PeminjamanMapelPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePeminjamanMapel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePeminjamanMapel.setForeground(new java.awt.Color(51, 51, 51));
        titlePeminjamanMapel.setText("Title");

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NIS / Kode Anggota");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton2.setText("Cari");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("NIS / Kode Anggota");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Nama");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Kelas");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("<NIS/KA>");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("<Nama>");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("<Kelas>");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Maks. Pinjam");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Tanggungan");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("<Maks. Pinjam>");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("<Tanggungan>");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Jenis Anggota");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Durasi Pinjam");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("<Jenis Anggota>");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("<Durasi Pinjam>");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel11)
                        .addGap(136, 136, 136))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(125, 125, 125)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel17))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel16)))
                .addGap(96, 96, 96)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18)))
                .addGap(66, 66, 66)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel17))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))))))
                .addContainerGap(33, Short.MAX_VALUE))
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
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(51, 153, 255));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Kode Buku");

        jTextField4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton3.setText("Cari");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable3);

        jButton4.setBackground(new java.awt.Color(51, 204, 0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Simpan");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Baru");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(146, 146, 146)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PeminjamanMapelPanelLayout = new javax.swing.GroupLayout(PeminjamanMapelPanel);
        PeminjamanMapelPanel.setLayout(PeminjamanMapelPanelLayout);
        PeminjamanMapelPanelLayout.setHorizontalGroup(
            PeminjamanMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanMapelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PeminjamanMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePeminjamanMapel)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PeminjamanMapelPanelLayout.setVerticalGroup(
            PeminjamanMapelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanMapelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePeminjamanMapel)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(PeminjamanMapelPanel, "card9");

        pengaturanPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePengaturan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePengaturan.setForeground(new java.awt.Color(51, 51, 51));
        titlePengaturan.setText("Title");

        jPanel21.setBackground(new java.awt.Color(51, 153, 255));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Pengaturan Akun Operator");

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
        jScrollPane19.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1417, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(51, 153, 255));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Pengaturan Durasi Peminjaman dan Denda Keterlambatan");

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Siswa");

        jTextField9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel51)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Guru");

        jTextField10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel55)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel56.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("Staff");

        jTextField11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel56)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Denda (Rp)");

        jTextField12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton19.setBackground(new java.awt.Color(0, 204, 0));
        jButton19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Simpan");
        jButton19.setBorder(null);
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton20.setBackground(new java.awt.Color(255, 0, 0));
        jButton20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Batal");
        jButton20.setBorder(null);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pengaturanPanelLayout.setVerticalGroup(
            pengaturanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengaturanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePengaturan)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(pengaturanPanel, "card8");

        passwordPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Title");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(1397, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(672, Short.MAX_VALUE))
        );

        panelBawah.add(passwordPanel, "card7");

        backofficePanel.setBackground(new java.awt.Color(255, 255, 255));

        titleBackoffice.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleBackoffice.setForeground(new java.awt.Color(51, 51, 51));
        titleBackoffice.setText("Title");

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ekspor Data ke Microsoft Excel");

        ekspordataBuku.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku.setText("Ekspor Data Guru");
        ekspordataBuku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ekspordataBuku1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku1.setText("Ekspor Data Pinjam");
        ekspordataBuku1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ekspordataBuku2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku2.setText("Ekspor Data Pendapatan Denda");
        ekspordataBuku2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ekspordataBuku3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku3.setText("Ekspor Data Staff");
        ekspordataBuku3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ekspordataBuku4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku4.setText("Ekspor Data Siswa");
        ekspordataBuku4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ekspordataBuku5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekspordataBuku5.setText("Ekspor Data Guru");
        ekspordataBuku5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ekspordataBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ekspordataBuku1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ekspordataBuku2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(ekspordataBuku3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ekspordataBuku4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ekspordataBuku5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ekspordataBuku5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        backupdbB.setBackground(new java.awt.Color(0, 204, 0));
        backupdbB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        backupdbB.setForeground(new java.awt.Color(255, 255, 255));
        backupdbB.setText("Backup Database");
        backupdbB.setBorder(null);
        backupdbB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel9.setBackground(new java.awt.Color(51, 153, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Impor Data dari Microsoft Excel");

        impordataBuku.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        impordataBuku.setText("Impor Data Buku");
        impordataBuku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        impordataSiswa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        impordataSiswa.setText("Impor Data Siswa");
        impordataSiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        impordataStaff.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        impordataStaff.setText("Impor Data Staff");
        impordataStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        impordataGuru.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        impordataGuru.setText("Impot Data Guru");
        impordataGuru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(impordataBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(impordataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(impordataStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(impordataGuru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(impordataBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(impordataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(impordataStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(impordataGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backofficePanelLayout = new javax.swing.GroupLayout(backofficePanel);
        backofficePanel.setLayout(backofficePanelLayout);
        backofficePanelLayout.setHorizontalGroup(
            backofficePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backofficePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBackoffice)
                .addContainerGap(1397, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backofficePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backofficePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backupdbB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backofficePanelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(256, 256, 256))
        );
        backofficePanelLayout.setVerticalGroup(
            backofficePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backofficePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBackoffice)
                .addGap(31, 31, 31)
                .addComponent(backupdbB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backofficePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(backofficePanel, "card6");

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
                    .addComponent(jScrollPane6)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(staffPanel, "card5");

        guruPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleGuru.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleGuru.setForeground(new java.awt.Color(51, 51, 51));
        titleGuru.setText("Title");

        cariguruTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cari");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tambahguruB.setBackground(new java.awt.Color(51, 153, 0));
        tambahguruB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tambahguruB.setForeground(new java.awt.Color(255, 255, 255));
        tambahguruB.setText("Tambah");
        tambahguruB.setBorder(null);
        tambahguruB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahguruB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahguruBActionPerformed(evt);
            }
        });

        editguruB.setBackground(new java.awt.Color(255, 153, 0));
        editguruB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editguruB.setForeground(new java.awt.Color(255, 255, 255));
        editguruB.setText("Edit ");
        editguruB.setBorder(null);
        editguruB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        hapusguruB.setBackground(new java.awt.Color(255, 0, 0));
        hapusguruB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hapusguruB.setForeground(new java.awt.Color(255, 255, 255));
        hapusguruB.setText("Hapus");
        hapusguruB.setBorder(null);
        hapusguruB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout guruPanelLayout = new javax.swing.GroupLayout(guruPanel);
        guruPanel.setLayout(guruPanelLayout);
        guruPanelLayout.setHorizontalGroup(
            guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guruPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(guruPanelLayout.createSequentialGroup()
                        .addComponent(titleGuru)
                        .addGap(48, 48, 48)
                        .addGroup(guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(guruPanelLayout.createSequentialGroup()
                                .addComponent(tambahguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(editguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hapusguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cariguruTF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        guruPanelLayout.setVerticalGroup(
            guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guruPanelLayout.createSequentialGroup()
                .addGroup(guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guruPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleGuru))
                    .addGroup(guruPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariguruTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(guruPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusguruB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(guruPanel, "card4");

        PeminjamanUmumPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePeminjamanUmum.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titlePeminjamanUmum.setForeground(new java.awt.Color(51, 51, 51));
        titlePeminjamanUmum.setText("Title");

        jPanel35.setBackground(new java.awt.Color(51, 153, 255));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Kode Buku");

        jTextField14.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton33.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton33.setText("Cari");
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane20.setBackground(new java.awt.Color(255, 255, 255));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(jTable12);

        jButton34.setBackground(new java.awt.Color(51, 204, 0));
        jButton34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Simpan");
        jButton34.setBorder(null);
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton35.setBackground(new java.awt.Color(255, 255, 255));
        jButton35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton35.setForeground(new java.awt.Color(51, 51, 51));
        jButton35.setText("Baru");
        jButton35.setBorder(null);
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(146, 146, 146)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("NIS / Kode Anggota");

        jTextField15.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jButton36.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton36.setText("Cari");
        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel35.setText("NIS / Kode Anggota");

        jLabel66.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel66.setText("Nama");

        jLabel67.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel67.setText("Kelas");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel68.setText("<NIS/KA>");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel69.setText("<Nama>");

        jLabel70.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel70.setText("<Kelas>");

        jLabel71.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel71.setText("Maks. Pinjam");

        jLabel72.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel72.setText("Tanggungan");

        jLabel73.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel73.setText("<Maks. Pinjam>");

        jLabel74.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel74.setText("<Tanggungan>");

        jLabel75.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel75.setText("Jenis Anggota");

        jLabel76.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel76.setText("Durasi Pinjam");

        jLabel77.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel77.setText("<Jenis Anggota>");

        jLabel78.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel78.setText("<Durasi Pinjam>");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel68)
                        .addGap(136, 136, 136))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67))
                        .addGap(125, 125, 125)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel74))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel73)))
                .addGap(96, 96, 96)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel76)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel75)))
                .addGap(66, 66, 66)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel76))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel78))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel68)
                            .addComponent(jLabel71)
                            .addComponent(jLabel73))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel72)
                                .addComponent(jLabel74))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel66))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel67))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(71, 71, 71)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PeminjamanUmumPanelLayout = new javax.swing.GroupLayout(PeminjamanUmumPanel);
        PeminjamanUmumPanel.setLayout(PeminjamanUmumPanelLayout);
        PeminjamanUmumPanelLayout.setHorizontalGroup(
            PeminjamanUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanUmumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PeminjamanUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePeminjamanUmum)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PeminjamanUmumPanelLayout.setVerticalGroup(
            PeminjamanUmumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanUmumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePeminjamanUmum)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBawah.add(PeminjamanUmumPanel, "card15");

        siswaPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleSiswa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleSiswa.setForeground(new java.awt.Color(51, 51, 51));
        titleSiswa.setText("Title");

        angkatanSiswaCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        angkatanSiswaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Angkatan");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton22.setBackground(new java.awt.Color(51, 153, 255));
        jButton22.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Cari");
        jButton22.setBorder(null);
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
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
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(siswaPanelLayout.createSequentialGroup()
                                        .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editsiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapussiswaB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        panelBawah.add(siswaPanel, "card3");

        getContentPane().add(panelBawah, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        jMenu11.setForeground(new java.awt.Color(51, 51, 51));
        jMenu11.setText("Menu");
        jMenu11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu11);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buku.png"))); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        BukuMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buku-active.png"))); // NOI18N
        BukuMB.setText("Buku");
        BukuMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BukuMBActionPerformed(evt);
            }
        });
        jMenu3.add(BukuMB);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/siswa.png"))); // NOI18N
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        SiswaMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/siswa-active.png"))); // NOI18N
        SiswaMB.setText("Siswa");
        SiswaMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiswaMBActionPerformed(evt);
            }
        });
        jMenu4.add(SiswaMB);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff.png"))); // NOI18N
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        StaffMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/staff-active.png"))); // NOI18N
        StaffMB.setText("Staff");
        StaffMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaffMBActionPerformed(evt);
            }
        });
        jMenu5.add(StaffMB);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/password.png"))); // NOI18N

        PasswordMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/password-active.png"))); // NOI18N
        PasswordMB.setText("Password");
        jMenu6.add(PasswordMB);

        jMenuBar1.add(jMenu6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/setting.png"))); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        SettingMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/setting-active.png"))); // NOI18N
        SettingMB.setText("Pengaturan");
        SettingMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingMBActionPerformed(evt);
            }
        });
        jMenu1.add(SettingMB);

        jMenuBar1.add(jMenu1);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/peminjaman.png"))); // NOI18N
        jMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu7ActionPerformed(evt);
            }
        });

        peminjBUmumMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/peminjaman.png"))); // NOI18N
        peminjBUmumMB.setText("Peminjaman Buku Umum");
        peminjBUmumMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjBUmumMBActionPerformed(evt);
            }
        });
        jMenu7.add(peminjBUmumMB);

        PeminjBMapelMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/peminjaman-active.png"))); // NOI18N
        PeminjBMapelMB.setText("Peminjaman Buku Mapel");
        PeminjBMapelMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeminjBMapelMBActionPerformed(evt);
            }
        });
        jMenu7.add(PeminjBMapelMB);

        jMenuBar1.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/pengembalian.png"))); // NOI18N
        jMenu8.setToolTipText("");
        jMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu8ActionPerformed(evt);
            }
        });

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/pengembalian.png"))); // NOI18N
        jMenuItem3.setText("Pengembalian Buku Umum");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/pengembalian-active.png"))); // NOI18N
        jMenuItem9.setText("Pengembalian Buku Mapel");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem9);

        jMenuBar1.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/datapinjam.png"))); // NOI18N
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/datapinjam-active.png"))); // NOI18N
        jMenuItem10.setText("Data Pinjam");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenuBar1.add(jMenu9);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/kas.png"))); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/kas-active.png"))); // NOI18N
        jMenuItem11.setText("Kas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/laporan.png"))); // NOI18N
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/laporan-active.png"))); // NOI18N
        jMenuItem12.setText("Laporan");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

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

    private void tambahguruBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahguruBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahguruBActionPerformed

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

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void hapusbukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbukuBActionPerformed
        // TODO add your handling code here:
        crud n = new crud();
        int column = 0;
        int row = bukuTabel.getSelectedRow();
        String value = bukuTabel.getModel().getValueAt(row, column).toString();
        n.deleteBuku(value);
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
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
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
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }    
            else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
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
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
                if(!nama.equals(""))
                    tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            }
            else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!Kategori.equals("Kategori"))
                    tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }
        }
            
    }//GEN-LAST:event_rakCBItemStateChanged

    private void ResetBukuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBukuBActionPerformed
        // TODO add your handling code here:
        rakCB.setSelectedIndex(0);
        JenisCB.setSelectedIndex(0);
        thnCB.setSelectedIndex(0);
        cariTF.setText("");
        bukuTabel.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(""));
    }//GEN-LAST:event_ResetBukuBActionPerformed

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
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }else if(Kategori.equals("Kategori")){
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(""));
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }
        }else
            tr.setRowFilter(RowFilter.regexFilter("^(?i)"+nama));
            if(jenis.equals("Jenis")){
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }else if(Kategori.equals("Kategori")){
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
            }else{
                tr.setRowFilter(RowFilter.regexFilter(jenis));
                tr.setRowFilter(RowFilter.regexFilter(Kategori));
                if(!lokasi.equals("Rak"))
                   tr.setRowFilter(RowFilter.regexFilter(lokasi));
                if(!tahun.equals("Tahun Buku"))
                    tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
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
            tr.setRowFilter(RowFilter.regexFilter("^"+tahun));
    }//GEN-LAST:event_thnCBItemStateChanged

    private void jMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu7ActionPerformed
        // TODO add your handling code here:
        this.titlePeminjamanMapel.setText("Peminjaman");
        panelBawah.removeAll();
        panelBawah.add(PeminjamanMapelPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu7ActionPerformed

    private void jMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu8ActionPerformed
        // TODO add your handling code here:
        this.titlePengembalianMapel.setText("Pengembalian");
        panelBawah.removeAll();
        panelBawah.add(PengembalianMapelPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu8ActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
        // TODO add your handling code here:
        this.titleLaporan.setText("Laporan");
        panelBawah.removeAll();
        panelBawah.add(laporanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        this.titleKas.setText("Kas");
        panelBawah.removeAll();
        panelBawah.add(kasPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        // TODO add your handling code here:
        this.titleDatapinjam.setText("Data Pinjam");
        panelBawah.removeAll();
        panelBawah.add(datapinjamPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        this.titlePengaturan.setText("Pengaturan");
        panelBawah.removeAll();
        panelBawah.add(pengaturanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
        this.titleStaff.setText("Staff");
        panelBawah.removeAll();
        panelBawah.add(staffPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        this.titleSiswa.setText("Siswa");
        panelBawah.removeAll();
        panelBawah.add(siswaPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
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
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void BukuMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BukuMBActionPerformed
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
    }//GEN-LAST:event_BukuMBActionPerformed

    private void SiswaMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiswaMBActionPerformed
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
         this.titleSiswa.setText("Siswa");
        panelBawah.removeAll();
        panelBawah.add(siswaPanel);
        siswaTabel.setModel(model_siswa);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_SiswaMBActionPerformed

    private void StaffMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaffMBActionPerformed
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
        
    }//GEN-LAST:event_StaffMBActionPerformed

    private void SettingMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingMBActionPerformed
        // TODO add your handling code here:
        this.titlePengaturan.setText("Pengaturan");
        panelBawah.removeAll();
        panelBawah.add(pengaturanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
        //tes komentar
        //tes komentar
    }//GEN-LAST:event_SettingMBActionPerformed

    private void peminjBUmumMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjBUmumMBActionPerformed
        // TODO add your handling code here:
        this.titlePeminjamanUmum.setText("Peminjaman Buku Umum ");
        panelBawah.removeAll();
        panelBawah.add(PeminjamanUmumPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_peminjBUmumMBActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        this.titleDatapinjam.setText("Data Pinjam");
        panelBawah.removeAll();
        panelBawah.add(datapinjamPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
         this.titleKas.setText("Kas");
        panelBawah.removeAll();
        panelBawah.add(kasPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        this.titleLaporan.setText("Laporan");
        panelBawah.removeAll();
        panelBawah.add(laporanPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.titlePengembalianUmum.setText("Pengembalian Buku Umum");
        panelBawah.removeAll();
        panelBawah.add(PengembalianUmumPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void PeminjBMapelMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeminjBMapelMBActionPerformed
        // TODO add your handling code here:
        this.titlePeminjamanMapel.setText("Peminjaman Buku Mapel ");
        panelBawah.removeAll();
        panelBawah.add(PeminjamanMapelPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_PeminjBMapelMBActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.titlePengembalianMapel.setText("Pengembalian Buku Mapel");
        panelBawah.removeAll();
        panelBawah.add(PengembalianMapelPanel);
        panelBawah.repaint();
        panelBawah.revalidate();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
    private javax.swing.JMenuItem BukuMB;
    private javax.swing.JComboBox<String> JenisCB;
    private javax.swing.JComboBox<String> KategoriCB;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JMenuItem PasswordMB;
    private javax.swing.JMenuItem PeminjBMapelMB;
    private javax.swing.JPanel PeminjamanMapelPanel;
    private javax.swing.JPanel PeminjamanUmumPanel;
    private javax.swing.JPanel PengembalianMapelPanel;
    private javax.swing.JPanel PengembalianUmumPanel;
    private javax.swing.JButton ResetBukuB;
    private javax.swing.JMenuItem SettingMB;
    private javax.swing.JMenuItem SiswaMB;
    private javax.swing.JMenuItem StaffMB;
    private javax.swing.JComboBox<String> angkatanSiswaCB;
    private javax.swing.JPanel backofficePanel;
    private javax.swing.JButton backupdbB;
    private javax.swing.JPanel bukuPanel;
    private javax.swing.JTable bukuTabel;
    private javax.swing.JButton cariBukuB;
    private javax.swing.JTextField cariTF;
    private javax.swing.JTextField cariguruTF;
    private javax.swing.JButton caristaffB;
    private javax.swing.JPanel datapinjamPanel;
    private javax.swing.JButton editbukuB;
    private javax.swing.JButton editguruB;
    private javax.swing.JButton editsiswaB;
    private javax.swing.JButton editstaffB;
    private javax.swing.JButton ekspordataBuku;
    private javax.swing.JButton ekspordataBuku1;
    private javax.swing.JButton ekspordataBuku2;
    private javax.swing.JButton ekspordataBuku3;
    private javax.swing.JButton ekspordataBuku4;
    private javax.swing.JButton ekspordataBuku5;
    private javax.swing.JPanel guruPanel;
    private javax.swing.JButton hapusbukuB;
    private javax.swing.JButton hapusguruB;
    private javax.swing.JButton hapussiswaB;
    private javax.swing.JButton hapusstaffB;
    private javax.swing.JButton impordataBuku;
    private javax.swing.JButton impordataGuru;
    private javax.swing.JButton impordataSiswa;
    private javax.swing.JButton impordataStaff;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel kasPanel;
    private javax.swing.JLabel kategoriL;
    private javax.swing.JLabel kodeanggota;
    private javax.swing.JLabel kodeanggota1;
    private javax.swing.JPanel laporanPanel;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama1;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JMenuItem peminjBUmumMB;
    private javax.swing.JLabel penerbitL1;
    private javax.swing.JLabel penerbitL2;
    private javax.swing.JPanel pengaturanPanel;
    private javax.swing.JComboBox<String> rakCB;
    private javax.swing.JLabel rakL;
    private javax.swing.JLabel rakL2;
    private javax.swing.JPanel siswaPanel;
    private javax.swing.JTable siswaTabel;
    private javax.swing.JTextField staffField;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JTable staffTabel;
    private javax.swing.JLabel sumberL;
    private javax.swing.JButton tambahbukuB;
    private javax.swing.JButton tambahguruB;
    private javax.swing.JButton tambahsiswaB;
    private javax.swing.JButton tambahstaffB;
    private javax.swing.JComboBox<String> thnCB;
    private javax.swing.JLabel titleBackoffice;
    private javax.swing.JLabel titleBuku;
    private javax.swing.JLabel titleDatapinjam;
    private javax.swing.JLabel titleGuru;
    private javax.swing.JLabel titleKas;
    private javax.swing.JLabel titleLaporan;
    private javax.swing.JLabel titlePeminjamanMapel;
    private javax.swing.JLabel titlePeminjamanUmum;
    private javax.swing.JLabel titlePengaturan;
    private javax.swing.JLabel titlePengembalianMapel;
    private javax.swing.JLabel titlePengembalianUmum;
    private javax.swing.JLabel titleSiswa;
    private javax.swing.JLabel titleStaff;
    // End of variables declaration//GEN-END:variables
}
