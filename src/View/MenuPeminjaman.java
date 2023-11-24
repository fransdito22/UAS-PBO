package View;

import java.util.Objects;
import java.util.Scanner;
import  Controller.ControllerMember;

public class MenuPeminjaman {
    ControllerMember controllerMember = new ControllerMember();
    MainMenu mainMenu = new MainMenu();
    Scanner scan = new Scanner(System.in);

    public void pilihanMenu(){
        int pilihan;

        displayMenuPeminjam();
        System.out.print("Masukkan pilihan [1,2,3,] : ");
        pilihan = scan.nextInt();

            switch (pilihan){
                case 1 :
                    System.out.println("PEMINJAMAN BUKU");
                    tambahPeminjam();
                    break;
                case 2 :
                    System.out.println("TAMPILKAN DATA PEMINJAM");
                    tampilkanPeminjam();
                    break;
                case 3 :
                    mainMenu.pilihanMenu();
                    break;
                default:
                    System.out.println("Pilihan Anda salah");
                    pilihanMenu();//jika pilihan salah kembali memasukkan pilihan
            }
        }

//method untuk menampilkan tampilan
    public void displayMenuPeminjam(){
        System.out.println("Masukkan pilihan: \n1.Peminjaman buku\n2.Tampilkan data peminjam\n3.Exit");
    }

    void tambahPeminjam(){
        String namaPeminjam ,tanggalPeminjaman,judul,option;

        do {
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
        }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));

    }
    void tampilkanPeminjam(){
        String option;

        do {
        controllerMember.tampilkanDataPeminjaman();
        System.out.print("kembali[y/n] :");
        option = scan.next();

        }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));

    }
}
