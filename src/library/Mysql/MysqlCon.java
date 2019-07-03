/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Mysql;

/**
 *
 * @author TippedLeader
 */
import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MysqlCon{  
    
    public MysqlCon( ){
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost","root","");  
        }catch(Exception e){ System.out.println(e);}  
    }
    
    public Connection koneksi(){
        Connection khusus = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            khusus = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus", "root", "");
            return khusus;
        }
        catch (SQLException ex) {
            return null;            
        } catch (ClassNotFoundException ex){
            return null;
        }
    }
    
    public Statement query() {
        
        Connection con;
        Statement stmt = null;
        try {  
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost","root","");
            stmt =con.createStatement();  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung");
        }
        return stmt;
    }
    
    public int login(String F1, String F2) throws ClassNotFoundException, SQLException{
        int num = 0;
//    try{  
//        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost","root","");  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select perpus.login('" + F1 + "', '" + F2 + "')");  
        
        while(rs.next())
            num = rs.getInt(1);
//        JOptionPane.showMessageDialog(null, "TEST , " + F1 + " " + F2);
        return num;
//        }catch(Exception e){ System.out.println(e);}  
//            return num;

    }
    
public static void main(String args[]){  
    
        //here sonoo is database name, root is username and password  
//        Statement stmt=con.createStatement();  
//        ResultSet rs=stmt.executeQuery("select * from novel.users");  
//        while(rs.next())  
//            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//        con.close();  
        
    }  
}  
