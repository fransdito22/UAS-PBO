package Node;

public class NodeAnggota {
    private String idAnggota, nama, noTelp, alamat;
    private NodeBuku buku;

    public NodeAnggota(String idAnggota, String nama, String noTelp,  String alamat,NodeBuku buku) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.buku = buku;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public NodeBuku getBuku() {
        return buku;
    }
}