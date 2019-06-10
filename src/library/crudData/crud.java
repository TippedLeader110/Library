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
    
    public void createBuku(String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
        Statement stmt=kon.query();
        String a[];
        try {  
            rs=stmt.executeUpdate("insert into library.book(isbn, judul, penerbit, thn_buku, tgl_pengadaan, pengarang, lokasi) VALUE('" + isbn + "',' " +  judul + "',' " +  penerbit + "',' " + thn_buku + "',' " +  tgl_pengadaan + "',' " + pengarang + "',' " + lokasi + "')");
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
    
    public void deleteBuku(String isbn){
        try {  
            rs=stmt.executeUpdate("DELETE from library.book where isbn = " + isbn);
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
    
    public void updateBuku(String val, String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
        String a[];
        try {  
            rs=stmt.executeUpdate("update library.book set isbn = '" + isbn + "', judul =  ' " +  judul + "', penerbit = ' " +  penerbit + "', thn_buku = ' " + thn_buku + "', tgl_pengadaan = ' " +  tgl_pengadaan + "', pengarang = ' " + pengarang + "', lokasi = ' " + lokasi + "' where isbn = "+ val);
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
    
    public void updateBuku2(String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
        Statement stmt=kon.query();
        String a[];
        try {  
            rs=stmt.executeUpdate("update library.book set judul =  ' " +  judul + "', penerbit = ' " +  penerbit + "', thn_buku = ' " + thn_buku + "', tgl_pengadaan = ' " +  tgl_pengadaan + "', pengarang = ' " + pengarang + "', lokasi = ' " + lokasi + "' where isbn = " + isbn );
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
    
    public void createAnggota(String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
       try {  
            rs=stmt.executeUpdate("insert into library.anggota(id, nama, alamat, no_telp) VALUE('" + id + "',' " +  nama + "',' " +  alamat + "',' " + no_telp +"')");
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
    
    public void updateAnggota(String val, String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
         try {  
            rs=stmt.executeUpdate("update library.anggota set id = '" + id + "', nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "' where id = " + val);
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
        
    public void updateAnggota2(String id, String nama, String alamat, String no_telp){
        Statement stmt=kon.query();
       try {  
            rs=stmt.executeUpdate("update library.anggota set nama = ' " +  nama + "', alamat = ' " +  alamat + "', no_telp = ' " + no_telp +  "' where id = " + id);
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
    
     public void deleteAnggota(String id){
        try {  
            rs=stmt.executeUpdate("DELETE from library.anggota where id = " + id);
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
     
     public void createPinjam(String id, String isbn, String durasi){
         try {  
            rs=stmt.executeUpdate("insert into library.pinjam_book(id_anggota, ISBN, t_pinjam, t_deadline, t_kembali, denda) VALUE('" + id + "',' " +  isbn + "', CURDATE(), DATE_ADD(CURDATE(), INTERVAL " + durasi + " DAY), NULL, NULL)");
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
     
     public void createPinjam(String uang, String isbn){
         try{
             rs=stmt.executeUpdate("UPDATE pinjam_book SET t_kembali = CURDATE(), denda = denda("+ isbn +","+ uang +") WHERE isbn = " + isbn + "");
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
}
