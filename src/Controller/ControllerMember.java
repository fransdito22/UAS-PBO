package Controller;
import Model.ModelMember;
import  Model.ModelBuku;

public class ControllerMember {
    ModelMember modelMember = new ModelMember();
    ModelBuku modelBuku = new ModelBuku();
    public void tambahPeminjam(String namaPeminjam,String tamggalPeminjaman,String judul){
        modelMember.insertMember(namaPeminjam,tamggalPeminjaman);
        modelBuku.decreaseStock(judul);
    }

    public void tampilkanDataPeminjaman(){
    modelMember.viewMember();
    modelBuku.viewbooks();
    }
}
