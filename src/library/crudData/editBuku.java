/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.crudData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import library.Mysql.MysqlCon;

/**
 *
 * @author windows 10
 */
public class editBuku extends javax.swing.JFrame {

    /**
     * Creates new form editBuku
     */
    String val;
    MysqlCon kon = new MysqlCon();
    public editBuku(String val){
        initComponents();
        LokasiCB.setEnabled(true);
        Jrak.setEnabled(false);
        Jtingkat.setEnabled(false);
        KategoriCB.setEnabled(true);
        JNewKategori.setEnabled(false);
        this.val = val;
        title.setText("Edit Buku");
        Statement stmt=kon.query();
        //lokasi
        try{
            ResultSet rs3 = stmt.executeQuery("Select lok_book.id_rak from perpus.lok_book");
            while(rs3.next()){
                String lokasi = rs3.getString("id_rak");
                LokasiCB.addItem(lokasi); 
            }   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
        
        //combo box kategori
        try{
            ResultSet rs2 = stmt.executeQuery("Select book.kategori from perpus.book");
            while(rs2.next()){
                String kategori = rs2.getString("kategori");
                KategoriCB.addItem(kategori); 
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
            
        ResultSet rs = stmt.executeQuery("SELECT * FROM perpus.book where isbn = '"+val+"'");
        while (rs.next()){
                Jisbn.setText(rs.getString("ISBN"));
                Jjudul.setText(rs.getString("judul"));
                Jpenerbit.setText(rs.getString("penerbit"));
                Jthn.setText(rs.getString("thn_buku"));
                Jpengarang.setText(rs.getString("pengarang"));
                JJumlah.setText(rs.getString("jmlh"));
                LokasiCB.setSelectedItem(rs.getString("id_rak"));
                JenisCB.setSelectedItem(rs.getString("jenis_buku"));
                KategoriCB.setSelectedItem(rs.getString("kategori"));
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        simpanB = new javax.swing.JButton();
        batalB = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Jisbn = new javax.swing.JTextField();
        Jjudul = new javax.swing.JTextField();
        Jpenerbit = new javax.swing.JTextField();
        Jthn = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Jpengarang = new javax.swing.JTextField();
        Jrak = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        BuatBaru = new javax.swing.JButton();
        Jtingkat = new javax.swing.JTextField();
        LokasiCB = new javax.swing.JComboBox<>();
        Kategori20 = new javax.swing.JLabel();
        KategoriCB = new javax.swing.JComboBox<>();
        BuatBaru2 = new javax.swing.JButton();
        JJumlah = new javax.swing.JTextField();
        Kategori21 = new javax.swing.JLabel();
        JenisCB = new javax.swing.JComboBox<>();
        JNewKategori = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        title.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Tambah Buku");

        simpanB.setBackground(new java.awt.Color(0, 204, 0));
        simpanB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        simpanB.setForeground(new java.awt.Color(255, 255, 255));
        simpanB.setText("Simpan");
        simpanB.setBorder(null);
        simpanB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBActionPerformed(evt);
            }
        });

        batalB.setBackground(new java.awt.Color(255, 0, 0));
        batalB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        batalB.setForeground(new java.awt.Color(255, 255, 255));
        batalB.setText("Batal");
        batalB.setBorder(null);
        batalB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batalB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel.setText("ISBN");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel24.setText("Judul");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel25.setText("Penerbit");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel26.setText("Tahun Buku");

        Jisbn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Jisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JisbnActionPerformed(evt);
            }
        });

        Jjudul.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Jjudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JjudulActionPerformed(evt);
            }
        });

        Jpenerbit.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        Jthn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel27.setText("Pengarang");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel28.setText("Lokasi Buku");

        Jpengarang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        Jrak.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Jrak.setText("No Rak");
        Jrak.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JrakFocusGained(evt);
            }
        });
        Jrak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrakActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel29.setText("Jumlah");

        BuatBaru.setText("Buat baru");
        BuatBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuatBaruActionPerformed(evt);
            }
        });

        Jtingkat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Jtingkat.setText("No Tingkat");
        Jtingkat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JtingkatFocusGained(evt);
            }
        });
        Jtingkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtingkatActionPerformed(evt);
            }
        });

        LokasiCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LokasiCBActionPerformed(evt);
            }
        });

        Kategori20.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Kategori20.setText("Kategori");

        BuatBaru2.setText("Buat baru");
        BuatBaru2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuatBaru2ActionPerformed(evt);
            }
        });

        JJumlah.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        Kategori21.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Kategori21.setText("Jenis Buku");

        JenisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Umum", "Khusus", "Mapel" }));

        JNewKategori.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        JNewKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNewKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(Jthn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Jrak, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LokasiCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(KategoriCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JenisCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 61, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BuatBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Jtingkat)
                                            .addComponent(BuatBaru2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(JJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JNewKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Kategori21)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Kategori20)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(Jisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Jjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Jpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jthn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(Jpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(BuatBaru)
                    .addComponent(LokasiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jrak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kategori21)
                    .addComponent(JenisCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kategori20)
                    .addComponent(KategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuatBaru2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JNewKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(simpanB, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batalB, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBActionPerformed
        crud c = new crud();
        String v =Jisbn.getText();
        int thn = Integer.parseInt(Jthn.getText());
        String jenis = (JenisCB.getSelectedItem()).toString();
        
        //lokasi
        String lokasi;
        if((Jrak.getText()).equals("No Rak")){
            lokasi = (LokasiCB.getSelectedItem()).toString(); 
        }else
            lokasi = Jrak.getText()+""+Jtingkat.getText();
        
        //kategori
        String kategori;
        if((JNewKategori.getText()).equals("")){
            kategori = (KategoriCB.getSelectedItem()).toString();
        }else
            kategori = JNewKategori.getText();
        
        if(v!=this.val){
            c.updateBuku(this.val , Jisbn.getText(), Jjudul.getText(), Jpenerbit.getText(),thn , Jpengarang.getText(), lokasi, JJumlah.getText(), jenis, kategori);
        }
        else
        c.updateBuku2(Jisbn.getText() , Jjudul.getText(), Jpenerbit.getText(),thn , Jpengarang.getText(), lokasi, JJumlah.getText(), jenis, kategori);
        this.dispose();
    }//GEN-LAST:event_simpanBActionPerformed

    private void batalBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_batalBActionPerformed

    private void JisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JisbnActionPerformed

    private void JjudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JjudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JjudulActionPerformed

    private void JrakFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JrakFocusGained
        // TODO add your handling code here:
        Jrak.setText("");
    }//GEN-LAST:event_JrakFocusGained

    private void JrakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JrakActionPerformed

    private void BuatBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuatBaruActionPerformed
        // TODO add your handling code here:
        LokasiCB.setEnabled(false);
        Jrak.setEnabled(true);
        Jtingkat.setEnabled(true);
    }//GEN-LAST:event_BuatBaruActionPerformed

    private void JtingkatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JtingkatFocusGained
        // TODO add your handling code here:
        Jtingkat.setText("");
    }//GEN-LAST:event_JtingkatFocusGained

    private void JtingkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtingkatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtingkatActionPerformed

    private void BuatBaru2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuatBaru2ActionPerformed
        // TODO add your handling code here:
        KategoriCB.setEnabled(false);
        JNewKategori.setEnabled(true);
    }//GEN-LAST:event_BuatBaru2ActionPerformed

    private void JNewKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNewKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JNewKategoriActionPerformed

    private void LokasiCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LokasiCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LokasiCBActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(editBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuatBaru;
    private javax.swing.JButton BuatBaru2;
    private javax.swing.JTextField JJumlah;
    private javax.swing.JTextField JNewKategori;
    private javax.swing.JComboBox<String> JenisCB;
    private javax.swing.JTextField Jisbn;
    private javax.swing.JTextField Jjudul;
    private javax.swing.JTextField Jpenerbit;
    private javax.swing.JTextField Jpengarang;
    private javax.swing.JTextField Jrak;
    private javax.swing.JTextField Jthn;
    private javax.swing.JTextField Jtingkat;
    private javax.swing.JLabel Kategori20;
    private javax.swing.JLabel Kategori21;
    private javax.swing.JComboBox<String> KategoriCB;
    private javax.swing.JComboBox<String> LokasiCB;
    private javax.swing.JButton batalB;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton simpanB;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
