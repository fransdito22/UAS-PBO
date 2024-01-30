package View.dasboard;

import View.view;

import java.util.Scanner;

public class MainMenu implements view {
    Scanner scan = new Scanner(System.in);
    public void view(){
        int option;
        do {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("|         PROGRAM PERPUSTAKAAN      |");
            System.out.println("=====================================");
            System.out.println("1.KELOLA BUKU\n2.PEMINJAMAN BUKU\n3.KELUAR");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan pilihan : ");
            option = scan.nextInt();

            switch (option){
                case 1 -> (new MenuBuku()).view();
                case 2 -> (new MenuPeminjaman()).view();
                case 3 ->{
                    System.out.println("\n\t\tTerima kasih");
                    break;
                }
                default -> System.out.println("\n\t\tMasukkan 1 - 3");
            }
        }while (option != 3);
    }
}
