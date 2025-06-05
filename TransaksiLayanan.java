package Praktikum_ASD.CM2;

public class TransaksiLayanan {

    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = dokter;
        durasiLayanan = durasi;
        biaya = hitungBiaya();
    }

    public int hitungBiaya()  {
        return durasiLayanan * 50000;
    }

    public void tampilkanTransaksi() {
        System.out.println("Pasien: " + pasien.nama + ", Dokter: " + dokter.nama + ", Durasi: " + durasiLayanan + " jam, Biaya: Rp" + biaya);
    }
}
