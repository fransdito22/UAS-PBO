package View;
import Controller.ControllerBuku;
import org.jetbrains.annotations.NotNull;


import java.util.Objects;
import java.util.Scanner;

public class MenuBuku {
        Scanner scan = new Scanner(System.in);

    public void pilihanMenu(){
        int pilihan;

        ControllerBuku controllerBuku = new ControllerBuku();
        MainMenu mainMenu = new MainMenu();

            displayMenu();//menampilkan pilihan mainMenu.menu
            System.out.print("Masukkan pilihan [1,2,3,4,5] : ");
            pilihan = scan.nextInt();
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
                    mainMenu.pilihanMenu();
                    break;
                default:
                    System.out.println("Pilihan Anda salah");
                    pilihanMenu();//jika pilihan salah kembali memasukkan pilihan
            }
        }

    public void displayMenu(){
        System.out.println("Masukkan pilihan: \n1.Tambah buku\n2.Tampilkan buku\n3.Tambah stok\n4.Hapus buku\n5.Exit");
    }

//    fungsi-fungsi yang dipanggil di dalam switch case
public void tambahBuku(@NotNull ControllerBuku controllerBuku){

    String judul,pengarang,option;
    int tahun;

    do {
    System.out.print("Masukkan judul buku     : ");
    scan.nextLine();
    judul = scan.nextLine();
    System.out.print("Masukkan Nama Pengarang : ");
    pengarang = scan.nextLine();
    System.out.print("Masukkan tahun terbit   : ");
    tahun = scan.nextInt();

    controllerBuku.isiDataBuku(judul, pengarang, tahun);

//    opsi kembali
    System.out.print("Tambah buku lagi[y/n] :");
    option = scan.next();
    }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));


}
public void tampilkanBuku(@NotNull ControllerBuku controllerBuku){
    String option;

    do {
    controllerBuku.tamplikanDataBuku();
//    opsi kembali
    System.out.print("Kembali [y/n] : ");
    option = scan.next();
    }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));

}
public void updateBuku(@NotNull ControllerBuku controllerBuku) {
    String nama,option;
    int jumlah;
    do {
    System.out.print("Judul buku  : ");
    scan.nextLine();
    nama = scan.nextLine();
    System.out.print("jumlah buku : ");
    jumlah = scan.nextInt();

    controllerBuku.updateDataBuku(nama,jumlah);
    //    opsi kembali
    System.out.print("Kembali [y/n] : ");
    option = scan.next();
    }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));
}
public void hapusBuku(@org.jetbrains.annotations.NotNull ControllerBuku controllerBuku){
    String judul,option;
    do {
    System.out.print("Judul buku yang ingin di hapus : ");
    judul = scan.next();
    controllerBuku.hapusDataBuku(judul);
    System.out.println("Buku berhasil dihapus");
    //    opsi kembali
    System.out.print("Kembali [y/n] : ");
    option = scan.next();
    }while (Objects.equals(option, "y") || Objects.equals(option, "Y"));
}

}
