package CaseMethod2;

public class QueueTransaksi {

    TransaksiLayanan[] data;
    int front, rear, size, max;

    
    public QueueTransaksi(int max) {
        this.max = max;
        data = new TransaksiLayanan[max];
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void tambahRiwayat(TransaksiLayanan t) {
        if(isFull()) {
            System.out.println(">> Riwayat transaksi penuh");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = t;
        size++;     
    }

    public void hapusRiwayat() {
        if(isEmpty()) {
            System.out.println(">> Riwayat Transaksi Kosong");
            return;
        }

        TransaksiLayanan t = data[front];
        size--;
        front = (front + 1) % max;

        System.out.println(">> Data yang terhapus adalah: \n");
        System.out.println("Pasien      : " + t.pasien.nama);
        System.out.println("Dokter      : " + t.dokter.nama);
        System.out.println("ID Dokter   : " + t.dokter.idDokter);
        System.out.println("Durasi      : " + t.durasiLayanan + " jam");
        System.out.println("Biaya       : Rp " + t.hitungBiaya());
    }

    public void tampilkanRiwayat() {
        if(isEmpty()) {
            System.out.println("Tidak Ada Transaksi");
            return;
        }

        int index = front;
        for (int i = 0; i < size; i++) {
            TransaksiLayanan t = data[index];
            System.out.println("Pasien      : " + t.pasien.nama);
            System.out.println("Dokter      : " + t.dokter.nama);
            System.out.println("ID Dokter   : " + t.dokter.idDokter);
            System.out.println("Durasi      : " + t.durasiLayanan + " jam");
            System.out.println("Biaya       : Rp " + t.hitungBiaya());
            System.out.println("--------------------------");
            index = (index + 1) % max;
        }
    }

    public void hapusSeluruhRiwayat() {
        if(isEmpty()) {
            System.out.println(">> Riwayat Transaksi Kosong");
            return;
        }

        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        
        front = rear = -1;
        size = 0;

        System.out.println(">> Riwayat Berhasil Dikosongkan");
    }
}
