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
    
    public void create(String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
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
    
    public void deleteBook(String isbn){
        try {  
            rs=stmt.executeUpdate("DELETE from book where isbn = " + isbn);
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
    
    public void update(String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
        String a[];
        try {  
            rs=stmt.executeUpdate("update library.book set isbn = '" + isbn + "', judul =  ' " +  judul + "', penerbit = ' " +  penerbit + "', thn_buku = ' " + thn_buku + "', tgl_pengadaan = ' " +  tgl_pengadaan + "', pengarang = ' " + pengarang + "', lokasi = ' " + lokasi + "'");
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
    
    public void update2(String isbn, String judul, String penerbit, int thn_buku, String tgl_pengadaan, String pengarang, String lokasi){
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
}
