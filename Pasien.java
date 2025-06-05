package Praktikum_ASD.CM2;
public class Pasien {

    String nama, nik, keluhan;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    void tampilInformasi() {
        System.out.println("Nama Pasien: " + nama);
        System.out.println("NIK: " + nik);
        System.out.println("Keluhan: " + keluhan);
        System.out.println();
      
    }
    
}
