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
    
    crud(){
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
    
    public void create(String isbn, String judul, String penerbit, int tahun, String tgl_pengadaan, String pengarang, String lok_rak, String lok_tingkat){
        Statement stmt=kon.query();
        String a[];
        try {  
            rs=stmt.executeUpdate("insert into library.book(isbn, judul, penerbit, tahun, tgl_pengadaan, pengarang, lok_rak, lok_tingkat) VALUE('" + isbn + "',' " +  judul + "',' " +  penerbit + "',' " + tahun + "',' " +  tgl_pengadaan + "',' " + pengarang + "',' " + lok_rak + "',' " +  lok_tingkat +"')");
        } catch (SQLException ex) {
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
