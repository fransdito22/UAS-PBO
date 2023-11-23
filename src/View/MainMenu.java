package View;

import java.util.Scanner;

public class MainMenu {
    public void pilihanMenu(){
        int pilihan;
        boolean exit = false;
        MenuBuku menuBuku = new MenuBuku();
        MenuPeminjaman menuPeminjaman = new MenuPeminjaman();
        Scanner scan = new Scanner(System.in);

        displayMenu();//menampilkan pilihan mainMenu.menu
        pilihan = scan.nextInt();
        while (!exit){
            switch (pilihan){
                case 1 :
                    menuPeminjaman.pilihanMenu();
                    break;
                case 2 :
                    menuBuku.pilihanMenu();
                    break;
                case 3 :
                    System.out.println("Terima kasih");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan Anda salah");
                    pilihanMenu();//jika pilihan salah kembali memasukkan pilihan
            }
        }
    }
    public  void displayMenu(){
        System.out.println("============================================");
        System.out.println("     PROGRAM PENGELOLAAN PERPUSTAKAAN       ");
        System.out.println("--------------------------------------------");
        System.out.println("Pilihan menu : \n1.Peminjaman \n2.Data buku \n3.Exit");
        System.out.println("============================================");
        System.out.print("Masukkan pilihan [1,2,3] : ");
    }
}

