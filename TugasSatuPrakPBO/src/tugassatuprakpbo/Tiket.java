/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatuprakpbo;

/**
 *
 * @author ACER
 */

abstract class Tiket {
    private String kodeTiket;
    private Jadwal jadwal;
    public double hargaDasar;
    
    public Tiket(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidException{
        if (hargaDasar <= 0) {
            throw new DataTiketInvalidException("Harga dasar harus lebih dari 0!");
        }
        if (!kodeTiket.startsWith("TIX")) {
            throw new DataTiketInvalidException("Kode tiket wajib diawali TIX");       
        }
        
        this.kodeTiket = kodeTiket;
        this.jadwal = jadwal;
        this.hargaDasar = hargaDasar;
    }
    
    public String getKodeTiket(){
       return kodeTiket; 
    }
    
    public Jadwal getJadwal() {
        return jadwal;
    }
    
    public abstract double hitungHarga();
}

class TiketEkonomi extends Tiket {
    public TiketEkonomi(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }

    @Override
    public double hitungHarga() {
        return hargaDasar; 
    }
}

class TiketLuxury extends Tiket implements LayananEkslusif {
    public TiketLuxury(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga() {
        return hargaDasar+ 150000; 
    }
    
    @Override
    public String getFasilitasTambahan(){
        return " Makan siang dan kursi sleeper";
    }
}

class TiketEksekutif extends Tiket implements LayananEkslusif {
    public TiketEksekutif(String kodeTiket, Jadwal jadwal, double hargaDasar) throws DataTiketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga() {
        return hargaDasar+ 50000; 
    }
    
    @Override
    public String getFasilitasTambahan(){
        return " Makan siang";
    }
}

