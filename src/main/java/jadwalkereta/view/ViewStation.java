package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewStation {
    private int pilihan;
    ControllerStation ctrStation;
    Scanner input = new Scanner(System.in);

    public ViewStation(ControllerStation ctrStation) {
        this.ctrStation = ctrStation;
    }

    public void menuStation() {
        System.out.println("#KELOLA DATA Stasiun#");
        System.out.println("1.  Tambah Data Stasiun");
        System.out.println("2.  Lihat Data Stasiun");
        System.out.println("3.  Edit Data Stasiun");
        System.out.println("4.  Delete Data Stasiun");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public void menuTambah() {
        System.out.println("#TAMBAH DATA STASIUN#");
        System.out.print("Tambah Stasiun : ");
        String request = input.next();
        String kode = request.substring(0,request.indexOf(' '));
        String nama = request.substring(request.indexOf(' ')+1);
        ctrStation.TambahStation(kode, nama);
    }

    public void menuDelete() {
        System.out.println("#DELETE DATA STASIUN#");
        System.out.print("Delete Stasiun : ");
        String kode = input.next().split("_", 2)[1];
        int index = ctrStation.CheckStation(kode);
        if (index >= 0) {
            ctrStation.DeleteStation(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Gagal Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void menuLihat() {
        System.out.println("#LIHAT DATA STASIUN#");
        System.out.println("Data Lengkap Stasiun");
        System.out.println("--------------------------------------------------------------");
        System.out.println("No\tKode\t\tNama");
        ctrStation.LihatStation();
        System.out.println("--------------------------------------------------------------");
    }

    public void menuEdit() {
        System.out.println("#EDIT DATA STASIUN#");
        System.out.print("Edit Stasiun : ");
        String kode = input.next().split("_", 2)[1];
        int index = ctrStation.CheckStation(kode);

        if (index >= 0) {
            ctrStation.DeleteStation(index);
            System.out.print("Kode Stasiun : ");
            kode = input.next();
            System.out.print("Nama Stasiun : ");
            String nama = input.next();
            ctrStation.TambahStation(kode, nama);

        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public int getPilihan() {
        return pilihan;
    }
}