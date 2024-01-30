// ControllerPeminjaman.java

package Controller;

import Model.ModelJSONAnggota;
import Model.ModelJSONBuku;
import Node.NodeAnggota;
import Node.NodeBuku;

import java.util.ArrayList;

public class ControllerPeminjaman {
    private final ModelJSONAnggota modelJSONAnggota = new ModelJSONAnggota();
    private final ModelJSONBuku modelJSONBuku = new ModelJSONBuku();

    public void tambahPeminjam(String idAnggota, String nama, String noTelp, String alamat, String judulBuku) {
        NodeBuku buku = modelJSONBuku.readBySeachTitle(judulBuku);
        if (buku != null) {
            modelJSONBuku.decreaseStok(judulBuku);
            try {
                NodeAnggota anggota = new NodeAnggota(idAnggota, nama, noTelp, alamat, buku);
                modelJSONAnggota.create(anggota);
                System.out.println("Buku berhasil dipinjam");
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            System.out.println("Judul buku tidak ditemukan");
        }
    }

    public ArrayList<NodeAnggota> tampilkanPeminjaman() {
        try {
            return modelJSONAnggota.read();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean pengembalianBuku(String id, String judul) {
        boolean cekNamaMember = false;
        if (modelJSONAnggota.searchMemberbyId(id)) {
            modelJSONBuku.increaseStok(judul);
            modelJSONAnggota.delete(id);
            cekNamaMember = true;
        }
        return cekNamaMember;
    }
}
