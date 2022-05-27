/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class DBHelper {

     public static final String USER = "root";
    public static final String DB = "kuis";
    public static final String MyConn = "jdbc:mysql://localhost/" + DB
            + "?user=" + USER ;
    public static final String SQConn = "jdbc:sqlite:D:\\SQLite\\Data\\DBKU.sqlite";

    public static Connection getConnection(String driver) {
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    //            Class.forName("com.mysql.cj.jdbc.Driver");
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQConn);
                    System.out.println("Koneksi Berhasil");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library blm ada");
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Koneksi Gagal");
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(MyConn);
                    System.out.println("Koneksi Berhasil");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library blm ada");
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Koneksi Gagal");
                }
            }
        }

        return conn;
    }
}
