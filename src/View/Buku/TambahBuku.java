package View.Buku;

import Controller.ControllerBuku;
import View.view;

import java.util.Scanner;


public class TambahBuku implements view {
    Scanner scan = new Scanner(System.in);
    ControllerBuku buku = new ControllerBuku();
    public String kode_buku;
    public String judul_buku;
    public String pengarang;
    public int tahun_terbit;
    public int stok;
    @Override
    public void view(){
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|            TAMBAH BUKU            |");
        System.out.println("=====================================");
        System.out.print("Masukkan kode buku      : ");
        kode_buku = scan.nextLine();
        System.out.print("Masukkan judul buku     : ");
        judul_buku = scan.nextLine();
        System.out.print("Masukkan Nama Pengarang : ");
        pengarang = scan.nextLine();
        System.out.print("Masukkan tahun terbit   : ");
        tahun_terbit = scan.nextInt();
        System.out.print("Masukkan jumlah stok    : ");
        stok = scan.nextInt();
        System.out.println("\nBerhasil ditambahkan");
        buku.tambahBuku(kode_buku,judul_buku,pengarang,tahun_terbit,stok);
    }
}
