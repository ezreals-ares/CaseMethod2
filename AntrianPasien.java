package CaseMethod2;

public class AntrianPasien {

    NodePasien head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(Pasien p) {
        NodePasien newPasien = new NodePasien(p);
        if (isEmpty()) {
            head = tail = newPasien;
        } else {
            tail.next = newPasien;
            newPasien.prev = tail;
            tail = newPasien;
        }
    }
    
    public Pasien layaniPasien() {
        Pasien p = head.data;
        
        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return p;
    }
    
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian Kosong");
        } 

        NodePasien current = head;
        while(current != null) {
            current.data.tampilInformasi();
            current = current.next;
        }
    }

    public int hitungSisaAntrian() {
        int count = 0;
        NodePasien current = head;
        
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
