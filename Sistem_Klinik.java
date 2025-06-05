package CaseMethod2;
import java.util.Scanner;
public class Sistem_Klinik {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AntrianPasien antrian = new AntrianPasien();
        QueueTransaksi riwayat = new QueueTransaksi(100);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Hapus Riwayat Transaksi Terdepan");
            System.out.println("7. Hapus Seluruh Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (pilihan) {
                case 1 -> {
                    antrian.tambahAntrian(inputPasien());
                    System.out.println(">> Pasien masuk ke dalam antrian");
                }
                case 2 -> {
                    System.out.println(">> Daftar Antrian Pasien\n");
                    antrian.tampilkanAntrian();
                }
                case 3 -> {
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong");
                        break;
                    }
                    Pasien p = antrian.layaniPasien();
                    System.out.println("Pasien " + p.nama + " dipanggil");

                    Dokter d = inputDokter();
                    int durasi;

                    while(true) {  
                        System.out.print("Durasi layanan (jam): ");
                        durasi = sc.nextInt();
                        sc.nextLine();
                        if (durasi <= 0) {
                            System.out.println("Durasi yang anda masukkan salah, masukkan ulang");
                        } else {
                            break;
                        }
                    }
                    
                    TransaksiLayanan t = new TransaksiLayanan(p, d, durasi);
                    riwayat.tambahRiwayat(t);
                    System.out.println(">> Pasien telah dilayani dan transaksi dicatat");
                }
                case 4 -> {
                    int sisa = antrian.hitungSisaAntrian();
                    System.out.println(">> Sisa pasien dalam antrian: " + sisa);
                }
                case 5 -> {
                    System.out.println(">> Riwayat Transaksi Layanan: ");
                    riwayat.tampilkanRiwayat();
                }
                case 6 -> {
                    TransaksiLayanan t = riwayat.hapusRiwayat();
                    System.out.println(">> Data yang terhapus adalah: ");
                    System.out.println("Pasien: " + t.pasien.nama);
                    System.out.println("Dokter: " + t.dokter.nama + " (ID: " + t.dokter.idDokter + ")");
                    System.out.println("Durasi: " + t.durasiLayanan + " jam");
                    System.out.println("Biaya: Rp " + t.hitungBiaya());

                }

                case 7 -> riwayat.hapusSeluruhRiwayat();
                case 0 -> System.out.println("Keluar dari sistem");
                default -> System.out.println("Pilihan tidak valid");
            }
            
        } while (pilihan != 0);
    }

    static Pasien inputPasien() {
        System.out.print("Nama Pasien: ");
        String nama = sc.nextLine();
        System.out.print("NIK: ");
        String nik = sc.nextLine();
        System.out.print("Keluhan: ");
        String keluhan = sc.nextLine();
        return new Pasien(nama, nik, keluhan);
    }

    static Dokter inputDokter() {
        System.out.print("ID Dokter: ");
        String id = sc.nextLine();
        System.out.print("Nama Dokter: ");
        String namaDok = sc.nextLine();
        return new Dokter(id, namaDok);
    }
}