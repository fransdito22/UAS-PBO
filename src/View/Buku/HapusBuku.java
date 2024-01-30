package View.Buku;

import Controller.ControllerBuku;
import View.view;

import java.util.Scanner;

public class HapusBuku implements view {
    private Scanner scan;
    private ControllerBuku buku;

    public HapusBuku() {
        buku = new ControllerBuku();
        scan = new Scanner(System.in);
    }
    @Override
    public void view() {
    String kodeBuku;
        System.out.println("=====================================");
        System.out.println("|            HAPUS BUKU             |");
        System.out.println("=====================================");
        System.out.print("Kode buku yang ingin dihapus : ");
        kodeBuku = scan.nextLine();
        cekStok(buku.hapus(kodeBuku));
    }
    private void cekStok(boolean statusStok) {
        if (statusStok) {
            System.out.println("\n\tBuku berhasil di dihapus");
        } else {
            System.out.println("\n\tjudul buku tidak valid");
        }
    }
}
