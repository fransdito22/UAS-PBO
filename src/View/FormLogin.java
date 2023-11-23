package View;

import java.util.Objects;
import java.util.Scanner;

public class FormLogin {
    String namaAdmin;
    String pass;

    public FormLogin(String namaAdmin, String pass){
        this.namaAdmin = namaAdmin;
        this.pass = pass;
    }
    public void verifikasiLogin(){
        Scanner scan = new Scanner(System.in);
        mainMenu mainMenu = new mainMenu();//inisialisasi objek mainMenu.menu
        String nama;
        String pass;
        System.out.println("FORM LOGIN\n-------------");
        //input nama dan pasword untuk verifikasi
        System.out.print("Masukkan nama     : ");
        nama = scan.nextLine();
        System.out.print("Masukkan password : ");
        pass = scan.nextLine();
        //pengujian verifikasi login jika nama dan password benar akan lanjut ke mainMenu.menu
        if (Objects.equals(nama, this.namaAdmin) && Objects.equals(pass,this.pass)){
            System.out.println("Selamat datang " + this.namaAdmin);
            mainMenu.pilihanMenu();
        } else {
            System.out.println("Nama atau password anda salah coba lagi");
            verifikasiLogin();//jika nama atau password salah kembali memasukkan nama & password
        }
    }
}
