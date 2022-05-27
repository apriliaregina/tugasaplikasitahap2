/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keyboard.model.Keyboard;
import keyboard.model.KeyboardProperty;

/**
 *
 * 
 */
public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addKeyboard(Keyboard key){
        String insertKey = "INSERT INTO `keyboard`(`id`, `nama`, `tgl_beli`,`merk`,`pembayaran`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertKey);
            stmtInsert.setString(1, key.getId());
            stmtInsert.setString(2, key.getNama());
            stmtInsert.setString(3, key.getTanggalBeli());
            stmtInsert.setString(4, key.getMerk());
            stmtInsert.setString(5, key.getPembayaran());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<KeyboardProperty> getKeyboard(){
        ObservableList<KeyboardProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT id, nama, tgl_beli, merk, pembayaran FROM `keyboard` ORDER BY id";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                KeyboardProperty key = new KeyboardProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void updateKeyboard(KeyboardProperty key){
        String updateTv = "UPDATE `keyboard` SET `keyboard`.`id` = ?, `keyboard`.`nama` = ?,`keyboard`.`tgl_beli` = ?,`keyboard`.`merk` = ?,`keyboard`.`pembayaran` = ?  WHERE `keyboard`.`id` = ?";
        try {
            PreparedStatement stmtUpdate = conn.prepareStatement(updateTv);
            stmtUpdate.setString(1, key.getId());
            stmtUpdate.setString(2, key.getNama());
            stmtUpdate.setString(3, key.getTanggalBeli());
            stmtUpdate.setString(4, key.getMerk());
            stmtUpdate.setString(5, key.getPembayaran());
            stmtUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteKeyboard(KeyboardProperty key){
        String deleteKey = "DELETE FROM keyboard WHERE `keyboard`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteKey);
            stmtDelete.setString(1, key.getId());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       
    }

