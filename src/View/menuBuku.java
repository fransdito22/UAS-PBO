package View;
import Controller.ControllerBuku;
import model.ModelBuku;

import java.util.Objects;
import java.util.Scanner;

public class menuBuku {
        Scanner scan = new Scanner(System.in);

    public void pilihanMenu(){
        int pilihan;
        boolean exit = false;

        ControllerBuku controllerBuku = new ControllerBuku();

            displayMenu();//menampilkan pilihan mainMenu.menu
            System.out.print("Masukkan pilihan [1,2,3,4,5] : ");
            pilihan = scan.nextInt();
        while (!exit){

            switch (pilihan){
                case 1 :
                    tambahBuku(controllerBuku);
                    break;
                case 2 :
                    tampilkanBuku(controllerBuku);
                    break;
                case 3 :
                    updateBuku(controllerBuku);
                    break;
                case 4 :
                   hapusBuku(controllerBuku);
                   break;
                case 5 :
                    System.out.println("Terima kasih");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan Anda salah");
                    pilihanMenu();//jika pilihan salah kembali memasukkan pilihan
            }
        }
    }

    public void displayMenu(){
        System.out.println("Masukkan pilihan: \n1.Tambah buku\n2.Tampilkan buku\n3.Tambah stok\n4.Hapus buku\n5.Exit");
    }

public void tambahBuku(ControllerBuku controllerBuku){
    String judul,pengarang,option;
    int tahun;

    System.out.print("Masukkan judul buku     : ");
    scan.nextLine();
    judul = scan.nextLine();
    System.out.print("Masukkan Nama Pengarang : ");
    pengarang = scan.nextLine();
    System.out.print("Masukkan tahun terbit   : ");
    tahun = scan.nextInt();
//    ControllerBuku controllerBuku = new ControllerBuku();
    controllerBuku.isiDataBuku(judul, pengarang, tahun);
//    buku.insertBook(judul,pengarang,tahun);
//    opsi kembali
    System.out.print("Tambah buku lagi[y/n] :");
    option = scan.next();

    if ((Objects.equals(option, "y") || Objects.equals(option, "Y"))) {
        tambahBuku(controllerBuku);
    } else {
        pilihanMenu();
    }
}
public void tampilkanBuku(ControllerBuku controllerBuku){
    String option;
    controllerBuku.tamplikanDataBuku();

    //    ControllerBuku controllerBuku = new ControllerBuku();

//    opsi kembali
    System.out.print("Kembali [y/n] : ");
    option = scan.next();
    if (Objects.equals(option, "y")||Objects.equals(option,"Y")){
        pilihanMenu();
    } else {
        tampilkanBuku(controllerBuku);
    }
}
public void updateBuku(ControllerBuku controllerBuku) {
    String nama;
    int jumlah;
    System.out.println("Judul buku  : ");
    nama = scan.nextLine();
    System.out.print("jumlah buku : ");
    jumlah = scan.nextInt();

    controllerBuku.updateDataBuku(nama,jumlah);
}
public void hapusBuku(ControllerBuku controllerBuku){
    String judul;
    System.out.print("Judul buku yang ingin di hapus : ");
    judul = scan.next();
    controllerBuku.hapusDataBuku(judul);
    System.out.println("Buku berhasil dihapus");
}

}
