package Controller;

import model.ModelBuku;

public class ControllerBuku {
    ModelBuku modelBuku = new ModelBuku();
    public void isiDataBuku(String judul, String pengarang, int tahun)
    {
        modelBuku.insertBook(judul, pengarang, tahun);
    }

    public void tamplikanDataBuku()
    {

        modelBuku.viewbooks();
    }

    public void updateDataBuku(String nama,int jumlah)
    {
        modelBuku.updateBook(nama,jumlah);
    }

    public void hapusDataBuku(String judul){
        modelBuku.deleteBook(judul);
    }
}