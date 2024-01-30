package View.Buku;

import Controller.ControllerBuku;
import Node.NodeBuku;
import View.view;

import java.util.ArrayList;

public class TampilkanBuku implements view {
    ArrayList<NodeBuku> listBuku = new ControllerBuku().tampilkanBuku();

    @Override
    public void view() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|       TAMPILKAN DATA BUKU          |");
        System.out.println("=====================================");
        if (listBuku.isEmpty()) {
            System.out.println("\n\t\tData masih kosong");
        } else {
            for (NodeBuku buku : listBuku) {
                System.out.println("Kode buku       : " + buku.getKodeBuku());
                System.out.println("Judul buku      : " +buku.getJudulBuku());
                System.out.println("Pengarang       : " + buku.getPengarang());
                System.out.println("Tahun terbit    : " + buku.getTahunTerbit());
                System.out.println("Stok buku       : " + buku.getStok());
                System.out.println("------------------------------------");
            }
        }
    }
}
