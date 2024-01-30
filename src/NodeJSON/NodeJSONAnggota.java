package NodeJSON;

public class NodeJSONAnggota {
    private String idAnggota, nama, noTelp, alamat,judulBuku;

    public NodeJSONAnggota() {
        this.idAnggota = "idAnggota";
        this.nama = "nama";
        this.noTelp = "noTelp";
        this.alamat = "alamat";
        this.judulBuku = "judulBuku";
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

//    public String getJudulBuku() {
//        return judulBuku;
//    }
}
