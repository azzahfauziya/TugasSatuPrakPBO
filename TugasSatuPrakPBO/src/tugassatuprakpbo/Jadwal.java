/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatuprakpbo;

/**
 *
 * @author ACER
 */
public class Jadwal {
    private String tanggal;
    private String waktu;
    private String stasiunTujuan;
    
    public Jadwal(String tanggal, String waktu, String stasiunTujuan){
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.stasiunTujuan = stasiunTujuan;
    }
    
    public String getInformasiJadwal(){
        return this.tanggal + " | " + this.waktu;
    }
    
    public String stasiunTujuan(){
        return stasiunTujuan;
    }
}
