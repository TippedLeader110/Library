/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.crudData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import library.Mysql.MysqlCon;
/**
 *
 * @author TippedLeader
 */
public class crud extends library.Main.Main {
    MysqlCon kon = new MysqlCon( );
    int rs;
    Statement stmt=kon.query();
    public crud(){
        this.rs = 0;
    }
    
    /**
     *
     * @param isbn
     * @param judul
     * @param penerbit
     * @param tahun
     * @param tgl_pengadaan
     * @param pengarang
     * @param lok_rak
     * @param lok_tingkat
     * @return
     */
    
    public int createBuku(String isbn, String judul, String penerbit, String thn_buku, String pengarang, String lokasi, String jumlah, String jenis, String kategori){
        Statement stmt=kon.query();
        String a[];
        try {  
            rs=stmt.executeUpdate("insert into perpus.book(isbn, judul, penerbit, thn_buku, tgl_pengadaan, pengarang, id_rak, jmlh, jenis_buku, kategori) VALUE('" + isbn + "','" +  judul + "','" +  penerbit + "','" + thn_buku + "', CURDATE(), '" + pengarang + "','" + lokasi + "',"+ jumlah +",'"+jenis+"','"+kategori+"')");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
        //return a;
    }
    
    public void deleteBuku(String isbn){
        try {  
            rs=stmt.executeUpdate("DELETE from perpus.book where isbn = " + isbn);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateBuku(String val, String isbn, String judul, String penerbit, int thn_buku, String pengarang, String lokasi, String jumlah, String jenis, String kategori){
        String a[];
        try {  
            rs=stmt.executeUpdate("update perpus.book set isbn = '" + isbn + "', judul =  '" +  judul + "', penerbit = '" +  penerbit + "', thn_buku = '" + thn_buku + "', pengarang = '" + pengarang + "', lokasi = '" + lokasi + "', jmlh = '"+ jumlah +"', jenis_buku = '"+ jenis +"', kategori = '"+ kategori +"' where isbn = "+ val);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        //return a;
    }
    
    public void updateBuku2(String isbn, String judul, String penerbit, int thn_buku, String pengarang, String lokasi, String jumlah, String jenis, String kategori){
        Statement stmt=kon.query();
        String a[];
        try {  
            rs=stmt.executeUpdate("update perpus.book set judul =  '" +  judul + "', penerbit = '" +  penerbit + "', thn_buku = '" + thn_buku + "', pengarang = '" + pengarang + "', lokasi = '" + lokasi +"', jmlh = '"+ jumlah +"', jenis_buku = '"+ jenis +"', kategori = '"+kategori+"' where isbn = " + isbn );
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        //return a;
    }
    
    public void createSiswa(String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
       try {  
            rs=stmt.executeUpdate("insert into perpus.siswa(id, nama, alamat, no_telp) VALUE('" + id + "','" +  nama + "','" +  alamat + "','" + no_telp +"')");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateSiswa(String val, String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
         try {  
            rs=stmt.executeUpdate("update perpus.siswa set id = '" + id + "', nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "' where id = " + val);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void updateSiswa2(String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
       try {  
            rs=stmt.executeUpdate("update perpus.siswa set nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "' where id = " + id);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void deleteSiswa(String id){
        try {  
            rs=stmt.executeUpdate("DELETE from perpus.siswa where id = " + id);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void createStaff(String id, String nama, String alamat, String no_telp, String username, String password){
         try {  
            rs=stmt.executeUpdate("insert into library.users(id, nama, alamat, no_telp, username, password) VALUE('" + id + "',' " +  nama + "',' " +  alamat + "',' " + no_telp +  "', username = '" + username + "', password = '" + password +"')");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
     }
     
      public void updateStaff(String val, String id, String nama, String alamat, String no_telp, String username, String password){
        Statement stmt=kon.query();
         try {  
            rs=stmt.executeUpdate("update library.users set id = '" + id + "', nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "', username = '" + username + "', password = '" + password + "' where id = " + val);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void updateStaff2(String id, String nama, String alamat, String no_telp, String username, String password){
        Statement stmt=kon.query();
       try {  
            rs=stmt.executeUpdate("update library.users set nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "', username = '" + username + "', password = '" + password + "' where id = " + id);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void deleteStaff(String id){
        try {  
            rs=stmt.executeUpdate("DELETE from library.users where id = " + id);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Kesalahan", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public int createPinjam(String id, String petugas, String isbn, String durasi){
         try {  
            rs=stmt.executeUpdate("insert into library.pinjam_book(id_anggota, id_petugas, ISBN, t_pinjam, t_deadline, t_kembali, denda) VALUE('"+ id + "','" + petugas + "','" +  isbn + "', CURDATE(), DATE_ADD(CURDATE(), INTERVAL " + durasi + " DAY), NULL, NULL)");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
         return rs;
     }
     
     public void createKembali(String uang, String id_trans, String id){
         try{
             rs=stmt.executeUpdate("UPDATE library.pinjam_book SET t_kembali = CURDATE(), denda = library.denda(CURDATE(),"+id+","+id_trans+","+uang+") WHERE id_anggota = "+id+" and id_transaksi = "+id_trans);
         }catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Kesalahan : " + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        if(rs!=0){
            JOptionPane.showMessageDialog(this, "Sukses ", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, rs, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
     }
}
