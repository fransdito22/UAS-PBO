package Node;

public class NodeBuku {
    int kode_buku;
    String judul_buku;
    String pengarang;
    int tahun_terbit;
    int stok;

    public NodeBuku(int kode_buku, String judul_buku, String pengarang, int tahun_terbit) {
        this.kode_buku = kode_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tahun_terbit = tahun_terbit;
        this.stok = 0;
    }

    public void viewBuku() {
        System.out.println("kode buku : " + kode_buku);
        System.out.println("judul buku : " + judul_buku);
        System.out.println("pengarang buku : " + pengarang);
        System.out.println("tahun terbit buku : " + tahun_terbit);
        System.out.println("stok buku : " + stok);
    }

    public void updateStok(int newStok) {
        this.stok = this.stok + newStok;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public int getStok() {
        return stok;
    }

    public void decreaseStok(int jumlahBuku) {
        if (jumlahBuku > 0 && stok >= jumlahBuku) {
            stok -= jumlahBuku;
        } else {
            System.out.println("Stok buku kosong");
        }
    }
}