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
public class editSiswa extends javax.swing.JFrame {

    /**
     * Creates new form editSiswa
     */
    MysqlCon kon = new MysqlCon();
    String val;
    public editSiswa(String val){
        this.val = val;
        initComponents();
        title.setText("Edit Siswa");
        Statement stmt=kon.query();
        
        try{
            ResultSet rs = stmt.executeQuery("Select distinct kelas.jurusan from perpus.kelas");
            while(rs.next()){
                String lokasi = rs.getString("jurusan");
                jurusanCB.addItem(lokasi); 
            }   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
        ResultSet rs = stmt.executeQuery("SELECT * FROM perpus.siswa_view where nis = " + val);
        while (rs.next()){
                JId.setText(rs.getString("nis"));
                JNama.setText(rs.getString("nama"));
                TingkatCB.setSelectedItem(rs.getString("tingkat"));
                jurusanCB.setSelectedItem(rs.getString("jurusan"));
                KelasCB.setSelectedItem(rs.getString("kelas"));
                JAlamat.setText(rs.getString("alamat"));
                JTelepon.setText(rs.getString("no_telp"));
            }
        
     }catch (SQLException ex) {
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
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        JId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        JNama = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JTelepon = new javax.swing.JTextField();
        JAlamat = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        TingkatCB = new javax.swing.JComboBox<>();
        jurusanCB = new javax.swing.JComboBox<>();
        KelasCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel16.setText("ID");

        JId.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel17.setText("Nama");

        JNama.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel18.setText("Tingkat");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel19.setText("No. Telpon");

        JTelepon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        JTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTeleponActionPerformed(evt);
            }
        });

        JAlamat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel20.setText("Jurusan");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel21.setText("Alamat");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel22.setText("Kelas");

        TingkatCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "Alumni" }));

        KelasCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JTelepon)
                        .addComponent(JNama)
                        .addComponent(JId)
                        .addComponent(JAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(jurusanCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TingkatCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(KelasCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(JId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TingkatCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jurusanCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(KelasCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(JTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(simpanB, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(batalB, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBActionPerformed
        crud c = new crud();
        String v =JId.getText();
        Statement stmt=kon.query();
        String tingkat = TingkatCB.getSelectedItem().toString();
        String jurusan = jurusanCB.getSelectedItem().toString();
        String kelas = KelasCB.getSelectedItem().toString();
        try{
                ResultSet rs2 = stmt.executeQuery("Select distinct kelas.id_kelas from perpus.kelas where kelas.tingkat = '"+tingkat+"' and kelas.jurusan = '"+jurusan+"' and kelas.kelas = '"+kelas);
                while(rs2.next()){
                    String id_kelas = rs2.getString("id_kelas");
                    if(v!=this.val){
                        c.updateSiswa(this.val, JId.getText(),JNama.getText(), id_kelas,JAlamat.getText(), JTelepon.getText());
                    }
                    else
                        c.updateSiswa2(this.val, JNama.getText(), id_kelas, JAlamat.getText(), JTelepon.getText());
                    }
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_simpanBActionPerformed

    private void batalBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_batalBActionPerformed

    private void JTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTeleponActionPerformed

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
            java.util.logging.Logger.getLogger(editSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JAlamat;
    private javax.swing.JTextField JId;
    private javax.swing.JTextField JNama;
    private javax.swing.JTextField JTelepon;
    private javax.swing.JComboBox<String> KelasCB;
    private javax.swing.JComboBox<String> TingkatCB;
    private javax.swing.JButton batalB;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jurusanCB;
    private javax.swing.JButton simpanB;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
