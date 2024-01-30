// ControllerBuku.java

package Controller;

import Model.ModelJSONBuku;
import Node.NodeBuku;

import java.util.ArrayList;

public class ControllerBuku {
   private ModelJSONBuku modelJSONBuku = new ModelJSONBuku();

   public void tambahBuku(String kode_buku, String judul_buku, String pengarang, int tahun_terbit, int stok) {
      NodeBuku buku = new NodeBuku(kode_buku, judul_buku, pengarang, tahun_terbit, stok);
      modelJSONBuku.create(buku);
   }

   public ArrayList<NodeBuku> tampilkanBuku() {
      try {
         return modelJSONBuku.read();
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   public boolean updateBuku(String kode_buku, String judul_buku, String pengarang, int tahun_terbit, int stok) {
      boolean cekKodeBuku = false;
      if (modelJSONBuku.searchBookbyCode(kode_buku)) {
         NodeBuku buku = new NodeBuku(kode_buku, judul_buku, pengarang, tahun_terbit, stok);
         modelJSONBuku.update(buku);
         cekKodeBuku = true;
      }
      return cekKodeBuku;
   }

   public boolean hapus(String kodeBuku) {
      boolean cekKodeBuku;
      if (modelJSONBuku.searchBookbyCode(kodeBuku)) {
         modelJSONBuku.delete(kodeBuku);
         cekKodeBuku = true;
      } else {
         cekKodeBuku = false;
      }
      return cekKodeBuku;
   }

   public NodeBuku tampilkanBukuByJudul(String judul) {
      try {
         return modelJSONBuku.readBySeachTitle(judul);
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }
}
