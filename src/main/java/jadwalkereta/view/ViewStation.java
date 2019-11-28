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
        pilihan = Integer.valueOf(input.nextLine());
    }

    public void menuTambah() {
        System.out.println("#TAMBAH DATA STASIUN#");
        System.out.print("Tambah Stasiun : ");
        String request = input.nextLine();
        if(request.split(" ").length!=2)
        {
            System.out.println("Inputan Salah, masukkan Kode dan NamaKota");
            System.out.println();
        }else{
            String kode = request.substring(0,request.indexOf(' '));
            String nama = request.substring(request.indexOf(' ')+1);
            ctrStation.TambahStation(kode, nama);
        }
        
    }

    public void menuDelete() {
        System.out.println("#DELETE DATA STASIUN#");
        System.out.print("Delete Stasiun : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];
            int index = ctrStation.CheckStation(kode);
            if (index >= 0) {
                int StasiunJalur  = ctrStation.CheckStationJalur(kode);
                if(StasiunJalur < 0)
                {
                    ctrStation.DeleteStation(index);
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Stasiun Berhasil Dihapus");
                    System.out.println("--------------------------------------------------------------");
                }else{
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Tidak Bisa di Delete, Stasiun Terhubung dengan Jalur Stasiun Rute");
                    System.out.println("----------------------------------------------------------------------");
                }
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Stasiun Tidak Ada / Gagal Dihapus");
                System.out.println("--------------------------------------------------------------");
            }
               
        }else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : DELETE_KODE STASIUN");
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
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];	
            int index = ctrStation.CheckStation(kode);

            if (index >= 0) {
                ctrStation.DeleteStation(index);
                System.out.print("Kode Stasiun : ");
                kode = input.nextLine();
                System.out.print("Nama Stasiun : ");
                String nama = input.nextLine();
                ctrStation.TambahStation(kode, nama);

            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Stasiun Gagal Ditambahkan");
                System.out.println("--------------------------------------------------------------");
            }
        }else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : EDIT_KODE STASIUN");
            System.out.println("--------------------------------------------------------------");
        }

    }

    public int getPilihan() {
        return pilihan;
    }
}