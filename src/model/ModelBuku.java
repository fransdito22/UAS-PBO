package model;

import Node.NodeBuku;
import Db.Db;
public class ModelBuku {
    int inc_kode = 1;


    public void insertBook(String judul, String pengarang, int tahun) {
        int index = this.inc_kode;
        NodeBuku obj = new NodeBuku(index, judul, pengarang, tahun);
//        this.books.add(obj);
        Db.books.add(obj);
        this.inc_kode++;
    }

    public void viewbooks() {
        for (NodeBuku book : Db.books) {
            book.viewBuku();
            System.out.println("-------------------");
        }
    }

    public void updateBook(String nama,int jumlah) {
        for (NodeBuku book : Db.books) {
            if (nama.equals(book.getJudul_buku())) {
                book.updateStok(jumlah);
            }
        }
    }

    public void deleteBook(String judul) {
        for (int i = 0; i < Db.books.size(); i++) {
            if (judul.equals(Db.books.get(i).getJudul_buku())) {
                Db.books.remove(i);
            }
        }
    }
}