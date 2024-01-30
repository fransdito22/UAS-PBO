package View.Peminjaman;

import Controller.ControllerBuku;
import Controller.ControllerPeminjaman;
import Node.NodeBuku;
import View.view;

import java.util.ArrayList;
import java.util.Scanner;


public class Peminjaman implements view {
    Scanner scan = new Scanner(System.in);
    ControllerPeminjaman peminjaman = new ControllerPeminjaman();
    String idAnggota, nama, noTelp, alamat, judulBuku;

    @Override
    public void view() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|         PEMINJAMAN BUKU           |");
        System.out.println("=====================================");

        System.out.print("Masukkan ID Anggota            :");
        idAnggota = scan.nextLine();
        System.out.print("Masukkan Nama Amggota          :");
        nama = scan.nextLine();
        System.out.print("Masukkan no.telp               :");
        noTelp = scan.nextLine();
        System.out.print("Masukkan Alamat Anggota        : ");
        alamat = scan.nextLine();
//      menampilkan daftar buku
        tampilkanDaftarBuku();
        System.out.print("Judul buku yang ingin dipinjam : ");
        judulBuku = scan.nextLine();
//        menampilkan buku yang dipinjam
        tampilkanBuku(judulBuku);

        peminjaman.tambahPeminjam(idAnggota, nama, noTelp, alamat, judulBuku);
    }

    private void tampilkanDaftarBuku() {
        ArrayList<NodeBuku> listBuku = new ControllerBuku().tampilkanBuku();
        for (NodeBuku buku : listBuku) {
            System.out.println("Kode buku       : " + buku.getKodeBuku());
            System.out.println("Judul buku      : " + buku.getJudulBuku());
            System.out.println("Pengarang       : " + buku.getPengarang());
            System.out.println("Tahun terbit    : " + buku.getTahunTerbit());
            System.out.println("Stok buku       : " + buku.getStok());
            System.out.println("------------------------------------");
        }
    }
    private void tampilkanBuku(String judul){
        NodeBuku buku = new ControllerBuku().tampilkanBukuByJudul(judul);
        if (buku != null) {
            System.out.println("Kode buku       : " + buku.getKodeBuku());
            System.out.println("Judul buku      : " + buku.getJudulBuku());
            System.out.println("Pengarang       : " + buku.getPengarang());
            System.out.println("Tahun terbit    : " + buku.getTahunTerbit());
            System.out.println("Stok buku       : " + buku.getStok());
            System.out.println("------------------------------------");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}
