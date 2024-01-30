package View.Buku;

import Controller.ControllerBuku;
import View.view;

import java.util.Scanner;

public class UpdateBuku implements view {
    private Scanner scan;
    private ControllerBuku buku;

    public UpdateBuku() {
        buku = new ControllerBuku();
        scan = new Scanner(System.in);
    }

    public String kode_buku;
    public String judul_buku;
    public String pengarang;
    public int tahun_terbit;
    public int stok;

    @Override
    public void view() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|            UPDATE BUKU            |");
        System.out.println("=====================================");
        System.out.print("Kode buku yang ingin di update : ");
        kode_buku = scan.nextLine();
        System.out.print("Masukkan judul buku     : ");
        judul_buku = scan.nextLine();
        System.out.print("Masukkan Nama Pengarang : ");
        pengarang = scan.nextLine();
        System.out.print("Masukkan tahun terbit   : ");
        tahun_terbit = scan.nextInt();
        System.out.print("Masukkan jumlah stok    : ");
        stok = scan.nextInt();
        cekStok(buku.updateBuku(kode_buku, judul_buku, pengarang, tahun_terbit, stok));
    }

    private void cekStok(boolean statusStok) {
        if (statusStok) {
            System.out.println("\n\tBuku berhasil di update");
        } else {
            System.out.println("\n\tKode buku idak valid");
        }
    }
}

