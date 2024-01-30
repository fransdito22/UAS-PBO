package View.Peminjaman;

import Controller.ControllerBuku;
import Controller.ControllerPeminjaman;
import View.view;

import java.util.Scanner;

public class PengembalianBuku implements view {
    private Scanner scan;
    private ControllerPeminjaman Peminjam;

    public PengembalianBuku() {
        this.scan = new Scanner(System.in);
        this.Peminjam = new ControllerPeminjaman();
    }

    @Override
    public void view() {
        String namaAnggota,judulBuku;
        System.out.println("=====================================");
        System.out.println("|       PENGAMBALIAN BUKU           |");
        System.out.println("=====================================");
//        menampilkan data peminjam
        new TampilkanPeminjaman().view();
        System.out.print("ID Anggota : ");
        namaAnggota = scan.nextLine();
        System.out.print("Judul Buku : ");
        judulBuku = scan.nextLine();
        cekStok(Peminjam.pengembalianBuku(namaAnggota,judulBuku));
    }
    private void cekStok(boolean statusStok) {
        if (statusStok) {
            System.out.println("\n\tBuku berhasil dikembalikan");
        } else {
            System.out.println("\n\tNama atau judul buku tidak valid");
        }
    }
}

