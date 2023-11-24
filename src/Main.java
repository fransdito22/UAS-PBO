import View.FormLogin;

public class Main {
    public static void main(String[] args) {
        FormLogin admin1 = new FormLogin("Admin","Admin123");

            displayDasboard();
            admin1.verifikasiLogin();
    }

    public static void displayDasboard(){
        System.out.println("============================================");
        System.out.println("     PROGRAM PENGELOLAAN PERPUSTAKAAN       ");
        System.out.println("--------------------------------------------");
    }
}