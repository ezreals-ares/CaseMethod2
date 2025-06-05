package Praktikum_ASD.CM2;

public class QueueTransaksi {

    TransaksiLayanan[] data;
    int front, rear, size, max;

    
    public QueueTransaksi(int max) {
        this.max = max;
        data = new TransaksiLayanan[max];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(TransaksiLayanan t) {
        if(isFull()) {
            System.out.println(">> Riwayat transaksi penuh");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = t;
        size++;     
    }

    public TransaksiLayanan dequeue() {
        if(isEmpty()) {
            System.out.println(">> Riwayat transaksi kosong");
            return null;
        }
        TransaksiLayanan t = data[front];
        front = (front + 1) % max;
        size--;
        return t;
    }

    public void tampilkanRiwayat() {
        if(isEmpty()) {
            System.out.println(">> Belum ada transaksi");
            return;
        }

        int index = front;
        for (int i = 0; i < size; i++) {
            TransaksiLayanan t = data[index];
            System.out.println("Pasien: " + t.pasien.nama);
            System.out.println("Dokter: " + t.dokter.nama + " (ID: " + t.dokter.idDokter + ")");
            System.out.println("Durasi: " + t.durasiLayanan + " jam");
            System.out.println("Biaya: Rp " + t.hitungBiaya());
            System.out.println("--------------------------");
            index = (index + 1) % max;
        }
    }

    public void hapusSeluruhRiwayat() {
        if(isEmpty()) {
            System.out.println("Data masih kosong");
            return;
        }

        for (int i = 0; i < max; i++) {
            data[i] = null;
        }
        size = 0;

        System.out.println(">> Riwayat Berhasil Dikosongkan");

        
    }


}
