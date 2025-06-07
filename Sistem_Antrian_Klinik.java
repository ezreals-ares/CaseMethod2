package CaseMethod2;
import java.util.Scanner;
public class Sistem_Antrian_Klinik {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    Pasien p = InputEntity.inputPasien();
                    antrian.tambahAntrian(p);
                    System.out.println("\n>> Pasien masuk ke dalam antrian");
                }
                case 2 -> {
                    System.out.println(">> Daftar Antrian Pasien:\n");
                    antrian.tampilkanAntrian();
                }
                case 3 -> {
                    if (antrian.isEmpty()) {
                        System.out.println(">> Antrian Kosong");
                        break;
                    }
                    Pasien p = antrian.layaniPasien();
                    System.out.println("Pasien " + p.nama + " Dipanggil");

                    Dokter d = InputEntity.inputDokter();
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
                    System.out.println("\n>> Pasien telah dilayani dan transaksi dicatat");
                }
                case 4 -> {
                    int sisa = antrian.hitungSisaAntrian();
                    if (sisa == 0) {
                        System.out.println(">> Tidak ada pasien dalam antrian");
                    } else {
                        System.out.println(">> Sisa pasien dalam antrian: " + sisa);
                    }
                }
                case 5 -> {
                    System.out.println(">> Riwayat Transaksi Layanan: \n");
                    riwayat.tampilkanRiwayat();
                }

                case 6 -> riwayat.hapusRiwayat();
                case 7 -> riwayat.hapusSeluruhRiwayat();
                case 0 -> System.out.println("Keluar dari sistem");
                default -> System.out.println("Pilihan tidak valid");
            }
            
        } while (pilihan != 0);
        sc.close();
    }
}