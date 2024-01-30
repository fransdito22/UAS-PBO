package View.dasboard;

import View.Buku.HapusBuku;
import View.Buku.TambahBuku;
import View.Buku.TampilkanBuku;
import View.Buku.UpdateBuku;
import View.Peminjaman.Peminjaman;
import View.Peminjaman.PengembalianBuku;
import View.Peminjaman.TampilkanPeminjaman;
import View.view;

import java.util.Scanner;

public class MenuPeminjaman implements view {
    Scanner scan = new Scanner(System.in);
    public void view(){
        int option;
        do {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("|      MANAGEMENT PEMINJAMA         |");
            System.out.println("=====================================");
            System.out.println("1.PEMINJAMAN BUKU\n2.TAMPILKAN DATA PEMINJAM\n3.PEMGEMBALIAN BUKU\n4.KELUAR");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan pilihan : ");
            option = scan.nextInt();

            switch (option){
                case 1 -> (new Peminjaman()).view();
                case 2 -> (new TampilkanPeminjaman()).view();
                case 3 -> (new PengembalianBuku()).view();
                case 4 -> {
                    continue;
                }
                default -> System.out.println("\n\t\tMasukkan 1 - 5");
            }
        }while (option != 4);
    }
}
