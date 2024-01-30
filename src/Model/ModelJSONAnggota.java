package Model;

import Node.NodeAnggota;
import Node.NodeBuku;
import NodeJSON.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ModelJSONAnggota {
    String fname = "src/Database/DatabaseAnggota.json";
    NodeJSONAnggota nodeJSONAnggota = new NodeJSONAnggota();
    ModelJSONBuku modelJSONBuku = new ModelJSONBuku();

    public boolean cekFile() {
        boolean cek = false;
        try {
            java.io.File file = new java.io.File(fname);
            if (file.exists()) {
                cek = true;
            }
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
        return cek;
    }

    public JSONArray convertArrayListToArrayJSON(ArrayList<NodeAnggota> listAnggota) {
        if (listAnggota == null) {
            return null;
        } else {
            JSONArray arrayAnggota = new JSONArray();
            for (NodeAnggota anggota : listAnggota) {
                JSONObject objAnggota = new JSONObject();
                objAnggota.put(nodeJSONAnggota.getIdAnggota(), anggota.getIdAnggota());
                objAnggota.put(nodeJSONAnggota.getNama(), anggota.getNama());
                objAnggota.put(nodeJSONAnggota.getNoTelp(), anggota.getNoTelp());
                objAnggota.put(nodeJSONAnggota.getAlamat(), anggota.getAlamat());
                arrayAnggota.add(objAnggota);

                // Menambahkan data dari database buku
                NodeBuku buku = anggota.getBuku();
                if (buku != null) {
                    JSONObject objBuku = new JSONObject();
                    objBuku.put("kodeBuku", buku.getKodeBuku());
                    objBuku.put("judulBuku", buku.getJudulBuku());
                    objBuku.put("pengarang", buku.getPengarang());
                    objBuku.put("tahunTerbit", buku.getTahunTerbit());
                    objAnggota.put("buku", objBuku);
                }
            }
            return arrayAnggota;
        }
    }

    public void writeFileJSON(ArrayList<NodeAnggota> listAnggota) {
        JSONArray jsonArray = convertArrayListToArrayJSON(listAnggota);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<NodeAnggota> convertArrayJSONToArraylist(JSONArray arrayAnggota) {
        if (arrayAnggota == null || arrayAnggota.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<NodeAnggota> listAnggota = new ArrayList<>();
        for (Object objAnggota : arrayAnggota) {
            if (objAnggota instanceof JSONObject) {
                JSONObject anggotaJSON = (JSONObject) objAnggota;
                String idAnggota = anggotaJSON.get(nodeJSONAnggota.getIdAnggota()).toString();
                String nama = anggotaJSON.get(nodeJSONAnggota.getNama()).toString();
                String noTelp = anggotaJSON.get(nodeJSONAnggota.getNoTelp()).toString();
                String alamat = anggotaJSON.get(nodeJSONAnggota.getAlamat()).toString();


                if (anggotaJSON.containsKey("buku")) {
                    JSONObject bukuJSON = (JSONObject) anggotaJSON.get("buku");

                    String judul = bukuJSON.get("judulBuku").toString();
                    NodeBuku buku = modelJSONBuku.readBySeachTitle(judul);

                    listAnggota.add(new NodeAnggota(idAnggota, nama, noTelp, alamat, buku));
                } else {
                    listAnggota.add(new NodeAnggota(idAnggota, nama, noTelp, alamat, null));
                }
            }
        }
        return listAnggota;
    }


    public ArrayList<NodeAnggota> readFromFile() {
        if (!cekFile()) {
            return new ArrayList<>();
        }
        ArrayList<NodeAnggota> listAnggota = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayAnggota = (JSONArray) parser.parse(reader);
            listAnggota = convertArrayJSONToArraylist(arrayAnggota);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return listAnggota;
    }

    public void create(NodeAnggota anggota) {
        ArrayList<NodeAnggota> listAnggota = readFromFile();
        listAnggota.add(anggota);
        writeFileJSON(listAnggota);
    }

    public ArrayList<NodeAnggota> read() {
        return readFromFile();
    }

    public void delete(String idAnggota){
        ArrayList<NodeAnggota> listAnggota = readFromFile();
        if (listAnggota != null){
            listAnggota.removeIf(anggota -> Objects.equals(anggota.getIdAnggota(), idAnggota));
            writeFileJSON(listAnggota);
        }
    }

    public boolean searchMemberbyId(String idAnggota) {
        ArrayList<NodeAnggota> listAnggota = readFromFile();
        for (NodeAnggota member : listAnggota) {
            if (idAnggota.equals(member.getIdAnggota())) {
                return true;
            }
        }
        return false;
    }
}
