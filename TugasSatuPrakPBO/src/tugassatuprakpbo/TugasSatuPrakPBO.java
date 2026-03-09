/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugassatuprakpbo;

/**
 *
 * @author ACER
 */

import java.util.Scanner;
public class TugasSatuPrakPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Tiket[] daftarTiket = new Tiket[100];
        int jumlahTiket = 0;
        
        while (jumlahTiket < 100) {
        try {
            System.out.println("\n--- Input Tiket Ke-" + (jumlahTiket + 1) + " ---");
            System.out.print("Kode Tiket (awali dengan 'TIX')   : "); 
            String kodeTiket = input.nextLine();
            
            System.out.print("Tanggal (DD/MM/YY)                : ");
            String tanggal = input.nextLine();
            
            System.out.print("Waktu                             : ");
            String waktu = input.nextLine();
            
            System.out.print("Stasiun Tujuan                    : ");
            String stasiunTujuan = input.nextLine();
            
            System.out.print("Harga Dasar                       : ");
            double hargaDasar = input.nextDouble();
            
            System.out.print("Jenis Tiket (1.ekono/2.eks/3.lux) : ");
            int jenis = input.nextInt();
            
            Jadwal jadwal = new Jadwal(tanggal, waktu, stasiunTujuan);
            Tiket tiketBaru = null;
            
            if (jenis == 1) {
                tiketBaru = new TiketEkonomi(kodeTiket, jadwal, hargaDasar);
            }
            else if (jenis == 2) {
                tiketBaru = new TiketEksekutif(kodeTiket, jadwal, hargaDasar);
            }
            else if (jenis == 3) {
                tiketBaru = new TiketLuxury(kodeTiket, jadwal, hargaDasar);
            } else {
                System.out.println("Jenis tiket tidak tersedia");
            }
            
            if (tiketBaru != null) {
                daftarTiket[jumlahTiket] = tiketBaru;
                jumlahTiket++;
            }
            
        } catch (DataTiketInvalidException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Data tiket dibatalkan.");
            
        } catch (Exception e) {
            System.out.println("Input Tidak Valid");
            input.nextLine();
        }
            System.out.print("\nCetak tiket lain? (y/n): ");
            input.nextLine();
            String pilihan = input.nextLine();
            if (pilihan.equalsIgnoreCase("n")) {
                break;
            }
        }
        
        System.out.println("\n\n---- Rekapitulasi tiket kereta ----");
        for(int i = 0; i < jumlahTiket; i++) {
            Tiket t = daftarTiket[i];
            System.out.println("Kode Booking    : " + t.getKodeTiket());
            System.out.println("Jadwal          : " + t.getJadwal().getInformasiJadwal());
            System.out.println("Total Harga     : Rp " + t.hargaDasar);
            
            if (t instanceof LayananEkslusif) {
                LayananEkslusif le = (LayananEkslusif) t;
                System.out.println("Fasilitas       : " + le.getFasilitasTambahan());
            }
            System.out.println("-----------------------------------");
        }
    }
    
}
