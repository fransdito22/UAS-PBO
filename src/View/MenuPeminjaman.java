package View;

import java.util.Scanner;
import  Controller.ControllerMember;

public class MenuPeminjaman {
    ControllerMember controllerMember = new ControllerMember();

    Scanner scan = new Scanner(System.in);

    public void pilihanMenu(){
        int pilihan;
        boolean exit = false;

        displayMenuPeminjam();
        System.out.print("Masukkan pilihan [1,2,3,] : ");
        pilihan = scan.nextInt();
        while (!exit){

            switch (pilihan){
                case 1 :
                    System.out.println("PEMINJAMAN BUKU");
                    tambahPeminjam();
                    break;
                case 2 :
                    System.out.println("TAMPOLKAN DATA PEMINJAM");
                    tampilkanPeminjam();
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
//method untuk menampilkan tampilan
    public void displayMenuPeminjam(){
        System.out.println("Masukkan pilihan: \n1.Peminjaman buku\n2.Tampilkan data peminjam\n3.Exit");
    }

    void tambahPeminjam(){
        String namaPeminjam ,tanggalPeminjaman,judul,option;

        System.out.print("Masukkan nama member        : ");
        scan.nextLine();
        namaPeminjam= scan.nextLine();
        System.out.print("Masukkan tanggal peminjaman : ");
        tanggalPeminjaman= scan.nextLine();
        System.out.print("masukkan judul buku         : ");
        judul = scan.nextLine();
        controllerMember.tambahPeminjam(namaPeminjam,tanggalPeminjaman,judul);
        //   opsi kembali
        System.out.print("kembali[y/n] :");
        option = scan.next();

        if (option.equalsIgnoreCase("y")) {
            pilihanMenu();
        } else {
            tambahPeminjam();
        }
    }
    void tampilkanPeminjam(){
        String option;

        controllerMember.tampilkanDataPeminjaman();

        System.out.print("kembali[y/n] :");
        option = scan.next();

        if (option.equalsIgnoreCase("y")) {
            pilihanMenu();
        } else {
            tambahPeminjam();
        }
    }
}
