package Praktikum_ASD.CM2;

public class NodePasien {

    Pasien data;
    NodePasien next, prev;

    public NodePasien(Pasien data) {
        this.data = data;
        this.next = null;
        this.prev = null;

    }
}
