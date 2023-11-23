package Model;
import Node.NodeMember;
import Db.Db;

public class ModelMember {
    public void insertMember(String namaPeminjam, String tanggalPengembalian) {
        NodeMember nodeMember = new NodeMember(namaPeminjam,tanggalPengembalian);
        Db.members.add(nodeMember);
    }
    public void viewMember() {
        for (NodeMember member : Db.members) {
            member.viewMember();
            System.out.println("-------------------");
        }
    }
}
