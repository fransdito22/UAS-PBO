package View.dasboard;

import View.Buku.HapusBuku;
import View.Buku.TambahBuku;
import View.Buku.TampilkanBuku;
import View.Buku.UpdateBuku;
import View.view;

import java.util.Scanner;

public class MenuBuku implements view {
    Scanner scan = new Scanner(System.in);
    public void view(){
        int option;
        do {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("|             DATA BUKU             |");
            System.out.println("=====================================");
            System.out.println("1.TAMBAH BUKU\n2.TAMPILKAN BUKU\n3.UPDATE BUKU\n4.HAPUS BUKU\n5.KELUAR");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan pilihan : ");
            option = scan.nextInt();

            switch (option){
                case 1 -> (new TambahBuku()).view();
                case 2 -> (new TampilkanBuku()).view();
                case 3 -> {
                    new TampilkanBuku().view();
                    new UpdateBuku().view();
                }
                case 4 -> {
                    new TampilkanBuku().view();
                    new HapusBuku().view();
                }
                case 5 -> {}
                default -> System.out.println("\n\t\tMasukkan 1 - 5");
            }
        }while (option != 5);
    }
}
