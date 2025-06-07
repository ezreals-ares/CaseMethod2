package CaseMethod2;

import java.util.Scanner;

public class InputEntity {
    static Scanner sc = new Scanner(System.in);

    public static Pasien inputPasien() {
        System.out.print("Nama Pasien   : ");
        String nama = sc.nextLine();
        System.out.print("NIK           : ");
        String nik = sc.nextLine();
        System.out.print("Keluhan       : ");
        String keluhan = sc.nextLine();
        return new Pasien(nama, nik, keluhan);
    }

    public static Dokter inputDokter() {
        System.out.print("ID Dokter     : ");
        String id = sc.nextLine();
        System.out.print("Nama Dokter   : ");
        String namaDok = sc.nextLine();
        return new Dokter(id, namaDok);
    }
}
