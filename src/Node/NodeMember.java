package Node;

public class NodeMember {
    String namaPeminjam;
    String tanggalPeminjaman;

    public NodeMember(String namaPeminjam,String tanggalPeminjaman){
        this.namaPeminjam = namaPeminjam;
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public void viewMember() {
        System.out.println("Nama member : " + namaPeminjam);
        System.out.println("Tanggal peminjaman : " + tanggalPeminjaman);
    }
}
