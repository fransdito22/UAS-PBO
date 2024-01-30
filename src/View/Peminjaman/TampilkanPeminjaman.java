package View.Peminjaman;

import Controller.ControllerBuku;
import Controller.ControllerPeminjaman;
import Node.NodeAnggota;
import View.view;

import java.util.ArrayList;

public class TampilkanPeminjaman implements view {
    ArrayList<NodeAnggota> peminjaman = new ControllerPeminjaman().tampilkanPeminjaman();

    @Override
    public void view() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|           DATA PEMINJAMAN          |");
        System.out.println("=====================================");
        if (peminjaman.isEmpty()) {
            System.out.println("\n\t\tData masih kosong");
        } else {
            for (NodeAnggota pinjaman : peminjaman) {
                System.out.println("Id Anggota     : " + pinjaman.getIdAnggota());
                System.out.println("Nama Anggota   : " + pinjaman.getNama());
                System.out.println("No telp        : " + pinjaman.getNoTelp());
                System.out.println("Alamat         : " + pinjaman.getAlamat());
                System.out.println("Kode buku      : " + pinjaman.getBuku().getKodeBuku());
                System.out.println("Judul buku     : " + pinjaman.getBuku().getJudulBuku());
                System.out.println("Pengarang      : " + pinjaman.getBuku().getPengarang());
                System.out.println("Tahun terbit   : " + pinjaman.getBuku().getTahunTerbit());
                System.out.println("------------------------------------");
            }
        }
    }
}
