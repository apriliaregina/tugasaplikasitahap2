/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.model;

/**
 *
 * 
 */
public class Keyboard {
    private String id;
    private String nama;
    private String tanggalBeli;
    private String merk;
    private String pembayaran;

    public Keyboard(String id, String nama, String tanggalBeli, String merk, String pembayaran) {
        this.id = id;
        this.nama = nama;
        this.tanggalBeli = tanggalBeli;
        this.merk = merk;
        this.pembayaran = pembayaran;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
        
    }
        public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    
    }
}
