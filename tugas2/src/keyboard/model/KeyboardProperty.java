/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * 
 */
public class KeyboardProperty {
     private StringProperty id;
    private StringProperty nama;
    private StringProperty tanggalBeli;
    private StringProperty merk;
    private StringProperty pembayaran;

    public KeyboardProperty(String id, String nama, String tanggalBeli, String merk, String pembayaran) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalBeli = new SimpleStringProperty(tanggalBeli);
        this.merk = new SimpleStringProperty(merk);
        this.pembayaran = new SimpleStringProperty(pembayaran);
    }
    public KeyboardProperty(Keyboard key){
        this.id = new SimpleStringProperty(key.getId());
        this.nama = new SimpleStringProperty(key.getNama());
        this.tanggalBeli = new SimpleStringProperty(key.getTanggalBeli());
        this.merk = new SimpleStringProperty(key.getMerk());
        this.pembayaran = new SimpleStringProperty(key.getPembayaran());
    }

    public StringProperty getPembayaranProperty() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = new SimpleStringProperty(pembayaran);
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalBeliProperty() {
        return tanggalBeli;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = new SimpleStringProperty(tanggalBeli);
    }

    public StringProperty getMerkProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty(merk);
    }

    public String getId() {
        return id.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalBeli() {
        return tanggalBeli.get();
    }

    public String getMerk() {
        return merk.get();
    }

    public String getPembayaran() {
        return pembayaran.get();
    }
  
    
}
